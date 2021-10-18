package com.greenapex.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne
	@JoinColumn(name ="empId")
	private EmployeeEntity employee;
	

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
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
