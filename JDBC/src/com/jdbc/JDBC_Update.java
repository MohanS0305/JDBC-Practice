package com.jdbc;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_Update {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String uQuery = "update std set sid=310110402 where sname='Ajai'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			System.out.println("Driver class loaded and registered successfully");
			
			stmt = con.createStatement();
			System.out.println("Statement/platform created successfully");
			
			stmt.executeUpdate(uQuery);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null)
					con.close();
			} catch (SQLException s1) {
				s1.printStackTrace();
			}
			
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException s2) {
				s2.printStackTrace();
			}
		}
	}
}
