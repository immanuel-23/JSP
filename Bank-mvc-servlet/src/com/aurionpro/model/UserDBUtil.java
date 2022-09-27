package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDBUtil {

	private DataSource dataSource;

	public UserDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public User checkUser(User user) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		User tempUser = null;
		String sql = "select * from users where user_name=? and user_pass=?;";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserPass());

			result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("user_id");
				String username = result.getString("user_name");
				String password = result.getString("user_pass");
				double balance = result.getDouble("balance");
				tempUser = new User(id, username, password, balance);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			close(conn,stmt,result);
		}

		return tempUser;

	}

	public List<User> getUserList() {
		
		Connection conn=null;
		Statement stmt = null;
		ResultSet result = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = dataSource.getConnection();
			
			String sql = "select * from users;";
			stmt = conn.createStatement();
			result=stmt.executeQuery(sql);
			
			while (result.next()) {
				int id = result.getInt("user_id");
				String username = result.getString("user_name");
				String password = result.getString("user_pass");
				double balance = Double.parseDouble(result.getString("balance"))   ;

				users.add(new User(id, username, password, balance));

			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,stmt,result);
		}
	

		return users;
	}

	public int addUser(User tempUser) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		Statement statement = null;
		ResultSet result = null;
		int userId = 0 ;
		System.out.println("dbutil");
		try {
			conn = dataSource.getConnection();
		
			
			String sql = "insert into users(user_name,user_pass,balance) values(?,?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tempUser.getUserName());
			stmt.setString(2, tempUser.getUserPass());
			stmt.setDouble(3, tempUser.getBalance());
			stmt.execute();
			
			String getlastUser = "select user_id from users order by user_id desc limit 1;";
			statement = conn.createStatement();
			result=statement.executeQuery(getlastUser);
	
			System.out.println("result" + result);
			
			if(result.next()) {
				
				userId = result.getInt("user_id");
			}
			
			
			
			
			
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, null);
		}
		return userId;

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

	public void updateUser(User tempUser) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();

			String sql = "update users set user_name=?,user_pass=?,balance=? where user_id=?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tempUser.getUserName());
			stmt.setString(2, tempUser.getUserPass());
			stmt.setDouble(3, tempUser.getBalance());
			stmt.setInt(4, tempUser.getUserId());
			stmt.execute();
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, null);
		}

		
	}

	public void deleteUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from users where user_id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			close(conn, stmt, null);
		}
		
	}

	public List<User> searchUser(String query) {
		List<User> users = new ArrayList<User>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from users where user_name like ?";
			String search = "%" + query + "%";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, search);
		
			result = stmt.executeQuery();

			while (result.next()) {
				int userId = result.getInt("user_id");
				String userName = result.getString("user_name");
				String userPass = result.getString("user_pass");
				double balance =   result.getDouble("balance");

				users.add(new User(userId, userName, userPass, balance));

			}
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, result);
		}

		return users;

	}

	public User getUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		User user = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from users where user_id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			result = stmt.executeQuery();
			System.out.println("result " + result);

			if (result.next()) {

				System.out.println("in if result ");
				String username = result.getString("user_name");
				String password = result.getString("user_pass");
				Double balance = result.getDouble("balance");

			user = new User(id, username, password, balance);

			

			}

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			close(conn, stmt, result);
		}
		return user;

	}

		
	
	}



