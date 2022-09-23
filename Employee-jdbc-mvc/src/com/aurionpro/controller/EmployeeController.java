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
	private EmployeeDBUtil employeedbutil;

	@Override
	public void init() throws ServletException {
		super.init();
		employeedbutil = new EmployeeDBUtil(datasource);// this mrthod is called automatically and only o
														// ne time so we are crating object inside it
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		System.out.println(request.getParameter("studentId"));

		if (command == null) {
			command = "list";

		}

		switch (command) {
		case "add":
			addEmployee(request, response);
			break;
		case "load":
			loadEmployee(request, response);
		case "list":
			listEmployee(request, response);
			break;
		case "update":
			updateEmployee(request, response);
			break;
		case "delete":
			deleteEmployee(request, response);
			break;

		default:
			listEmployee(request, response);
		}

//		List<Employee> employee = employeedbutil.getStudentList();
//		
//		System.out.println(employee.toString());
//		request.setAttribute("employeeList",employee);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Employee-List.jsp");
//		dispatcher.forward(request, response);
//		addEmployee(request,response);

	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("employeeId"));
		employeedbutil.deleteEmployee(id);
		listEmployee(request, response);

	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		Employee employee = employeedbutil.getEmployee(id);
		request.setAttribute("employeeRecord", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		String dept = request.getParameter("dept");
		int salary = Integer.parseInt((request.getParameter("sal")));
		
		Employee tempEmployee = new Employee(fName, lName, email, id, dept, salary);
		
		employeedbutil.updateEmployee(tempEmployee);

		listEmployee(request, response);



	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) {

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String department = request.getParameter("dept");
		int salary = Integer.parseInt((request.getParameter("sal")));

		Employee tempEmployee = new Employee(firstName, lastName, email,  department, salary);
		EmployeeDBUtil.addEmployee(tempEmployee);

		listEmployee(request, response);

	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Employee> employees = EmployeeDBUtil.getStudentList();

		// System.out.println(students.toString());

		request.setAttribute("employeeList", employees);

		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Employee-List.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
