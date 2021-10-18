package com.greenapex.dto;

public class EmployeeRespectiveManagerName {
	
private String empName;
private String empManager;
public EmployeeRespectiveManagerName(String empName, String empManager) {
	super();
	this.empName = empName;
	this.empManager = empManager;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpManager() {
	return empManager;
}
public void setEmpManager(String empManager) {
	this.empManager = empManager;
}
@Override
public String toString() {
	return "EmployeeRespectiveManagerName [empName=" + empName + ", empManager=" + empManager + "]";
}


}
