package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.entity.StudentEntity;
import com.greenapex.repository.IStudentRepository;
import com.greenapex.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
   @Autowired
   IStudentRepository studentRepository;
	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return studentRepository.save(student);
	}
	@Override
	public List<StudentEntity> showStudentData() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Optional<StudentEntity> getStudentById(Integer Id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(Id);
	}
	@Override
	public Boolean deleteDataById(Integer Id) {
		Boolean result=false;
		Optional<StudentEntity> id= studentRepository.findById(Id);
		if(id.isPresent())
		{
		studentRepository.deleteById(Id);
		return result=true;
		}
		
		return result;
	}
	@Override
	public StudentEntity updateStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		StudentEntity stu=studentRepository.findById(student.getRollNo()).orElse(null);
		stu.setName(student.getName());
		stu.setEmail(student.getEmail());
		stu.setCourse(student.getCourse());
		stu.setBranch(student.getBranch());
		return studentRepository.save(stu);
	}


}
