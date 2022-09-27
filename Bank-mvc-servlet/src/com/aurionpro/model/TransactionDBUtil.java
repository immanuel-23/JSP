package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TransactionDBUtil {

	private DataSource dataSource;

	public TransactionDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addTransaction(Transaction transc) {

		Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println("dbutil");
		try {
			conn = dataSource.getConnection();
			String sql = "insert into transactions(trans_type,trans_date,trans_ammount,trans_balance,user_id) values(?,?,?,?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, transc.getTransactionType());
			stmt.setString(2, transc.getTransactionDate());
			stmt.setDouble(3, transc.getTransactionAmount());
			stmt.setDouble(4, transc.getBalance());
			stmt.setInt(5, transc.getUserId());
			stmt.execute();
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, null);
		}

	}

	private void close(Connection conn, Statement stmt, ResultSet result) {
		
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (result != null)
				result.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	public List<Transaction> getTransactions(int id) {
	
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			conn = dataSource.getConnection();
			
			String sql = "select * from transactions where user_id=?;";
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result=stmt.executeQuery();
			
			while (result.next()) {
				int transId = result.getInt("trans_id");
				String transType = result.getString("trans_type");	
				String transDate = result.getString("trans_date");
				double transAmmount = Double.parseDouble(result.getString("trans_ammount"));
				double balance = Double.parseDouble(result.getString("trans_balance"));

			transactions.add(new Transaction(transId, transType, transDate, transAmmount, balance));
					

			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,stmt,result);
		}
	

		return transactions;
		
		
	}

	public List<Transaction> getTransactionsList() {
	
		Connection conn=null;
		Statement stmt = null;
		ResultSet result = null;
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			conn = dataSource.getConnection();
			
			String sql = "select * from transactions;";
			stmt =  conn.createStatement();
		
			result=stmt.executeQuery(sql);
			
			while (result.next()) {
				int transId = result.getInt("trans_id");
				String transType = result.getString("trans_type");	
				String transDate = result.getString("trans_date");
				double transAmmount = Double.parseDouble(result.getString("trans_ammount"));
				double balance = Double.parseDouble(result.getString("trans_balance"));
				int userId = result.getInt("user_id");

			transactions.add(new Transaction(transId, transType, transDate, transAmmount, balance,userId));
					

			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,stmt,result);
		}
	System.out.println("in db transc:"+transactions);

		return transactions;
		
		
	
	}

	public List<Transaction> searchTransaction(String query) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from transactions where user_id like ?";
			String search = "%" + query + "%";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, search);
		
			result = stmt.executeQuery();

			while (result.next()) {
				int transId = result.getInt("trans_id");
				String transType = result.getString("trans_type");	
				String transDate = result.getString("trans_date");
				double transAmmount = Double.parseDouble(result.getString("trans_ammount"));
				double balance = Double.parseDouble(result.getString("trans_balance"));
				int userId = result.getInt("user_id");

			transactions.add(new Transaction(transId, transType, transDate, transAmmount, balance,userId));
				

			}
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, result);
		}

		return transactions;

		
	}

}
