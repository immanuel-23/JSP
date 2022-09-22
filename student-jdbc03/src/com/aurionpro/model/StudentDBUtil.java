package com.aurionpro.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	private DataSource dataSource;

	public StudentDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Student> getStudentList() {
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		List<Student> students = new ArrayList<>();

		try {
			conn = dataSource.getConnection();// data source have all the information
			String sql = "select * from student";
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String email = result.getString("email");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				students.add(new Student(firstName, lastName, email, id));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return students;
	}

}
