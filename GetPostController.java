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
@WebServlet("/d")
public class GetPostController extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	// TODO Auto-generated method stub
        	try {
        		HttpSession session=req.getSession();
    			String email=(String)session.getAttribute("session");
    			CRUD crud=new CRUD();
    			List<Post> list=crud.getPost(email);
        		if(list!=null)
        		{
        			
        			req.setAttribute("sys", list);
        			RequestDispatcher dispatcher=req.getRequestDispatcher("homepost.jsp");
        			dispatcher.forward(req, resp);
        		}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        }
  
}
