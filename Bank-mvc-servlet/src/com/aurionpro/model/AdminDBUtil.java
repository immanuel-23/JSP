package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class AdminDBUtil {

	private DataSource dataSource;

	public AdminDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public Admin checkAdmin(Admin admin) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Admin tempAdmin = null;
		conn = dataSource.getConnection();
		String sql = "select * from admintable where admin_uname=? and admin_pass=?;";

		stmt = conn.prepareStatement(sql);
		stmt.setString(1, admin.getAdminUname());
		stmt.setString(2, admin.getAdminPass());

		result = stmt.executeQuery();

		while (result.next()) {
			int id = result.getInt("admin_id");
			String username = result.getString("admin_uname");
			String password = result.getString("admin_pass");

			tempAdmin = new Admin(id, username, password);

		}

		return tempAdmin;

	}

	
}
