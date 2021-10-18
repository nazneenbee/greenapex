package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.repository.IDepartmentRepository;
import com.greenapex.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
   @Autowired
   IDepartmentRepository departmentRepository;

@Override
public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
	// TODO Auto-generated method stub
	return departmentRepository.save(departmentEntity);
}

@Override
public List<DepartmentEntity> showDepartmentData() {
	// TODO Auto-generated method stub
	return departmentRepository.findAll();
}

@Override
public Optional<DepartmentEntity> getDepartmentById(Integer Id) {
	// TODO Auto-generated method stub
	return departmentRepository.findById(Id);
}

@Override
public Boolean deleteDepartmentDataById(Integer Id) {
	// TODO Auto-generated method stub
	Boolean result=false;
	Optional<DepartmentEntity> id= departmentRepository.findById(Id);
	if(id.isPresent())
	{
		departmentRepository.deleteById(Id);
	return result=true;
	}
	
	return result;
}

@Override
public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity) {
	// TODO Auto-generated method stub
	DepartmentEntity dept=departmentRepository.findById(departmentEntity.getDeptId()).orElse(null);
	dept.setDeptName(departmentEntity.getDeptName());
	dept.setDeptLocation(departmentEntity.getDeptLocation());
	
	return departmentRepository.save(dept);
}
	
}
