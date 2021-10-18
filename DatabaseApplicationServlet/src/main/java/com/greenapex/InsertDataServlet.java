package com.greenapex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertDataServlet")
public class InsertDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

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
			RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
	        rd.forward(request, response);  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
