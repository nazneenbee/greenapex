package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	          
	        HttpSession session=request.getSession(false);  
	        String n=(String)session.getAttribute("ename"); 
	        int s=(int) session.getAttribute("esalary"); 
	        out.print("Hello "+n);  
	        out.print("your salary : "+s);  
	        out.close();  
	  
	}

}
