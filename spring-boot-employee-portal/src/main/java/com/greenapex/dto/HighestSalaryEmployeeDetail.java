package com.greenapex.dto;

public class HighestSalaryEmployeeDetail {
	
private String empName;
//private String deptName;
private Double empSalary;
public HighestSalaryEmployeeDetail(String empName, Double empSalary) {
	super();
	this.empName = empName;
	this.empSalary = empSalary;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Double getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(Double empSalary) {
	this.empSalary = empSalary;
}


/*
public HighestSalaryEmployeeDetail(String empName, String deptName, Double empSalary) {
	super();
	this.empName = empName;
	this.deptName = deptName;
	this.empSalary = empSalary;
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
public Double getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(Double empSalary) {
	this.empSalary = empSalary;
}
public HighestSalaryEmployeeDetail() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "HighestSalaryEmployeeDetail [empName=" + empName + ", deptName=" + deptName + ", empSalary=" + empSalary
			+ "]";
}
*/



}
