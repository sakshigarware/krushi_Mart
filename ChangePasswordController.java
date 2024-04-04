package jdbc_Krushimart_sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/change")
public class ChangePasswordController extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String email=req.getParameter("email");
    	String password=req.getParameter("password");
    	
    	CRUD crud=new CRUD();
    	try {
    		int count=crud.updatePassword(email, password);
    		if(count!=0)
    		{
    			RequestDispatcher dispatcher=req.getRequestDispatcher("buyerpost.jsp");
    			dispatcher.forward(req, resp);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
