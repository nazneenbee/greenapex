package com.greenapex.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer empId;
	
	@Column(name="empName")
	String empName;
	
	@Column(name="empRole")
	String empRole;
	
	@Column(name="empSalary")
	Double empSalary;
	
	@Column(name="empAddress")
	String empAddress;
	
	@Column(name="empManager")
	String empManager;
    
	public String getEmpManager() {
		return empManager;
	}

	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name ="deptId")
	private DepartmentEntity department;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employeeProject", joinColumns = {@JoinColumn(name="empId")}, inverseJoinColumns = {@JoinColumn(name="projectId")})
	
	private Set<ProjectEntity> project=new HashSet<ProjectEntity>();

	

	public Set<ProjectEntity> getProject() {
		return project;
	}

	public void setProject(Set<ProjectEntity> project) {
		this.project = project;
	}
	

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(Integer empId, String empName, String empRole, Double empSalary, String empAddress,
			String empManager, DepartmentEntity department, Set<ProjectEntity> project) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
		this.empSalary = empSalary;
		this.empAddress = empAddress;
		this.empManager = empManager;
		this.department = department;
		this.project = project;
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

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public EmployeeEntity(String empName, Double empSalary) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public EmployeeEntity(String empName, Double empSalary, Set<ProjectEntity> project) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.project = project;
	}
	

}
