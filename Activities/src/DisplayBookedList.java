

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayBookedList
 */
public class DisplayBookedList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter po=response.getWriter();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
	
		 Statement s = con.createStatement();
	
	ResultSet rs = s.executeQuery("select * from railway,bookednames where railway.trainno=bookednames.trainnum");
	//if(source.equals(request.getParameter("Source")) && dest.equals(request.getParameter("Destination"))&& arrival.equals(request.getParameter("Arrival") )) {
	po.println("<table border=2 width=100%><tr><th>TRAINNO</th><th>TRAINNAME</th><th>SOURCE</th><th>DESTINATION</th><th>DEPARTURE</th><th>ARRIVAL</th><th>DATE</th><th>NAME</th><th>AGE</th>");
	
		while(rs.next())
			{
		po.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td></tr>");
		
	
			}
		po.println("</table><br>");
		
		
	//}
	/*else {
		po.println("Trains not available");
	}*/
		con.close(); 
		 
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
		po.println("<a href=Admin.html>Go Back</a>");
	
	}

}
