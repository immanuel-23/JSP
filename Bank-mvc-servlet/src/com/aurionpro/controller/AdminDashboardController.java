package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.AdminDBUtil;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.TransactionDBUtil;
import com.aurionpro.model.User;
import com.aurionpro.model.UserDBUtil;

@WebServlet("/AdminDashboardController")
public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDashboardController() {
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
		System.out.println(command);

		if (command == null) {
			command = "displayDashboard";
		}

		switch (command) {

		case "displayDashboard":
			displayDashboard(request, response);
			break;
		case "list":
			listUsers(request, response);
			break;
		case "displayAddForm":
			displayAddForm(request,response);
			break;
		case "load":
			loadUser(request, response);
			break;
		case "update":
			updateUser(request, response);
			break;
		case "delete":
			deleteUser(request, response);
			break;
		case "search":
			searchUser(request, response);
			break;
		case "Users":
			listUsers(request, response);
			break;
			
		case "searchTransaction":
			searchTransaction(request, response);
			System.out.println("command=trans"+ command);
			break;
		case "Transactions":
			viewAllTransactions(request, response);
			System.out.println("command=trans"+ command);
			break;
		default:
			listUsers(request, response);
		}

	}


	private void searchTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("q");
		List<Transaction> transactions = transactionDBUtil.searchTransaction(query);
		if (query == "") {
			listUsers(request, response);
		}

		if (transactions.isEmpty()) {
			request.setAttribute("transactionList", null);
		} else {
			request.setAttribute("transactionList", transactions);
			System.out.println("Searched transactions:" + transactions);// Outputs on console
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-transaction-page.jsp");

		dispatcher.forward(request, response);
		
	}

	private void displayDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");

		dispatcher.forward(request, response);
	}

	private void displayAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-user-form.jsp");

		dispatcher.forward(request, response);
		
	}

	private void viewAllTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Transaction> transactions = transactionDBUtil.getTransactionsList();

		System.out.println("list" + transactions);
		request.setAttribute("transactionList", transactions);

		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-transaction-page.jsp");

		dispatcher.forward(request, response);
		
	}

	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("q");
		List<User> tempUser = userDBUtil.searchUser(query);
		if (query == "") {
			listUsers(request, response);
		}

		if (tempUser.isEmpty()) {
			request.setAttribute("userList", null);
		} else {
			request.setAttribute("userList", tempUser);
			System.out.println("Searched students:" + tempUser);// Outputs on console
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("users-page.jsp");

		dispatcher.forward(request, response);

	}

	private void loadUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		Double balance = Double.parseDouble(request.getParameter("userBalance"));
		User tempUser = new User(id, username, password, balance);
		request.setAttribute("updateUser", tempUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("update-user-form.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("userId"));
		userDBUtil.deleteUser(id);
		listUsers(request, response);

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Double balance = Double.parseDouble(request.getParameter("balance"));

		User tempUser = new User(id, username, password, balance);

		System.out.println("update:-" + tempUser);
		userDBUtil.updateUser(tempUser);
		listUsers(request, response);

	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = userDBUtil.getUserList();

		System.out.println("list" + users);
		request.setAttribute("userList", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("users-page.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		System.out.println(command);

		switch (command) {

		case "add":
			addUser(request, response);
			break;

		default:
			listUsers(request, response);
		}

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Double balance = Double.parseDouble(request.getParameter("balance"));

		Transaction transaction = null;
		
		if (!userName.isEmpty() && !password.isEmpty()) {

			User tempUser = new User(userName, password, balance);
			System.out.println(tempUser);
		int id = 	userDBUtil.addUser(tempUser);
			 LocalDateTime dateTime = LocalDateTime.now();
			transaction = new Transaction( "deposit", dateTime.toString(), balance, balance,id);
			transactionDBUtil.addTransaction(transaction);
		}

		response.sendRedirect(request.getContextPath() + "/AdminDashboardController?command=list");

	}

}
