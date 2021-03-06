package com.greenapex.service;

import java.util.List;
import java.util.Optional;

import com.greenapex.entity.DepartmentEntity;

public interface IDepartmentService {
	public DepartmentEntity saveDepartment(DepartmentEntity DepartmentEntity);
	public List<DepartmentEntity> showDepartmentData();
	public Optional<DepartmentEntity> getDepartmentById(Integer Id);
	public Boolean deleteDepartmentDataById(Integer Id);
	public DepartmentEntity updateDepartment(DepartmentEntity DepartmentEntity);
}
