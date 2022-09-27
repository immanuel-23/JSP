package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.model.Admin;
import com.aurionpro.model.AdminDBUtil;

import com.aurionpro.model.User;
import com.aurionpro.model.UserDBUtil;

@WebServlet("/BankController")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BankController() {
		super();

	}

	@Resource(name = "jdbc/bank")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {

		super.init();
		userDBUtil = new UserDBUtil(dataSource);
		adminDBUtil = new AdminDBUtil(dataSource);

	}

	private UserDBUtil userDBUtil;
	private AdminDBUtil adminDBUtil;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {

			command = "loginPage";
		}

		switch (command) {
		case "loginPage":
			loginPage(request, response);
			break;
		case "adminLogin":
			try {
				adminLogin(request, response);
			} catch (IOException | SQLException | ServletException e) {

				System.out.println(e);
			}
			break;
		case "userLogin":
			userLogin(request, response);
			break;

		default:
			break;
		}

	}

	private void loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

		dispatcher.forward(request, response);
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");

		User user = new User(userName, userPassword);
		User tempUser = userDBUtil.checkUser(user);
		RequestDispatcher dispatcher;

		if (tempUser != null) {

			HttpSession session = request.getSession();
			session.setAttribute("user", tempUser);

			//dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
			response.sendRedirect(request.getContextPath() + "/UserDashboardController");

		} else {
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	

	}

	private void adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		String adminUserName = request.getParameter("username");
		String adminPassword = request.getParameter("password");

		Admin admin = new Admin(adminUserName, adminPassword);

		Admin tempAdmin = adminDBUtil.checkAdmin(admin);
		RequestDispatcher dispatcher;

		if (tempAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", tempAdmin);
		
			//dispatcher = request.getRequestDispatcher("dashboard.jsp");
			response.sendRedirect(request.getContextPath() + "/AdminDashboardController");
			

		} else {
			dispatcher = request.getRequestDispatcher("login.jsp");
	
			dispatcher.forward(request, response);
		}
	
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
