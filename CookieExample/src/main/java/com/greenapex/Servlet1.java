package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("uname"); 
		    String c=request.getParameter("ucourse"); 
		    out.print("Welcome "+n);  
		  
		    Cookie ck1=new Cookie("uname",n);//creating cookie object 
		    Cookie ck2=new Cookie("ucourse",c);
		    
		    response.addCookie(ck1);//adding cookie in the response  
		    response.addCookie(ck2);
		    //creating submit button  
		    out.print("<form action='Servlet2' method='post'>");  
		    out.print("<input type='submit' value='Print'>");  
		    out.print("</form>");  
		          
		    out.close();  
		    
	}

}
