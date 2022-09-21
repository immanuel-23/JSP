package com.aurionpro.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieController")
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Hey");
		Cookie cookies[] = request.getCookies();
		boolean isColorSet = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("color")) {
					String bgcolor = c.getValue();
					out.print(c.getName()+" : "+bgcolor);
				}

			}

		}
		if (!isColorSet) {
			Cookie thisCookie = new Cookie("color", "red");
			thisCookie.setMaxAge(7 * 24 * 60 * 60);
			response.addCookie(thisCookie);
			isColorSet = true;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
