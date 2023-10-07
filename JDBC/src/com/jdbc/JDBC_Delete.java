package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			System.out.println("Driver class loaded and registered successfully");
			
			stmt = con.createStatement();
			stmt.executeUpdate("delete from std where sid=310110405");
			System.out.println("Query executed successfully");
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
