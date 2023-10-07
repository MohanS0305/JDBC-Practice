package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Input_Insert_Db {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner input = null;
		try {
			// connect to db server
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			System.out.println("sucessfully connected to mysql db server");
			con.setAutoCommit(false);
			// create platform
			pstmt = con.prepareStatement("insert into std values(?, ?, ?)");
			
			input = new Scanner(System.in);
			System.out.println("Enter the student id : ");
			int sId = input.nextInt();
			
			input.nextLine();
			System.out.println("Enter the student name : ");
			String sName = input.nextLine();
			System.out.println("Enter the student gender : ");
			String sGender = input.next();
			
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setString(3, sGender);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("data inserted into student table sucessfully");
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
				System.out.println("rolled out the transaction");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(input != null) {
					input.close();
				}
			} catch (SQLException s1) {
				s1.printStackTrace();
			}
		}

	}

}
