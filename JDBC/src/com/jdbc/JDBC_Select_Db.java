package com.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class JDBC_Select_Db {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			stmt = con.createStatement();
			String sQuery = "select * from emp";
			ResultSet result = stmt.executeQuery(sQuery);
			
			while(result.next()) {
				int eId = result.getInt("eid");
				String eName = result.getString("ename");
				int eSalary = result.getInt("esal");
				
				System.out.println("Employee id : "+eId);
				System.out.println("Employee name : "+eName);
				System.out.println("Employee salary : "+eSalary);
				System.out.println();
			}
			
		} catch (ClassNotFoundException  | SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				if( con != null)
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
