package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.model.Transaction;
import com.aurionpro.model.TransactionDBUtil;
import com.aurionpro.model.User;
import com.aurionpro.model.UserDBUtil;

@WebServlet("/UserDashboardController")
public class UserDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDashboardController() {
		super();

	}

	@Resource(name = "jdbc/bank")

	private DataSource dataSource;
	private UserDBUtil userDBUtil;
	private TransactionDBUtil transactionDBUtil;

	@Override
	public void init() throws ServletException {

		super.init();
		userDBUtil = new UserDBUtil(dataSource);
		transactionDBUtil = new TransactionDBUtil(dataSource);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {

			command = "displayDashboard";
		}
		System.out.println("command" + command);

		switch (command) {
		case "Transaction":
			displayTransactionForm(request,response);
			
			break;
		case "Passbook":
			displayPassbook(request,response);
//			response.sendRedirect(request.getContextPath() + "/user-passbook-page.jsp");
			break;

		case "update":
			updateUserDetail(request, response);
			break;
		case "Editprofile":
			userDisplayProfile(request, response);
			break;
		case "displayDashboard":
			displayDashboard(request, response);

			break;

		default:
			break;
		}

	}

	private void displayTransactionForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-transaction-page.jsp");

		dispatcher.forward(request, response);
	
		
	}

	private void displayPassbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User sessionUser = (User) session.getAttribute("user");
		int id = sessionUser.getUserId();
		
		
		List<Transaction> transactions = transactionDBUtil.getTransactions(id);
		request.setAttribute("transactionList", transactions);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-passbook-page.jsp");

		dispatcher.forward(request, response);
		
		
		
	}

	private void updateUserDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User tempuser = (User) session.getAttribute("user");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// double balance = Double.parseDouble(request.getParameter("balance"));
		double balance = tempuser.getBalance();

		User tempUser = new User(id, username, password, balance);

		System.out.println("update:-" + tempUser);
		userDBUtil.updateUser(tempUser);
		displayDashboard(request, response);

	}

	private void displayDashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");

		dispatcher.forward(request, response);

	}

	private void userDisplayProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User tempuser = (User) session.getAttribute("user");
		int id = tempuser.getUserId();

		User tempUser = userDBUtil.getUser(id);

		request.setAttribute("user", tempUser);
		System.out.println(tempUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-profile-edit.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
