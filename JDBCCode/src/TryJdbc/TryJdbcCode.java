package TryJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TryJdbcCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/newdb","root","root"); 
			Statement stmt=con.createStatement(); 
			stmt.executeUpdate("insert into Persons values(2,'nazneen')");
	        con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/newdb","root","root"); 
			PreparedStatement ps=con.prepareStatement("insert into Persons values(?,?)");
			
			ps.setInt(1,101);//1 specifies the first parameter in the query  
			ps.setString(2,"Rohan");  
			ps.executeUpdate();
	        con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated c atch block
			e.printStackTrace();
		}  
	}

}
