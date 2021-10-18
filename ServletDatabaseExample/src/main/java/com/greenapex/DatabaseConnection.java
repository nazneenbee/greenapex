package com.greenapex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	final String DRIVER="com.mysql.cj.jdbc.Driver";
	final String URL="jdbc:mysql://localhost:3306/mydb";
	final String PASSWORD="root";
	final String USERNAME="root";
	
	public Connection jdbcConnection()
	{
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
		
	}
}
