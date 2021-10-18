package com.greenapex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get_req")
public class GetServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out=resp.getWriter();
		int a=10; int b=20;
		int c=a+b;
		out.print("Hello This is Get Servlet");
		out.print("\n");
		out.print(c);
		out.flush();
		out.close();
	}

}
