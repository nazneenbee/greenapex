package com.greenapex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer deptId;
	
	@Column(name="deptName")
	String deptName;
	
	@Column(name="deptLocation")
	String deptLocation;
	
	

	public DepartmentEntity() {
		super();
	}


	public DepartmentEntity(Integer deptId, String deptName, String deptLocation) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}


	public DepartmentEntity(String deptName, String deptLocation) {
		// TODO Auto-generated constructor stub
		super();
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}
	
	
}
