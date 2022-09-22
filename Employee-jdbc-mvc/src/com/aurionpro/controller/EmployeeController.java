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

import com.aurionpro.model.Employee;
import com.aurionpro.model.EmployeeDBUtil;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeController() {
        super();
    }

    @Resource(name = "jdbc/employee")
	private DataSource datasource;
    
    private  EmployeeDBUtil employeedbutil;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeedbutil=new EmployeeDBUtil(datasource);
		// injection here means dirrectly sending data
		List<Employee> employee = employeedbutil.getStudentList();
		
		System.out.println(employee.toString());
		request.setAttribute("employeeList",employee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Employee-List.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
