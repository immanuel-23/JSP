package com.aurionpro.model;

public class Account {
	
	private int userId;
	private double balance;
	
	public Account(int userId, double balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public double getBalance() {
		return balance;
	}
	
	public double withDraw(double amount) {
		int minimumBalance = 1000;
		if (balance - amount >= minimumBalance) {
			balance = balance - amount;
			return balance;
		}
		return balance;
	}

	public double deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			return balance;
		}
		return balance;
	}

	
	
	
}
