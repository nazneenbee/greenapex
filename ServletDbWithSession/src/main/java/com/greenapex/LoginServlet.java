package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	int count=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter(); 
        
		String semail = request.getParameter("semail");
        String spassword = request.getParameter("spassword");
        DatabaseConnection dc=new DatabaseConnection();
		Connection con=dc.jdbcConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from student where stemail=? and stpassword=?");
			ps.setString(1, semail);                          
	        ps.setString(2, spassword);
	        ResultSet rs =ps.executeQuery( );
	        
	        if(rs.next()==true)
	        {
	           HttpSession hs=request.getSession(true);
	 		   hs.setAttribute("email", semail);
	 		   hs.setAttribute("password", spassword);
	 		     hs.setMaxInactiveInterval(10);//set the maximum inactive interval
	 		    
	 		    	RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
		        	
		        	rd.forward(request, response);
	 		   
		    }
	        else
	        { 
	        	out.print("<h1 style='color:red'>");
	        	 out.print("Enter valid email and password");
	        	 out.print("</h1>");
	        	 
	        	RequestDispatcher rd=request.getRequestDispatcher("login.html");   
	        	rd.include(request, response);
	        }
	        
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
    }
}
