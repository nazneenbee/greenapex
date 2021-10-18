package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
@WebServlet("/ServletEx")
public class ServletEx extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out=resp.getWriter();
		out.print("First Servlet");
		//out.println("");
		//resp.sendRedirect("Second");
		RequestDispatcher rd=req.getRequestDispatcher("Second");  
		//servlet2 is the url-pattern of the second servlet  
		  
		rd.include(req, resp);
		out.flush();
		out.close();
	}

}
