package com.greenapex.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.greenapex.dto.EmloyeeDepartmentData;
import com.greenapex.dto.EmployeeMoreTheanOneProjectData;
import com.greenapex.dto.EmployeeRespectiveManagerName;
import com.greenapex.dto.HighestSalaryEmployeeDetail;
import com.greenapex.entity.EmployeeEntity;
import com.greenapex.service.IEmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;
	
	@PostMapping("saveemployee")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee)
	{ 
		System.out.println("Saving Employee");
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("showemployees")
	public List<EmployeeEntity> showEmployeeData()
	{
		System.out.println("Show Data");
		return employeeService.showEmployeeData();
	}
	
	@PostMapping("savemultipleemployee")
	public List<EmployeeEntity> saveMultipleEmployees(@RequestBody List<EmployeeEntity> employees)
	{
		System.out.println("Save multiple Employee Data");
	  employees.forEach((employee)->employeeService.saveEmployee(employee));
	  return employees;
	}
	
	@GetMapping("showemployee/{Id}") 
	public Optional<EmployeeEntity> getEmployeeById(@PathVariable("Id") Integer Id)
	{
		System.out.println("Show Data By Id");
		
		return employeeService.getEmployeeById(Id);
	}
	
	@DeleteMapping("deleteemployee")
	public void deleteEmployee(@RequestParam("Id") Integer Id)
	{
		System.out.println("Delete Data By ID");
		employeeService.deleteEmployeeDataById(Id);
    }
	
	@PutMapping("updateemployee")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		System.out.println("Update Employee");
		return employeeService.updateEmployee(employeeEntity);
	}
	@GetMapping("highestSalary")
	public List<HighestSalaryEmployeeDetail> MaxSalaryDept() {
		// TODO Auto-generated method stub
		return employeeService.MaxSalaryDept();
	}
	
	@GetMapping("employeemanagerdetail")
	public List<EmployeeRespectiveManagerName> ShowEmployeeNameManagerNameDetail() {
		// TODO Auto-generated method stub
		return employeeService.ShowEmployeeNameManagerNameDetail();
	}
	
	@GetMapping("empdepttabledetail")
	public List<EmloyeeDepartmentData> ShowEmpDeptTData() {
		// TODO Auto-generated method stub
		return employeeService.ShowEmpDeptTData();
	}
	
	@GetMapping("empdetailmorethanoneproject")
	public List<EmployeeMoreTheanOneProjectData> ShowEmpDetailMoreThanOneProject() {
		// TODO Auto-generated method stub
		return employeeService.ShowEmpDetailMoreThanOneProject();
	}
}
