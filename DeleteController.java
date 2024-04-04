package jdbc_Krushimart_sevlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("session");
		String name=(String)req.getParameter("post");
		try {
			CRUD crud=new CRUD();
			int count=crud.deletepost(name);
			if(count!=0)
			{
				List<Post> list =crud.getProduct(email);
				RequestDispatcher dispatcher=req.getRequestDispatcher("homepost.jsp");
    			dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
