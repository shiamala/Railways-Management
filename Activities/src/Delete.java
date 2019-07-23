

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
		 
		// Statement s = con.createStatement();
		 
		// ResultSet rs = s.executeQuery("select * from act");
		 
		 PreparedStatement pd = con.prepareStatement("delete from railway where trainno=?");
		 pd.setString(1,"Rock1" );
		/* pd.setString(2, request.getParameter("TrainName"));
		 pd.setString(3, request.getParameter("Source"));
		 pd.setString(4, request.getParameter("Destination"));
		 pd.setString(5, request.getParameter("Departure"));
		 pd.setString(6, request.getParameter("Arrival"));*/
		 
		 pd.executeUpdate();
		 
		 con.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		out.println("<a href=Admin.html>Go Back</a>");

		
	}

}
