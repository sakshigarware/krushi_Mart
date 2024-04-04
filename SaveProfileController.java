package jdbc_Krushimart_sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class SaveProfileController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Fname=req.getParameter("firstname");
    	String Lname=req.getParameter("lastname");
    	String email=req.getParameter("email");
    	String password=req.getParameter("password");
    	long phone=Long.parseLong(req.getParameter("phone"));
    	String role=req.getParameter("role");
    	
    	try {
    		CRUD crud=new CRUD();
    		int id=crud.getId(email);

			Registration registration=new Registration();
			registration.setUserid(id);
			registration.setFname(Fname);
			registration.setLname(Lname);
			registration.setEmailid(email);
			registration.setPhone(phone);
			registration.setPassword(password);
			registration.setRole(role);
			
			int count=crud.updateUser(registration);
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
