package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JdbcTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(name = "jdbc/employee")
	private DataSource datasource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			conn = datasource.getConnection();// data source have all the information
			String sql = "select * from employee";
			stmt = conn.createStatement();
			result=stmt.executeQuery(sql);
			while(result.next()) {
				String email=result.getString("email");
				String firstName=result.getString("first_name");
				String lastName=result.getString("last_name");

				out.println(email);
				out.print(firstName);
				out.print(lastName);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
