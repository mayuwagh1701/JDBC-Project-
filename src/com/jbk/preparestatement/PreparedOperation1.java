 package com.jbk.preparestatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import com.jbk.config.DbConnection;

public class PreparedOperation1 {
	// make connection
	Connection conn = DbConnection.getConnection();
	Scanner sc = new Scanner(System.in);

	public void insertData() {
		System.out.println("Enter rollNo:");
		int rollno = sc.nextInt();
		System.out.println("Enter Name:");
		String name = sc.next();
		System.out.println("Enter Marks:");
		int marks = sc.nextInt();
		System.out.println("Enter Age:");
		int age = sc.nextInt();

		// write a query
		String query = "INSERT INTO student(rollno,name,marks,age) values(?,?,?,?)";
		// prepare statements

		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, rollno);
			ps.setString(2, name);
			ps.setInt(3, marks);
			ps.setInt(4, age);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("notInserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showData() {
		// write a qeury
		String query = "SELECT * FROM student";
		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int rollno = resultSet.getInt("rollno");
				String name = resultSet.getString("name");
				int marks = resultSet.getInt("marks");
				int age = resultSet.getInt("age");
				System.out.println("RollNo:" + rollno);
				System.out.println("Name:" + name);
				System.out.println("Marks:" + marks);
				System.out.println("Age:" + age);

				System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateData() {
		System.out.println("Enter rollNo:");
		int rollno = sc.nextInt();
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter marks:");
		int marks = sc.nextInt();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		// write a query
		String query = "UPDATE student SET name = ?, marks = ? , age=? WHERE (rollno = ?)";

		// prepared statement
		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setInt(2, marks);
			ps.setInt(3, rollno);
			ps.setInt(4, age);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Updated");
			} else
				System.out.println("notUpdated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteData() {
		System.out.println("Enter rollNo:");
		int rollNo = sc.nextInt();
		// write a query;
		String query = "DELETE FROM jdbc_test.student WHERE (rollno = ?)";

		// prepared statement;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, rollNo);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Deleted");
			} else {
				System.out.println("notDeleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
