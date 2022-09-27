package com.aurionpro.model;

public class User {

	private int userId;
	private String userName;
	private String userPass;
	private double balance;

	public User(int userId, String userName, String userPass, double balance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.balance = balance;
	}
	

	public User(String userName, String userPass, double balance) {
		super();

		this.userName = userName;
		this.userPass = userPass;
		this.balance = balance;
	}


	public User(String userName, String userPass) {
		super();

		this.userName = userName;
		this.userPass = userPass;
	
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", balance=" + balance
				+ "]";
	}

}