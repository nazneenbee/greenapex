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

@WebServlet("/UpdateDataServlet")
public class UpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
	        rd.forward(request, response); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
