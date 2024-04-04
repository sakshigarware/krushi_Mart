package jdbc_Krushimart_sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/profile")
public class ProfileController extends HttpServlet{
	
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String email=req.getParameter("email");
    	CRUD crud=new CRUD();
    	try {
			Registration register=crud.getProfile(email);
			if(register!=null)
			{
				HttpSession httpSession=req.getSession();
				String mail=(String) httpSession.getAttribute("session");
				if(email!=null)
				{
					req.setAttribute("regist",register);
					RequestDispatcher dispatcher=req.getRequestDispatcher("profile.jsp");
					dispatcher.forward(req, resp);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
}
