package com.Externaljdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.controller.StudentController;
import com.neomodel.Student;

public class jdbcMVC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Student student1 = new Student(103,"abc","java",99);
				//StudentController.insertStudent(student1);
				//StudentController.deleteStudent(101);
				//StudentController.updateStudent(103, student1);
		
//		  List<Student> list = new ArrayList<Student>(); list.add(new
//		 Student(101,"mangesh","JAva",86)); list.add(new
//		 Student(103," Anajli","Angular",98)); list.add(new
//		  Student(104,"Shvraj","php",90)); StudentController.insertStudents(list);
		 
				
		
				 ResultSet rs=(ResultSet)StudentController.fetchStud(103);
				 if(rs.next()) {
			            System.out.print(rs.getInt(1));
			            System.out.print("\t\t"+rs.getString(2));
			            System.out.print("\t\t"+rs.getString(3));
			            System.out.print("\t\t"+rs.getInt(4));
			           
			         }
		  
		 		 
			}

		}
