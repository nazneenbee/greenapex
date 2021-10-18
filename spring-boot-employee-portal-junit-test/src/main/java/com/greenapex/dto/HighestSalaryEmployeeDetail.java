package com.greenapex.dto;

public class HighestSalaryEmployeeDetail {
	
	private Integer empId;
	private String empName;
	private String empAddress;
	private Integer managerId;
	private String empRole;
	private Double empSalary;
	private Integer deptId;
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	public HighestSalaryEmployeeDetail(Integer empId, String empName, String empAddress, Integer managerId,
			String empRole, Double empSalary,Integer deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.managerId = managerId;
		this.empRole = empRole;
		this.empSalary = empSalary;
		this.deptId=deptId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	
	
/*public HighestSalaryEmployeeDetail(String empName, Double empSalary) {
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
