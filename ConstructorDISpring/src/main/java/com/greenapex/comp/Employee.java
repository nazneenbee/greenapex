package com.greenapex.comp;

public class Employee {
private int empid;
private String empname;
public Employee() {
	
}
public Employee(int empid) {
	this.empid=empid;
}
public Employee(String empname) {
	this.empname=empname;
}

public Employee(int empid, String empname) {  
    this.empid = empid;  
    this.empname = empname;  
}  
  

public String toString(){  
   return empid+" "+empname;  
}  

}
