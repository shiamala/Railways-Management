

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


public class PassengerRegister extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		String name = request.getParameter("Username");
		String email = request.getParameter("Emailid");
		String pass = request.getParameter("Password");
		
		
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
		 
		// Statement s = con.createStatement();
 PreparedStatement pd = con.prepareStatement("insert into passenger values(?,?,?)");
		 
		 pd.setString(1,request.getParameter("Username") );
		 pd.setString(2, request.getParameter("Emailid"));
		 pd.setString(3, request.getParameter("Password"));
		 Statement s = con.createStatement();
		 ResultSet rs = s.executeQuery("select * from passenger");
			//int flag=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(name) && rs.getString(2).equals(email)) {
				
					out.println("UserName and Email id already exists");
					
				}
			}
			  pd.executeUpdate(); 
				HttpSession session = request.getSession();
				RequestDispatcher ed= request.getRequestDispatcher("Login.html");
				ed.forward(request, response);
		 con.close(); 
		 
}catch(Exception e) {
			
			e.printStackTrace();
		}
	
	}

}
