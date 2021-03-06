package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.Exception.DataNotAvailableException;
import com.greenapex.Exception.IdNotValidException;
import com.greenapex.entity.DepartmentEntity;
import com.greenapex.entity.EmployeeEntity;
import com.greenapex.repository.IDepartmentRepository;
import com.greenapex.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
   @Autowired
   IDepartmentRepository departmentRepository;

@Override
public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
	if(departmentEntity.getDeptName().isEmpty() || departmentEntity.getDeptLocation().isEmpty())
	{
		throw new DataNotAvailableException();
	}
	else
	{
	return departmentRepository.save(departmentEntity);
	}
}

@Override
public List<DepartmentEntity> showDepartmentData() {
	if(departmentRepository.findAll().isEmpty())
	{
		throw new DataNotAvailableException();
	}
	else
	{
	return departmentRepository.findAll();
	}
}

@Override
public Optional<DepartmentEntity> getDepartmentById(Integer Id) {
	Optional<DepartmentEntity> emp= departmentRepository.findById(Id);
	if(emp.isPresent())
	{
		return emp;
	}
	else
	{
		throw new IdNotValidException();
	}
}

@Override
public void deleteDepartmentDataById(Integer Id) {
	// TODO Auto-generated method stub
	Optional<DepartmentEntity> emp= departmentRepository.findById(Id);
	if(emp.isPresent())
	{
		departmentRepository.deleteById(Id);
	}
	else
	{
		throw new IdNotValidException();
	}
}

@Override
public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity) {
	Optional<DepartmentEntity> id= departmentRepository.findById(departmentEntity.getDeptId());
	if(id.isPresent())
	{
	DepartmentEntity dept=departmentRepository.findById(departmentEntity.getDeptId()).orElse(null);
	dept.setDeptName(departmentEntity.getDeptName());
	dept.setDeptLocation(departmentEntity.getDeptLocation());
	
	return departmentRepository.save(dept);
	}
	else
	{
		throw new IdNotValidException();
	}
}
	
}
