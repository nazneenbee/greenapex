package com.greenapex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcCheckInMaven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/newdb","root","root"); 
			PreparedStatement ps=con.prepareStatement("insert into Persons values(?,?)");
			
			ps.setInt(1,2);//1 specifies the first parameter in the query  
			ps.setString(2,"rush");  
			int i=ps.executeUpdate();
	        con.close();
	        if(i>0)
	        {
	        	System.out.println("Data Inserted");
	        }
	        else
	        {
	        	System.out.println("data not inserted");
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated c atch block
			e.printStackTrace();
		}  

	}

}
