package com.greenapex;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee
{
	int eid;
	String empName;
	String empDept;
	double empSalary;
	public Employee(int eid, String empName, String empDept, double empSalary) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empDept = empDept;
		this.empSalary = empSalary;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	

}


public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee(1, "Ram", "IT", 30000);
		Employee e2=new Employee(2, "syam", "Sales", 40000);
		Employee e3=new Employee(3, "seeta","IT", 50000);
		Employee e4=new Employee(4, "geeta", "HR", 60000);
		Employee e5=new Employee(5, "rohan", "HR", 70000);
		Employee e6=new Employee(6, "arru", "HR", 25000);
		Employee e7=new Employee(7, "allu", "CS", 30000);
		Employee e8=new Employee(8, "reena", "CS", 35000);
		Employee e9=new Employee(9, "reeta", "IT", 45000);
		Employee e10=new Employee(10, "seema", "EC", 55000);
		Employee e11=new Employee(11, "saroj", "EC", 60000);
		
		List<Employee> list=new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		list.add(e11);
		
		Map<String, List<String>> map=list
                .stream()
                .collect(
                    Collectors
                        .groupingBy(
                            Employee::getEmpDept,
                            Collectors
                                .mapping(
                                		Employee::getEmpName,
                                        Collectors
                                        .toList())));
		//System.out.println("map = " + map);
		map.forEach((k,v)->System.out.println(k+" : "+v));
		
	}

}
