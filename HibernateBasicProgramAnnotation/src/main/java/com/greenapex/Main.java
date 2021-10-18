package com.greenapex;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.greenapex.comp.Student;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr=ssrb.build();
		SessionFactory sf=cfg.buildSessionFactory(ssr);
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();

		//Insert Data In DataBase
		/*Student s1=new Student(102, "shiv", 15000.50f);
		s.save(s1);*/
		
		//Update Data
		/*Student s1 = (Student)s.get(Student.class, 102);
		  s1.setStudentName("Sweety");*/
		
		//Delete Data
		/*
		 * Student s1 = (Student)s.get(Student.class, 102); 
		 * s.delete(s1);
		 */
		//Get Data by Id
		/*
		 * Student s1 = (Student)s.get(Student.class, 101); 
		 * System.out.println(s1);
		 */
		
		// Get All The Data
		/*
		 * Query q=s.createQuery("From Student"); List<Student> students = q.list();
		 * for(Student stu:students) { System.out.println(stu);
		 * 
		 * }
		 */
		
		//get student assending order by name
		/*
		 * Query q=s.createQuery("from Student order by student_name"); List<Student>
		 * students = q.list(); for(Student stu:students) { System.out.println(stu);
		 * 
		 * }
		 */
				
		  tr.commit();
		s.close();
		sf.close();
		

	}

}
