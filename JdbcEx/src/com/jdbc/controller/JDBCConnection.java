package com.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	 static Connection con = null;
	
	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		
			JDBCProperty.loadProperties();
			Class.forName(JDBCProperty.driverClass);
			System.out.println("Driver Loaded !");
			
			con = DriverManager.getConnection(JDBCProperty.url, JDBCProperty.username, JDBCProperty.password);
			System.out.println("Connection Established....");
			
	
		return con;
	}
	
	public static void closeConnection() {
		
	
			try {
				if(con != null) {
					con.close();
				System.out.println("Closed Connection...");
			} 
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
	}
}

