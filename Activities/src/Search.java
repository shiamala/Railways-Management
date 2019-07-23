

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Search extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter po=response.getWriter();
		String source=request.getParameter("Source");
		String dest=request.getParameter("Destination");
		String arrival=request.getParameter("Arrival");
		String date=request.getParameter("Date");

		String submit=request.getParameter("Search");
		String submit1=request.getParameter("Book");

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
	
		 Statement s = con.createStatement();
	
	ResultSet rs = s.executeQuery("select * from railway where source='"+source+"'and destination='"+dest+"' and dates='"+date+"'");
	//if(source.equals(request.getParameter("Source")) && dest.equals(request.getParameter("Destination"))&& arrival.equals(request.getParameter("Arrival") )) {
	po.println("<table border=2 width=100%><tr><th>TRAIN-NO</th><th>TRAIN-NAME</th><th>SOURCE</th><th>DESTINATION</th><th>DEPARTURE</th><th>ARRIVAL</th><th>DATE</th></tr>");
	
		while(rs.next())
			{
		po.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
		
	
			}
		po.println("</table><br>");
		
		po.println("<br><a href=Book.html>Book Tickets</a><br>");
		po.println("<br><a href=Search.html>Go back</a><br>");
	//	po.println("<br><a href=Search.html>Go back</a><br>");

	//}
	/*else {
		po.println("Trains not available");
	}*/
		con.close(); 
		 
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		 
	}

}
