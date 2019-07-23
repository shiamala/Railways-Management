

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		String au=request.getParameter("au");
		String ap=request.getParameter("ap");
		if((au.equals("123") )&& (ap.equals("123"))) {
			
			response.sendRedirect("Admin.html");		
			}
		else {
			out.println("Login Properly");
			
		}

	}

}
