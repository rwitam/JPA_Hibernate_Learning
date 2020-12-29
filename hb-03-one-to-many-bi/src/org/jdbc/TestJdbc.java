package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try
		{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
			conn.close();
			
			System.out.println("Connection closed.");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
