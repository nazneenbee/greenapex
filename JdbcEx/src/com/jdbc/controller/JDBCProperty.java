package com.jdbc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCProperty {
	
	
	public static String driverClass = null;
	public static String url = null;
	public static String username = null;
	public static String password = null;
	
	
	
	public static void loadProperties(){
		Properties prop = null;
		InputStream in = null;
		
		 try {
			 prop = new Properties();
			in = new FileInputStream("Resources/database.properties");
			prop.load(in);
			driverClass = prop.getProperty("MYSQLJDBC.driver");
			url = prop.getProperty("MYSQLJDBC.url");
			username = prop.getProperty("MYSQLJDBC.username");
			password = prop.getProperty("MYSQLJDBC.password");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		 finally {
			 
			
				try {
					 if(in !=null)
					in.close();
					 if(prop != null)
						 prop.clear();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
		 }
		
		
	}
}