

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Act1JavaPage1
 */
public class Act1JavaPage1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("user");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String users=request.getParameter("users");
		String emails = request.getParameter("emails");
		String passs = request.getParameter("passs");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ibm");
		 
		
		 PreparedStatement pd = con.prepareStatement("insert into news values(?,?,?)");
		 
			
			pd.setString(1,request.getParameter("users") );
			 pd.setString(2, request.getParameter("emails"));
			 pd.setString(3, request.getParameter("passs"));
			 //ResultSet rs = s.executeQuery("select * from news");
				//int flag=0;
				
				  pd.executeUpdate(); 

			//out.println("Register Successfully");
		 
			Statement s = con.createStatement();
		 
		ResultSet rs = s.executeQuery("select * from news");
		//int flag=0;
		while(rs.next())
		{
			if(rs.getString(1).equals(name) && rs.getString(2).equals(email) && rs.getString(3).equals(pass)) {
			
				out.println("Login successfull");
				
			}
			
		
		}
		
		
		 con.close(); 
		 
}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	
		
		
	}

}
