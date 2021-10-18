package com.greenapex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenapex.entity.StudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Integer>{

}
