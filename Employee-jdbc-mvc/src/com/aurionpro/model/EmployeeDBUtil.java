package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDBUtil {

	private static DataSource datasource;

	public EmployeeDBUtil(DataSource datasource) {
		// TODO Auto-generated constructor stub
		this.datasource = datasource;

	}

	public static List<Employee> getStudentList() {
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		List<Employee> employee = new ArrayList<>();

		try {
			conn = datasource.getConnection();// data source have all the information
			String sql = "select * from employee";
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String email = result.getString("email");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String department = result.getString("department");
				int salary = result.getInt("salary");

				employee.add(new Employee(firstName, lastName, email, id,department,salary, salary));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return employee;
		
	}

	public static void addEmployee(Employee tempEmployee) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = datasource.getConnection();
			String sql = "insert into employee(first_name,last_name,email,department,salary)values(?,?,?,?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tempEmployee.getFirstName());
			stmt.setString(2, tempEmployee.getLastName());
			stmt.setString(3, tempEmployee.getEmail());
			stmt.setString(4, tempEmployee.getDepartment());
			stmt.setString(5, String.valueOf(tempEmployee.getSalary()));

			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(conn,stmt, null);
		}
	}

	private static void close(Connection conn, PreparedStatement stmt, ResultSet result) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Employee getEmployee(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		Employee employee= null;
		
		try {
			conn = datasource.getConnection();
			String sql = "select * from employee where id = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,id);
			
			result = stmt.executeQuery();
			if(result.next()) {
				String email = result.getString("email");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String department= result.getString("last_name");
				int id1 = Integer.parseInt(result.getString("id"));
				int salary = Integer.parseInt(result.getString("salary"));

				employee = new Employee(firstName, lastName, email,id1, department,salary);
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn,stmt,result);
		}
		return employee;
	}

	public void updateEmployee(Employee tempEmployee) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = datasource.getConnection();
			String sql = "update employee set first_name=?,last_name=?,email=? ,department=?, salary=? where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tempEmployee.getFirstName());
			stmt.setString(2, tempEmployee.getLastName());
			stmt.setString(3, tempEmployee.getEmail());
			stmt.setString(4, tempEmployee.getDepartment());
			stmt.setString(5, String.valueOf(tempEmployee.getSalary()));
			
			stmt.setInt(6, tempEmployee.getId());

			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		finally {
			close(conn,stmt,null);
		}
	}

	public void deleteEmployee(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = datasource.getConnection();
			String sql = "delete from employee where id=?;";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);

		}
	}

	public List<Employee> searchEmployee(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Employee> emp = new ArrayList<>();
		try {
			conn = datasource.getConnection();
			String sql = "select * from employee where first_name like ? or last_name like ?;";
			String search = "%"+name+"%";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, search);
			stmt.setString(2, search);
			result = stmt.executeQuery();
			while(result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				String department=result.getString("department");
				int salary = Integer.parseInt(result.getString("salary"));
				emp.add(new Employee(firstName, lastName, email, department, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(conn, stmt, result);
		}
		return emp;

	}

}
