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
import com.mysql.cj.Session;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentController() {
		super();
	}

	@Resource(name = "jdbc/student")
	private DataSource dataSource;

	private StudentDBUtil studentDBUtil;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDBUtil = new StudentDBUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		if (command == null) {
			command = "list";
		}
//		String search =  request.getParameter("search");
//		String name = request.getParameter("sname");
//		System.out.println(search);
//		System.out.println(name);
//		System.out.println(request.getParameter("studentId"));

		switch (command) {
		case "add":
			addStudent(request, response);
			break;
		case "list":
			listStudents(request, response);
			break;
		case "load":
			loadStudent(request, response);
			break;
		case "update":
			updateStudent(request, response);
			break;
		case "delete":
			deleteStudent(request, response);
			break;
		case "search":
			searchStudent(request,response);
		default:
			listStudents(request, response);
		}
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("search");
//		if(name=="") {
//			listStudents(request, response);
//		}
//		List<Student> students = studentDBUtil.searchStudent(name);
//		if(students.isEmpty()) {
//			request.setAttribute("studentList", null);
//		} else {
//			request.setAttribute("studentList", students);
//			System.out.println("Searched students:" +students);//Outputs on console
//String name = request.getParameter("search");
//		if(name=="") {
//			listStudents(request, response);
//		}
//		List<Student> students = studentDBUtil.searchStudent(name);
//		if(students.isEmpty()) {
//			request.setAttribute("studentList", null);
//		} else {
//			request.setAttribute("studentList", students);
//			System.out.println("Searched students:" +students);//Outputs on console
//		}
		
		
		String name = request.getParameter("sname");
		List<Student>student=studentDBUtil.searchStudents(name);
		request.setAttribute("studentList", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Student-List.jsp");
		dispatcher.forward(request, response);
		
//		System.out.println(studentList.toString());
//		request.setAttribute("student", studentList);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
//		dispatcher.forward(request, response);
//	
		
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("studentId"));
		studentDBUtil.deletStudent(id);
		listStudents(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		Student tempStudent = new Student(firstName, lastName, email);
		studentDBUtil.addStudent(tempStudent);
		response.sendRedirect(request.getContextPath()+"/StudentController?command=list");
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentDBUtil.getStudent(id);
//		System.out.println(student);
		request.setAttribute("studentRecord", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");

		Student tempStudent = new Student(fname, lname, email, id);
		studentDBUtil.updateStudent(tempStudent);

		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Student> students = studentDBUtil.getStudentList();
		request.setAttribute("studentList", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Student-List.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		String command = request.getParameter("command");
		switch (command) {
		case "add":
			addStudent(request, response);
			break;
		default:
			listStudents(request, response);
		}
	}

}