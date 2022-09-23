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
    
	@Override
	public void init() throws ServletException {
		super.init();
		studentDBUtil=new StudentDBUtil(datasource);// this mrthod is called automatically and only o
													//ne time so we are crating object inside it 
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// injection here means dirrectly sending data
		//listStudents(request,response);
		String command=request.getParameter("command");
		System.out.println(command);
		System.out.println(request.getParameter("studentId"));
		
		if(command==null) {
			command="list";

		}
		
			switch(command) {
			case "add":
				addStudent(request,response);
				break;
			case "list":
				listStudents(request, response);
				break;
			case "load":
				loadStudent(request,response);
				break;
			case "update":
				updateStudent(request, response);
				break;
			case "delete":
				delteStudent(request, response);
				break;
			default:
				listStudents(request, response);
			}
			
	
		
		
	}

	
	private void delteStudent(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("studentId"));
		studentDBUtil.deletStudent(id);
		try {
			listStudents(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("studentId"));
//		Student student = studentDBUtil.getStudent(id);
		
		int id = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentDBUtil.getStudent(id);
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




	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String email=request.getParameter("email");

		Student tempStudent=new Student(firstName,lastName,email);
		studentDBUtil.addStudent(tempStudent);
		try {
			listStudents(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = studentDBUtil.getStudentList();
		
		//System.out.println(students.toString());
		
		request.setAttribute("studentList", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("View-Student-List.jsp");
		dispatcher.forward(request, response);	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
