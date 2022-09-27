package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.model.Account;
import com.aurionpro.model.Admin;
import com.aurionpro.model.AdminDBUtil;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.TransactionDBUtil;
import com.aurionpro.model.User;
import com.aurionpro.model.UserDBUtil;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionController() {
		super();

	}

	@Resource(name = "jdbc/bank")
	private DataSource dataSource;
	
	private UserDBUtil userDBUtil;
	private TransactionDBUtil transcDBUtil;

	@Override
	public void init() throws ServletException {

		super.init();
		userDBUtil = new UserDBUtil(dataSource);
		transcDBUtil = new TransactionDBUtil(dataSource);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {
			response.sendRedirect(request.getContextPath() + "/user-transaction-page.jsp");
		}

		switch (command) {
		case "withdraw":
			withdrawAmmount(request, response);

			break;

		case "deposit":
			depositAmmount(request, response);

			break;

		default:
			break;
		}

	}

	private void depositAmmount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		double amount = Double.parseDouble(request.getParameter("amount"));
		HttpSession session = request.getSession(false);
		User sessionUser = (User) session.getAttribute("user");
		int id = sessionUser.getUserId();
		String typetransc = request.getParameter("command");
		User tempUser = userDBUtil.getUser(id);
		double balance = tempUser.getBalance();

		Account account = new Account(id, balance);
		double finalBalance = account.deposit(amount);

		User user = new User(id, tempUser.getUserName(), tempUser.getUserPass(), finalBalance);

		userDBUtil.updateUser(user);
		 LocalDateTime dateTime = LocalDateTime.now();
		  
		  
		if (amount > 0 && finalBalance !=balance) {
			Transaction trans = new Transaction(typetransc, dateTime.toString(), amount, finalBalance, id);
			transcDBUtil.addTransaction(trans);
		}
		
		response.sendRedirect(request.getContextPath() + "/user-dashboard.jsp");

	}

	private void withdrawAmmount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		HttpSession session = request.getSession(false);
		User sessionUser = (User) session.getAttribute("user");
		int id = sessionUser.getUserId();
		String typetransc = request.getParameter("command");
		User tempUser = userDBUtil.getUser(id);
		double balance = tempUser.getBalance();

		Account account = new Account(id, balance);
		double finalBalance = account.withDraw(amount);

		User user = new User(id, tempUser.getUserName(), tempUser.getUserPass(), finalBalance);

		userDBUtil.updateUser(user);
		 LocalDateTime dateTime = LocalDateTime.now();
		  
		  
		if (amount > 0 && finalBalance !=balance) {
			Transaction trans = new Transaction(typetransc, dateTime.toString(), amount, finalBalance, id);
			transcDBUtil.addTransaction(trans);
		}
		
		response.sendRedirect(request.getContextPath() + "/user-dashboard.jsp");

	}
		
		
		
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}