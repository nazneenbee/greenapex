package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//int count=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        HttpSession session=request.getSession(false); 
        //String param1 = (String) session.getAttribute("email");
        int timeout = 10;
        
        session.setMaxInactiveInterval(timeout);
        response.setHeader("Refresh", timeout + "; URL=login.html");
       
        if(session!=null)
        {
        String e=(String)session.getAttribute("email"); 
       // String p=(String) session.getAttribute("password");
        
        //count++;
        out.print("Hello "+e); 
        out.print("<a href='Welcome.html'>");
        out.print(" Welcome"); 
        out.print("</a>");
        }
        
          
        out.close();  
	}

}
