package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	
public class connectDB {
	public static String databaseDriver = "com.mysql.cj.jdbc.Driver";
	public static String databaseName = "phonebook";
	public static String databaseURL = "jdbc:mysql://localhost:3306/" + databaseName;
	public static String databaseUser = "root";
	public static String databasePassword = "kepler438b";
	
	private static Connection conn;
	public static Connection getConn() {
		
		try {
			// check if connection is already established
			if(conn == null) {
				// set up mysql driver and db url
				Class.forName(databaseDriver);
				conn = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		if(conn == null) {
//			System.out.println("Some err occured while connecting to database.");
//		} else {
//			System.out.println("Database Connected Successfully!");
//			System.out.println("Connection Object: " + conn);
//		}
		// return connection object
		return conn;
	}
	
public static void closeConn() {
		
		try {
			// check if connection is already established
			if(conn != null) {
				// close the connection
				conn.close();
				System.out.println("Database Connection Closed Successfully.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}