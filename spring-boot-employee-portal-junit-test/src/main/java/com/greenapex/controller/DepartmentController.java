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

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.service.IDepartmentService;

@RestController
@RequestMapping("api")
public class DepartmentController {
	@Autowired
	IDepartmentService departmentService;
	
	@PostMapping("savedepartment")
	public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity department) 
	{
		System.out.println("Saving Department");
		System.out.println(department.getDeptName());
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("showdepartments")
	public List<DepartmentEntity> showStudentData()
	{
		System.out.println("Show Data");
		return departmentService.showDepartmentData();
	}
	
	@PostMapping("savemultipledepartment")
	public List<DepartmentEntity> saveMultipleStudent(@RequestBody List<DepartmentEntity> departments)
	{
		System.out.println("Save multiple Department Data");
	  departments.forEach((department)->departmentService.saveDepartment(department));
	  return departments;
	}
	
	@GetMapping("showdepartment/{Id}")
	public DepartmentEntity getStudentById(@PathVariable("Id") Integer Id)
	{
		return departmentService.getDepartmentById(Id);
		
	}
	
	@DeleteMapping("deletedepartment/{Id}")
	public void deleteDepartment(@PathVariable("Id") Integer Id)
	{
		System.out.println("Delete Data By ID");
		 departmentService.deleteDepartmentDataById(Id);
    }
	
	@PutMapping("updatedepartment")
	public DepartmentEntity updateStudent(@RequestBody DepartmentEntity departmentEntity)
	{
		System.out.println("Update Department");
		return departmentService.updateDepartment(departmentEntity);
	}
    
}
