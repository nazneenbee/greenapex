package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectDataServlet
 */
@WebServlet("/SelectDataServlet")
public class SelectDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
	
		try {
			int stid=Integer.parseInt(request.getParameter("stid"));
			PreparedStatement ps=con.prepareStatement("select *from student where stid="+stid);
			 ResultSet rs = ps.executeQuery();
			 out.println("<table border=1 width=50% height=10%>");  
             out.println("<tr><th>St Id</th><th>Name</th><th>Cource</th><th>marks</th><tr>");  
			if(rs.next())
			{
				int id=rs.getInt("stid");
				String name= rs.getString("stname");
				String course=rs.getString("stcource");
				int marks=rs.getInt("stmarks");
				out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + course + "</td><td>" + marks + "</td></tr>"); 
				  
			}
			out.println("</table>");  
            out.println("</html></body>");
            RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
	        rd.include(request, response); 
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
