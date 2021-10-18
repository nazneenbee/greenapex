package com.greenapex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenapex.entity.ProjectEntity;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectEntity, Integer>{

}
