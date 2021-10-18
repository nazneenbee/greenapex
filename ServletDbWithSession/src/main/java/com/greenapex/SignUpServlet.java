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
import javax.servlet.http.HttpSession;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("login")!=null)
		{
			response.sendRedirect("login.html");
		}
		else if(request.getParameter("signup")!=null)
		{
		DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
//		 HttpSession hs=request.getSession();
//		   hs.setAttribute("email", request.getParameter("email"));
//		   hs.setAttribute("password", request.getParameter("password"));
		   
		int count=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(request.getParameter("rollno")));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("password"));
			ps.setString(5, request.getParameter("course"));
			
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
			RequestDispatcher rd=request.getRequestDispatcher("login.html");   
        	rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


}
