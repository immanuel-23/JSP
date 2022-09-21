package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// we wont create respone.get because we wont print here 
		String[]StudentNames= {"Immanuel","Rahul","Ashish","Ritesh","Shivam"};
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.jsp"); // this will take us to asp file
		request.setAttribute("StudentList", StudentNames);// we are setting request setAttribute and giving StudentNames 
		// we cant send directently  any thing to jsp but through RequestDispatcher
		dispatcher.forward(request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
