package com.greenapex.service;

import java.util.List;
import java.util.Optional;

import com.greenapex.entity.StudentEntity;

public interface IStudentService {
	public StudentEntity saveStudent(StudentEntity student);
	public List<StudentEntity> showStudentData();
	public Optional<StudentEntity> getStudentById(Integer Id);
	public Boolean deleteDataById(Integer Id);
	public StudentEntity updateStudent(StudentEntity student);
}
