package com.greenapex.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer projectId;
	@Column(name="projectName")
	String projectName;
	
	@Column(name="clientName")
	String clientName;
	
	@Column(name="projectStartDate")
	String projectStartDate;
	
	@Column(name="projectEndDate")
	String projectEndDate;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private Set<EmployeeEntity> employee=new HashSet<EmployeeEntity>();

	
	
	public ProjectEntity(Integer projectId, String projectName, String clientName, String projectStartDate,
			String projectEndDate, Set<EmployeeEntity> employee) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.employee = employee;
	}

	public ProjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeEntity> employee) {
		this.employee = employee;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	@Override
	public String toString() {
		return "ProjectEntity [projectId=" + projectId + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + "]";
	}
	
}
