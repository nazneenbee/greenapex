package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.entity.ProjectEntity;
import com.greenapex.repository.IProjectRepository;
import com.greenapex.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService{
	
   @Autowired
   IProjectRepository projectRepository;

@Override
public ProjectEntity saveProject(ProjectEntity project) {
	// TODO Auto-generated method stub
	return projectRepository.save(project);
}

@Override
public List<ProjectEntity> showProjectData() {
	// TODO Auto-generated method stub
	return projectRepository.findAll();
}

@Override
public Optional<ProjectEntity> getProjectById(Integer Id) {
	// TODO Auto-generated method stub
	return projectRepository.findById(Id);
}

@Override
public Boolean deleteProjectDataById(Integer Id) {
	// TODO Auto-generated method stub
	Boolean result=false;
	Optional<ProjectEntity> id= projectRepository.findById(Id);
	if(id.isPresent())
	{
	projectRepository.deleteById(Id);
	return result=true;
	}
	
	return result;
}

@Override
public ProjectEntity updateProject(ProjectEntity project) {
	// TODO Auto-generated method stub
	ProjectEntity pro=projectRepository.findById(project.getProjectId()).orElse(null);
	pro.setProjectName(project.getProjectName());
	pro.setClientName(project.getClientName());
	pro.setProjectStartDate(project.getProjectStartDate());
	pro.setProjectEndDate(project.getProjectEndDate());
	return projectRepository.save(pro);
}
	

}
