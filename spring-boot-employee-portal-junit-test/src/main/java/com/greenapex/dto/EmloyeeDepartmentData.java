package com.greenapex.dto;

public class EmloyeeDepartmentData {

private Integer empId;
private String empName;
private String empAddress;
private Integer managerId;
private String empRole;
private Double empSalary;
private Integer deptId;
private String deptName;
private String deptLocaton;




public EmloyeeDepartmentData(Integer empId, String empName, String empAddress, Integer managerId, String empRole,
		Double empSalary, Integer deptId, String deptName, String deptLocaton) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empAddress = empAddress;
	this.managerId = managerId;
	this.empRole = empRole;
	this.empSalary = empSalary;
	this.deptId = deptId;
	this.deptName = deptName;
	this.deptLocaton = deptLocaton;
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

public Integer getManagerId() {
	return managerId;
}
public void setManagerId(Integer managerId) {
	this.managerId = managerId;
}
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getEmpAddress() {
	return empAddress;
}
public void setEmpAddress(String empAddress) {
	this.empAddress = empAddress;
}
public String getEmpRole() {
	return empRole;
}
public void setEmpRole(String empRole) {
	this.empRole = empRole;
}
public Integer getDeptId() {
	return deptId;
}
public void setDeptId(Integer deptId) {
	this.deptId = deptId;
}
public String getDeptLocaton() {
	return deptLocaton;
}
public void setDeptLocaton(String deptLocaton) {
	this.deptLocaton = deptLocaton;
}
@Override
public String toString() {
	return "EmloyeeDepartmentData [empName=" + empName + ", deptName=" + deptName + ", empSalary=" + empSalary
			+ ", empManager=" + managerId + ", empId=" + empId + ", empAddress=" + empAddress + ", empRole=" + empRole
			+ ", deptId=" + deptId + ", deptLocaton=" + deptLocaton + "]";
}


}
