package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExample4
 */
@WebServlet("/ServletExample4")
public class ServletExample4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("get Request") ;
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		String ename=request.getParameter("ename");
		
		out.print(eid+" ") ;
		out.print(ename) ;
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/newdb","root","root");
			PreparedStatement ps=con.prepareStatement("insert into Persons values(?,?)");
			ps.setInt(1,eid);  
			ps.setString(2,ename);  
			ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
