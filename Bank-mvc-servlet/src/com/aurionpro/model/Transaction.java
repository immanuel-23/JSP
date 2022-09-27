package com.aurionpro.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	private double transactionAmount;
	private double balance;
	private int userId;

	public Transaction(int transactionId, String transactionType, String transactionDate, double transAmmount,
			double balance) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transAmmount;
		this.balance = balance;

	}
	
	

	public Transaction(int transactionId, String transactionType, String transactionDate, double transactionAmount,
			double balance, int userId) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.balance = balance;
		this.userId = userId;
	}



	public Transaction(String transactionType, String transactionDate, double transactionAmount, double balance,
			int userId) {
		super();
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.balance = balance;
		this.userId = userId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public double getBalance() {
		return balance;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", transactionAmount=" + transactionAmount + ", balance="
				+ balance + ", userId=" + userId + "]";
	}

}