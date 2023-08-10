package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
	
public class connectDB {
	public static String databaseDriver = "com.mysql.cj.jdbc.Driver";
	public static String databaseName = "HMS";
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
}
