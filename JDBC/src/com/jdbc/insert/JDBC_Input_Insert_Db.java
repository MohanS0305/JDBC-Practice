package com.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class JDBC_Input_Insert_Db {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Scanner input = null;
		Savepoint sp = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?user=root&password=mohan2001");
			con.setAutoCommit(false);
			
			input = new Scanner(System.in);
			System.out.println("Enter some data for student table");
			System.out.println("Enter the student id :");
			int sId= input.nextInt();
			input.nextLine();
			System.out.println("Enter the student name :");
			String sName = input.nextLine();
			System.out.println("Enter the student gender :");
			String sGender= input.next();
			
			pstmt = con.prepareStatement("insert into std values(?, ?, ?)");
			
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setString(3, sGender);
			pstmt.executeUpdate();
			
			sp = con.setSavepoint();
			
			System.out.println("Enter some data for employee table");
			System.out.println("Enter the employee id :");
			int eId = input.nextInt();
			input.nextLine();
			System.out.println("Enter the employee name :");
			String eName = input.nextLine();
			System.out.println("Enter the employee salary :");
			int eSal = input.nextInt();
		
			pstmt2 = con.prepareStatement("insert into emp values(?, ?, ?)");
			pstmt2.setInt(1, eId);
			pstmt2.setString(2, eName);
			pstmt2.setInt(3, eSal);
			pstmt2.executeUpdate();
			
			con.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback(sp);
				con.commit();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
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
