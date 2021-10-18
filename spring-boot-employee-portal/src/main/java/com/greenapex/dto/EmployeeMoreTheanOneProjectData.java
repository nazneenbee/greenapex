package com.greenapex.dto;

public class EmployeeMoreTheanOneProjectData {
	
private String empName;
private String projectName;
private Integer projectId;
public EmployeeMoreTheanOneProjectData(String empName, String projectName, Integer projectId) {
	super();
	this.empName = empName;
	this.projectName = projectName;
	this.projectId = projectId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public Integer getProjectId() {
	return projectId;
}
public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}
@Override
public String toString() {
	return "EmployeeMoreTheanOneProjectData [empName=" + empName + ", projectName=" + projectName + ", projectId="
			+ projectId + "]";
}



}
