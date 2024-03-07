package com.jbk.preparestatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.jbk.config.DbConnection;

public class PreparedOperation {
	//Make connection;
	Connection conn = DbConnection.getConnection();

	public void insertData() {
		
		//Write a query
		String query = "INSERT INTO student(rollno,name,marks) values(?,?,?)";
		
		//Prepare statement;
		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, 101); // problem: one qeury excuted attime not more than 1? why;
			ps.setString(2, "Rahul");
			ps.setInt(3, 45);

			ps.setInt(1, 102);
			ps.setString(2, "Shivam");
			ps.setInt(3, 50);

			ps.setInt(1, 105);
			ps.setString(2, "Ram");
			ps.setInt(3, 40);

			ps.setInt(1, 103);
			ps.setString(2, "Rani");
			ps.setInt(3, 48);

			ps.setInt(1, 104);
			ps.setString(2, "Rekha");
			ps.setInt(3, 46);

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
		
		//Write a Query;
		String query = "SELECT * FROM student";
		
		//Prepared Statement;
		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int rollno = resultSet.getInt("rollno");
				String name = resultSet.getString("name");
				int marks = resultSet.getInt("marks");
				System.out.println(rollno + "\t");
				System.out.println(name + "\t");
				System.out.println(marks);

				System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	

	public void updateDate() {
		 
		//Write a query
		// String qeury="UPDATE `jdbc_test`.`student` SET `name` = 'Ravi' WHERE (`rollno` = ?)";
		 String qeury="UPDATE `jdbc_test`.`student` SET `name` = 'Rani' WHERE (`rollno` = ?)";
		
		//Prepared statement
		try {
			PreparedStatement ps = conn.prepareStatement(qeury);

			ps.setInt(1, 102);
			ps.setInt(1, 105);

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
		
		//Write a query;
		 String query= "DELETE FROM `jdbc_test`.`student` WHERE (`rollno` = ?)";
		
		
		//Prepared statement;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 102);
			

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
