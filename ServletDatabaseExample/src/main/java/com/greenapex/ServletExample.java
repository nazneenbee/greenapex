package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet("/ServletExample")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
		int count=0;
		try {
			//int stid=Integer.parseInt(request.getParameter("stid1"));
			PreparedStatement ps=con.prepareStatement("select *from student");
			 ResultSet rs = ps.executeQuery();
			 out.println("<table border=1 width=50% height=10%>");  
             out.println("<tr><th>St Id</th><th>Name</th><th>Cource</th><th>marks</th><tr>");  
			while(rs.next())
			{
				int id=rs.getInt("stid");
				String name= rs.getString("stname");
				String course=rs.getString("stcource");
				int marks=rs.getInt("stmarks");
				out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + course + "</td><td>" + marks + "</td></tr>"); 
				  
			}
			out.println("</table>");  
            out.println("</html></body>");
			
			count=ps.executeUpdate();
			con.close();
			if(count>0)
			{
				System.out.println("data Inserted successfully");
			}
			else
			{
				System.out.println("Data Not inserted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
  //Insert Data into database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(request.getParameter("stid")));
			ps.setString(2, request.getParameter("stname"));
			ps.setString(3, request.getParameter("stcourse"));
			ps.setInt(4, Integer.parseInt(request.getParameter("stmarks")));
			
			count=ps.executeUpdate();
			con.close();
			if(count>0)
			{
				System.out.println("data Inserted successfully");
			}
			else
			{
				System.out.println("Data Not inserted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//Update Data
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
		int count=0;
		try {
			int stid=Integer.parseInt(request.getParameter("stid"));
			PreparedStatement ps=con.prepareStatement("update student set stname=?, stcource=?, stmarks=? where stid="+stid);
			ps.setString(1, request.getParameter("stname"));
			ps.setString(2, request.getParameter("stcourse"));
			ps.setInt(3, Integer.parseInt(request.getParameter("stmarks")));
			
			count=ps.executeUpdate();
			con.close();
			if(count>0)
			{
				System.out.println("data Update successfully");
			}
			else
			{
				System.out.println("Data Not Update");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	//data deleted
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
		int count=0;
		try {
			int stid=Integer.parseInt(request.getParameter("stid"));
			PreparedStatement ps=con.prepareStatement("delete from student where stid="+stid);
		
			count=ps.executeUpdate();
			con.close();
			if(count>0)
			{
				System.out.println("data deleted successfully");
			}
			else
			{
				System.out.println("Data Not deleted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
