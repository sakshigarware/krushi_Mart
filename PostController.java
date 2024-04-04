package jdbc_Krushimart_sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/posting")
public class PostController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productname=req.getParameter("product_name");
		double price=Double.parseDouble(req.getParameter("price"));
		int qty=Integer.parseInt(req.getParameter("Qty"));
		String mail=req.getParameter("email_id");
		
		try {
			CRUD crud=new CRUD();
			int id=crud.getPostCount()+1;
			Post post=new Post();
			post.setId(id);
			post.setProduct(productname);
			post.setPrice(price);
			post.setQuatity(qty);
			HttpSession session=req.getSession();
			String email=(String)session.getAttribute("session");
			post.setEmail_Id(email);
			Registration register=new Registration();
			int count=crud.setPost(post);
			int id1=crud.getId(email);
			if(count!=0)
			{
				Login log=new Login();
				System.out.println(email);
				List<Post> list=crud.getProduct(email);
				req.setAttribute("ml",mail);
				req.setAttribute("system", list);
				req.setAttribute("systemreg", register);
				RequestDispatcher dispatcher=req.getRequestDispatcher("homepost.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
