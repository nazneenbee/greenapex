package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("ename"); 
	    int s=Integer.parseInt(request.getParameter("esalary")); 
	    out.print("Welcome "+n);  
	  
	  //  String s1=String.valueOf(s);
	   HttpSession hs=request.getSession();
	   hs.setAttribute("ename", n);
	   //hs.setAttribute("esalary", s1);
	    hs.setAttribute("esalary", s);
	    out.print("\n");
	    out.print("<form action='Servlet2' method='post'>"); 
	   out.print("<button>Show Data</button>");  
	   out.print("</form>"); 
	   
       out.close();    
	   
	}

}
