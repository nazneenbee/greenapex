package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.Exception.URLNotProperException;
import com.greenapex.dto.EmloyeeDepartmentData;
import com.greenapex.dto.EmployeeMoreTheanOneProjectData;
import com.greenapex.dto.EmployeeRespectiveManagerName;
import com.greenapex.dto.HighestSalaryEmployeeDetail;
import com.greenapex.entity.EmployeeEntity;
import com.greenapex.repository.IEmployeeRepository;
import com.greenapex.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
   @Autowired
   IEmployeeRepository employeeRepository;

@Override
public EmployeeEntity saveEmployee(EmployeeEntity employee)
{
	return employeeRepository.save(employee);
}

@Override
public List<EmployeeEntity> showEmployeeData() {
	return employeeRepository.findAll();
}

@Override
public Optional<EmployeeEntity> getEmployeeById(Integer Id) {
	return employeeRepository.findById(Id);
}

@Override
public Boolean deleteEmployeeDataById(Integer Id) {
	// TODO Auto-generated method stub
	Boolean result=false;
	Optional<EmployeeEntity> id= employeeRepository.findById(Id);
	if(id.isPresent())
	{
		employeeRepository.deleteById(Id);
	    return result=true;
	}
	
	     return result;
}

@Override
public EmployeeEntity updateEmployee(EmployeeEntity employee) {
	// TODO Auto-generated method stub
	EmployeeEntity emp=employeeRepository.findById(employee.getEmpId()).orElse(null);
	emp.setEmpName(employee.getEmpName());
	emp.setEmpRole(employee.getEmpRole());
	emp.setEmpSalary(employee.getEmpSalary());
	emp.setEmpAddress(employee.getEmpAddress());
	emp.setDepartment(employee.getDepartment());
	//emp.setProject(employee.getClass().);
	return employeeRepository.save(emp);
}

@Override
public List<HighestSalaryEmployeeDetail> MaxSalaryDept() {
	// TODO Auto-generated method stub
	return employeeRepository.highestSaleryDeptjoin();
}

@Override
public List<EmployeeRespectiveManagerName> ShowEmployeeNameManagerNameDetail() {
	// TODO Auto-generated method stub
	return employeeRepository.EmployeeManagerDetail();
}

@Override
public List<EmloyeeDepartmentData> ShowEmpDeptTData() {
	// TODO Auto-generated method stub
	return employeeRepository.ShowEmpDeptTableData();
}
/*
@Override
public List<EmployeeMoreTheanOneProjectData> ShowEmpDetailMoreThanOneProject() {
	// TODO Auto-generated method stub
	return employeeRepository.ShowEmpDetailMoreThanOnePro();
}*/

}
