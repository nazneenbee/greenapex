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

/**
 * Servlet implementation class DeleteDataServlet
 */
@WebServlet("/DeleteDataServlet")
public class DeleteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
	        rd.forward(request, response); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
