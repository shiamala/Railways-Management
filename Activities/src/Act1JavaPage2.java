

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


public class Act1JavaPage2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String name = request.getParameter("user");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
		 
		// Statement s = con.createStatement();
 PreparedStatement pd = con.prepareStatement("insert into news values(?,?,?)");
		 
		 pd.setString(1,request.getParameter("user") );
		 pd.setString(2, request.getParameter("email"));
		 pd.setString(3, request.getParameter("pass"));
		 Statement s = con.createStatement();
		 ResultSet rs = s.executeQuery("select * from news");
			//int flag=0;
			while(rs.next())
			{
				if(rs.getString(1).equals(name) && rs.getString(2).equals(email)) {
				
					out.println("UserName and Email id already exists");
					
				}
			}
			  pd.executeUpdate(); 

		out.println("Register Successfully");
		 con.close(); 
		 
}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
