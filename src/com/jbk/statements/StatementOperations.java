package com.jbk.statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jbk.config.DbConnection;

public class StatementOperations {
	Connection connection = DbConnection.getConnection();

	public void insertData() {
		String sqlQuery = "INSERT INTO student(rollno,name,marks,age)values(1,'mayur',1),(222,'ravi',80)";

		try {
			Statement stmt = connection.createStatement();
			// Operation: insert ,update and delete that time use = executeUpadate(sql);
			int rows = stmt.executeUpdate(sqlQuery);
			
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
		String sqlQuery = "SELECT * FROM student";

		try {
			Statement stmt = connection.createStatement();
			// Operation:

			ResultSet resultSet = stmt.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int rollno = resultSet.getInt("rollno");
				String name = resultSet.getString("name");
				int marks= resultSet.getInt("marks");
				System.out.println(rollno+ "\t");
				System.out.println(name+"\t");
				System.out.println(marks);
				
				System.out.println();

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData() {
		String query= "UPDATE student SET name = vaibhav, marks =90 , age=24 WHERE (rollno = 100)";
	}
	public void deleteDate() {
		String sqlQuery="DELETE FROM student WHERE rollno=222";
		try {
			Statement stmt = connection.createStatement();
			int rows = stmt.executeUpdate(sqlQuery);
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

