package jdbc_Krushimart_sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/editposting")
public class EditPost extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("session");
		String product=req.getParameter("product_name");
		double price=Double.parseDouble(req.getParameter("price"));
		int qty=Integer.parseInt(req.getParameter("Qty"));
		try {
			Post post=new Post();
			post.setProduct(product);
			post.setPrice(price);
			post.setQuatity(qty);
			post.setEmail_Id(email);
			CRUD crud=new CRUD();
			int count=crud.updatePost(post);
			if(count!=0)
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("homepost.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
