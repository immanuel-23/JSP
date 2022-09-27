package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Admin;
import com.aurionpro.model.User;


@WebFilter("/logoutFilter")
public class logoutFilter implements Filter {


    public logoutFilter() {
       
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		
		
HttpServletRequest req=(HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		Object tempuser = (Object) session.getAttribute("user");
	
		
		if(tempuser!=null) {
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Loggin first");
		}
		
		
	

		
		

		

		
		
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
