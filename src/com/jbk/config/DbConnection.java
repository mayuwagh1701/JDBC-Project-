package com.jbk.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	// create a new method to create connection

	public static Connection  getConnection() {
		Connection connection= null;
		
		try{
			//1.load driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Create Connection
			connection=	DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "root");
			
			System.out.println("connected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
