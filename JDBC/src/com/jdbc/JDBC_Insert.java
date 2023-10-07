package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String iQuery = "insert into std values(31011402,'Ajai','Male')";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			System.out.println("Driver class load and registered successfully");
			
			stmt = con.createStatement();
			System.out.println("statement created sucessfully");
			stmt.executeUpdate(iQuery);
			System.out.println("Query executed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException s1) {
				s1.printStackTrace();
			}
			
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException s2) {
				s2.printStackTrace();
			}
			System.out.println("all the costly resource closed successfully");
		}


	}

}
