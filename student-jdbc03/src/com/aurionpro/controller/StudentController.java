package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.Student;
import com.aurionpro.model.StudentDBUtil;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentController() {
        super();
    }

    @Resource(name = "jdbc/student")
	private DataSource datasource;
    
    private StudentDBUtil studentDBUtil;
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDBUtil=new StudentDBUtil(datasource);
		// injection here means dirrectly sending data
		List<Student> students = studentDBUtil.getStudentList();
		System.out.println(students.toString());
		request.setAttribute("studentList", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Student-List.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
