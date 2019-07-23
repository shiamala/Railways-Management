

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

public class FinalBook extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter po=response.getWriter();
		String Name=request.getParameter("Name");
		String Age=request.getParameter("Age");
		String TrainNo=request.getParameter("TrainNo");
		
		PrintWriter p=response.getWriter();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
	
		 PreparedStatement pd = con.prepareStatement("insert into bookednames values(?,?,?)");
		 pd.setString(1,request.getParameter("Name") );
		 pd.setString(2, request.getParameter("Age"));
		 pd.setString(3, request.getParameter("TrainNo"));
		 
	
		 pd.executeUpdate();
		
		response.sendRedirect("Finish.html");
		con.close(); 
		 
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		p.println("<br><a href=Finish.html>Confirm Booking</a><br>");
		 
	
	}

}
