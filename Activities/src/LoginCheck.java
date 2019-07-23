

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
HttpSession session = request.getSession();
		
String name = request.getParameter("Username");
String email = request.getParameter("Emailid");
String pass = request.getParameter("Password");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
	
		 
			Statement s = con.createStatement();
		 
		ResultSet rs = s.executeQuery("select * from passenger");
		int flag=0;
		while(rs.next())
		{
			if(rs.getString(2).equals(email) && rs.getString(3).equals(pass)) {
				
				RequestDispatcher ed= request.getRequestDispatcher("Search.html");
				ed.forward(request, response);
				flag++;
				}
			else if(flag==0){
			
				//HttpSession session = request.getSession();
				//RequestDispatcher pl= request.getRequestDispatcher("SignUp.html");
				//pl.forward(request, response);
				//response.sendRedirect("SignUp.html");
				out.println("Enter correct username and password");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp");
				rd.include(request, response);
				break;
			}
			}
			
		
	//	out.println("<br><a href=Search.html>Go back</a><br>");

		
		
		 con.close(); 
		 
}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	
	}

}
