package com.aurionpro.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Authenticate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Hello World");
		out.print("<br>Firsrt Name:"+request.getParameter("fname")+"<br>");
		out.print("<br>Last Name: "+request.getParameter("lname")+"<br>");
		out.print("<br>Country: "+request.getParameter("country")+"<br>");
		out.print("<br>Gender: "+request.getParameter("gender")+"<br>");
		String[]lang=request.getParameterValues("language");
		out.print("Languages");
		for(String c:lang) {
			out.print("<br>"+c+"</br>");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
