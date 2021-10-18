package com.greenapex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greenapex.comp.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appCntx = new ClassPathXmlApplicationContext("cfg.xml");
		Employee emp = (Employee)appCntx.getBean("e");
	     System.out.println(emp.getEmpid()); 
	     System.out.println(emp.getEmpname());
	}

}
