package com.greenapex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenapex.entity.DepartmentEntity;


@Repository
public interface IDepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{

}
