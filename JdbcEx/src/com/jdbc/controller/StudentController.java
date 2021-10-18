package com.jdbc.controller;
import com.neomodel.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class StudentController {
	public static List<Student> fetchStudent() throws SQLException, ClassNotFoundException{
		List<Student> students = null;
		Connection con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "SELECT * FROM student";
		try {
		pst = con.prepareStatement(query);
		rs=pst.executeQuery();
		students = new ArrayList<Student>();
		
			while(rs.next()) {
				Student student = new Student();
				student.setStid(rs.getInt(1));
				student.setStname(rs.getString(2));
				student.setStcourse(rs.getString(3));
				student.setMarks(rs.getInt(4));
				students.add(student);
			}
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		finally {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			JDBCConnection.closeConnection();
		}
		return students;
		
	}
	public static ResultSet fetchStud(int stid)  throws Exception{
		Connection con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		String sql = "select * from student where stid=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, stid);		
		ResultSet rs=pst.executeQuery();
		return rs;
	}
	
	/*
	 * public static Student fetchStudentsById(int stid) throws Exception {
	 * Connection con = JDBCConnection.openConnection(); PreparedStatement pst =
	 * null; String sql = "select * from student where stid =(?)"; pst =
	 * con.prepareStatement(sql); pst.setInt(1, stid); Student s= (Student)
	 * pst.executeQuery(); return s; }
	 */
	
	public static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
		Connection con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		String query = "INSERT INTO student VALUES(?,?,?,?)";
		
		
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, student.getStid());
			pst.setString(2, student.getStname());
			pst.setString(3, student.getStcourse());
			pst.setInt(4, student.getMarks());
			System.out.println("Inserted :"+pst.executeUpdate());
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		finally {
			if(pst != null)
				pst.close();
			JDBCConnection.closeConnection();
		}
	}
	public static void insertStudents(List<Student> students) throws Exception {
		Connection con = JDBCConnection.openConnection();
		PreparedStatement  pst = null ;
		String query = "Insert into student(stid,stname,stcource,stmarks)values(?,?,?,?)";
		pst = con.prepareStatement(query);
		for(Student st : students) {
			pst.setInt(1, st.getStid());
			pst.setString(2, st.getStname());
			pst.setString(3, st.getStcourse());
			pst.setInt(4,st.getMarks());
			System.out.println("inserted :"+pst.executeUpdate());
		}
	}
	public static void updateStudent(int stid, Student student) throws Exception {
		Connection  con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		String query = "update student set stname =(?) where stid = (?)";
		pst = con.prepareStatement(query);
		pst.setString(1, student.getStname());
		pst.setInt(2, student.getStid());
		
		System.out.println("update teblae"+pst.executeUpdate());
	}
	public static void deleteStudent(int stid) throws Exception {
		Connection con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		String query = " delete from student where stid = (?)";
		
		pst = con.prepareStatement(query);
		pst.setInt(1, stid);
		System.out.println("Deleted from table :"+pst.executeUpdate());
	}
}
