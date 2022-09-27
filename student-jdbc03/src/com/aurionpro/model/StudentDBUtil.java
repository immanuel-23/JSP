package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.mysql.cj.xdevapi.PreparableStatement;

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

		} finally {
			close(conn, stmt, result);
		}
		return students;
	}

	private void close(Connection conn, Statement stmt, ResultSet result) {
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

	public void addStudent(Student tempStudent) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into student(first_name,last_name,email)values(?,?,?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tempStudent.getFirstName());
			stmt.setString(2, tempStudent.getLastName());
			stmt.setString(3, tempStudent.getEmail());

			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public Student getStudent(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		Student student = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from student where id = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			result = stmt.executeQuery();
			if (result.next()) {
				String email = result.getString("email");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				student = new Student(firstName, lastName, email, id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return student;
	}

	public void updateStudent(Student tempStudent) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update student set first_name=?,last_name=?,email=? where id=?;";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, tempStudent.getFirstName());
			stmt.setString(2, tempStudent.getLastName());
			stmt.setString(3, tempStudent.getEmail());
			stmt.setInt(4, tempStudent.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);

		}

	}

	public void deletStudent(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from student where id=?;";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);

		}
	
		
	}

	 public List<Student> searchStudents(String name) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			List<Student> students = new ArrayList<>();
			try {
				conn = dataSource.getConnection();
//				String sql = "select * from student where first_name=? or last_name=?;";
				String sql = "select * from student where first_name like ? or last_name like ?;";
				String search = "%"+name+"%";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, search);
				stmt.setString(2, search);
				result = stmt.executeQuery();
				while(result.next()) {
					int id = result.getInt("id");
					String firstName = result.getString("first_name");
					String lastName = result.getString("last_name");
					String email = result.getString("email");
					students.add(new Student(firstName, lastName, email, id));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				close(conn, stmt, result);
			}
			return students;

		}
}
	
