package com.aurionpro.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDBUtil {

	private DataSource datasource;

	public EmployeeDBUtil(DataSource datasource) {
		// TODO Auto-generated constructor stub
		this.datasource = datasource;

	}

	public List<Employee> getStudentList() {
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

}
