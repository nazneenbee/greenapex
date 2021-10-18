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

import com.greenapex.entity.StudentEntity;
import com.greenapex.service.IStudentService;

@RestController
@RequestMapping("api")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@PostMapping("savestudent")
	public StudentEntity saveStudent(@RequestBody StudentEntity student)
	{
		System.out.println("Saving Student"+student.getRollNo());
		return studentService.saveStudent(student);
	}
	
	@GetMapping("showstudents")
	public List<StudentEntity> showStudentData()
	{
		System.out.println("Show Data");
		return studentService.showStudentData();
	}
	
	@PostMapping("savemultiplestudent")
	public List<StudentEntity> saveMultipleStudent(@RequestBody List<StudentEntity> students)
	{
		System.out.println("Save multiple Student Data");
	  students.forEach((student)->studentService.saveStudent(student));
	  return students;
	}
	
	@GetMapping("showstudent/{Id}")
	public Optional<StudentEntity> getStudentById(@PathVariable("Id") Integer Id)
	{
		System.out.println("Show Data By Id");
		return studentService.getStudentById(Id);
	}
	
	@DeleteMapping("deletestudent")
	public Boolean deleteStudent(@RequestParam("Id") Integer Id)
	{
		System.out.println("Delete Data By ID");
		return studentService.deleteDataById(Id);
    }
	
	@PutMapping("updatestudent")
	public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity)
	{
		System.out.println("Update Student");
		return studentService.updateStudent(studentEntity);
	}
    
}
