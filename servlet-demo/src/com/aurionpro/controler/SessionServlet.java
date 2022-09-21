package com.aurionpro.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		System.out.println("Hello wolrd");
		PrintWriter out=response.getWriter();
		out.print("<h1>Hello Immanuel</h1>");
		
		ServletContext application = request.getServletContext();
		
		if (application.getAttribute("counter") == null) {
		application.setAttribute("counter", 0);
		}
	int count=(Integer)application.getAttribute("counter");

	int oldValue=(Integer)application.getAttribute("counter");
	application.setAttribute("counter", ++count);


	int newValue=(Integer)application.getAttribute("counter");
	out.print(oldValue);
	out.print(newValue);

	
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
