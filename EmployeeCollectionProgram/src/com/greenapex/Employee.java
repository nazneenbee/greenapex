package com.greenapex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.Region;

class Emp
{
	private int empId;
	private String empName;
	private String deptName;
	private double salary;
	
	public Emp(int empId, String empName, String deptName, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.salary = salary;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * public String toString() { return "empId : " + empId + "  empName : " +
	 * empName + "  deptName : " + deptName + " salary : " + salary; }
	 */
	
	
}

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc.next();
		System.out.println("Enter Employee Deptartment");
		String dept=sc.next();
		System.out.println("Enter Employee Salary");
		double salary=sc.nextDouble();
		Emp e1=new Emp(id,name,dept,salary);
		
		System.out.println("Enter Employee Id");
		int id2=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name2=sc.next();
		System.out.println("Enter Employee Deptartment");
		String dept2=sc.next();
		System.out.println("Enter Employee Salary");
		double salary2=sc.nextDouble();
		Emp e2=new Emp(id2,name2,dept2,salary2);
		
		
		System.out.println("Enter Employee Id");
		int id3=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name3=sc.next();
		System.out.println("Enter Employee Deptartment");
		String dept3=sc.next();
		System.out.println("Enter Employee Salary");
		double salary3=sc.nextDouble();
		Emp e3=new Emp(id3,name3,dept3,salary3);
		
		System.out.println("Enter Employee Id");
		int id4=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name4=sc.next();
		System.out.println("Enter Employee Deptartment");
		String dept4=sc.next();
		System.out.println("Enter Employee Salary");
		double salary4=sc.nextDouble();
		Emp e4=new Emp(id4,name4,dept4,salary4);*/
		
		
		 Emp e1=new Emp(1,"ram", "IT", 30000.00);
		 Emp e2=new Emp(2,"syam", "Manager",40000.00); 
		 Emp e3=new Emp(3,"raj", "Hr", 35000.00); 
		 Emp e4=new Emp(4,"geeta","Clerk", 25000.00);
		 
		
		List<Emp> e=new ArrayList<Emp>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		
		for(Emp emp:e)
		{
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getDeptName());
			System.out.println(emp.getSalary());
			
		}
		
	    double max=0;
		
		for(Emp emp1:e)
		{
			if(max<=emp1.getSalary())
			{
				max=emp1.getSalary();
			}
		}
		for(Emp emp2:e)
		{
			if(max==emp2.getSalary())
			{
				System.out.println("Employee Details who has Maximum Salary");
				System.out.println(emp2.getEmpId());
				System.out.println(emp2.getEmpName());
				System.out.println(emp2.getDeptName());
				System.out.println(emp2.getSalary());
			}
		}

	}

}
