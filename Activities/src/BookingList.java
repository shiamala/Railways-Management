

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookingList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
		 
		 Statement s = con.createStatement();
		 
		 ResultSet rs = s.executeQuery("select * from railway");
		 
out.println("<html><table><tr><th>Trainno<th><th>TrainName<th><th>Source</th><th>Destination</th><th>Departure</th><th>Arrival</th></tr></table></html>");

		 while(rs.next()) 
		 { 
			
			 String i = rs.getString(1);
				String j = rs.getString(2);
				String k = rs.getString(3);
				String l = rs.getString(4);
				String m = rs.getString(5);
				String n = rs.getString(6);
		out.println("<html><table><tr>"+"<td>"+i+"</td>"+"<td>"+j+"</td>"+"<td>"+k+"</td>"+"<td>"+l+"</td>"+"<td>"+m+"</td>"+"<td>"+n+"</td>"+"</tr></table></html>"); 
			
		 } 
		// out.println("</tr></table></html>"); 
		 
		 
		 
		 
		 
		 
		/* while(rs.next()) {
				String i = rs.getString(1);
				String j = rs.getString(2);
				String k = rs.getString(3);
				String l = rs.getString(4);
				String m = rs.getString(5);
				String n = rs.getString(6);
				out.println("<h1>" + i + "</h1>"+"<h1>" + j + "</h1>"+ "<h1>" + k + "</h1>"+"<h1>"+ l + "</h1>"+"<h1>"+ m + "</h1>"+"<h1>"+ n + "</h1>");
			}*/
		 
		/* PreparedStatement pd = con.prepareStatement("insert into act values(?,?,?)");
		 
		 pd.setString(1,request.getParameter("user") );
		 pd.setString(2, request.getParameter("emailid"));
		 pd.setString(3, request.getParameter("pass"));
		 
		 pd.executeUpdate();*/
		 
		 con.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		out.println("<a href=Admin.html>Go Back</a>");
		
	}

}
