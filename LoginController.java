package jdbc_Krushimart_sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController extends HttpServlet{
	String email;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		this.email=email;
		Login log=new Login();
		log.setEmail(email);
		String password=req.getParameter("password");
		String dbpassword=null;
		try {
			   CRUD crud=new CRUD();
			   dbpassword=crud.login(email);
			   int id=crud.getId(email);
			   if(dbpassword!=null)
			   {
				   if(dbpassword.equals(password) && crud.getRole(email).equals("farmer"))
				   {
					   Registration register=new Registration();
					   List<Post> list=crud.getProduct(email);
					   HttpSession httpsession=req.getSession();
					   httpsession.setAttribute("session",email);
					   System.out.println(log.getEmail());
					   req.setAttribute("loged", log.getEmail());
					   req.setAttribute("system", list);
					   req.setAttribute("systemreg", register);
					   RequestDispatcher dipatcher=req.getRequestDispatcher("homepage.jsp");
					   dipatcher.forward(req, resp);
				   }
				   else if(dbpassword.equals(password) && crud.getRole(email).equals("buyer"))
				   {
					   Cookie cookie=new Cookie("useronfo",email);
					   resp.addCookie(cookie);
					   HttpSession httpsession=req.getSession();
					   httpsession.setAttribute("session",email);
					   List<Post> list=crud.getProduct(email);
					   req.setAttribute("loged", log.getEmail());
					   req.setAttribute("system", list);
					   RequestDispatcher dipatcher=req.getRequestDispatcher("buyerpost.jsp");
					   dipatcher.forward(req, resp);
				   }
			   }
			   else
			   {
				   RequestDispatcher dipatcher=req.getRequestDispatcher("welcome.jsp");
				   dipatcher.forward(req, resp);
			   }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
