package com.greenapex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.Exception.DataNotAvailableException;
import com.greenapex.Exception.IdNotValidException;
import com.greenapex.entity.DepartmentEntity;
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
	if(project.getProjectName().isEmpty() || project.getClientName().isEmpty())
	{
		throw new DataNotAvailableException();
	}
	else
	{
	return projectRepository.save(project);
	}
}

@Override
public List<ProjectEntity> showProjectData() {
	if(projectRepository.findAll().isEmpty())
	{
		throw new DataNotAvailableException();
	}
	else
	{
	return projectRepository.findAll();
	}
}

@Override
public Optional<ProjectEntity> getProjectById(Integer Id) {
	Optional<ProjectEntity> project= projectRepository.findById(Id);
	if(project.isPresent())
	{
		return project;
	}
	else
	{
		throw new IdNotValidException();
	}
}

@Override
public void deleteProjectDataById(Integer Id) {
	// TODO Auto-generated method stub
	Optional<ProjectEntity> project= projectRepository.findById(Id);
	if(project.isPresent())
	{
		projectRepository.deleteById(Id);
	}
	else
	{
		throw new IdNotValidException();
	}
}

@Override
public ProjectEntity updateProject(ProjectEntity project) {
	Optional<ProjectEntity> pro= projectRepository.findById(project.getProjectId());
	if(pro.isPresent())
	{
	ProjectEntity proj=projectRepository.findById(project.getProjectId()).orElse(null);
	proj.setProjectName(project.getProjectName());
	proj.setClientName(project.getClientName());
	proj.setProjectStartDate(project.getProjectStartDate());
	proj.setProjectEndDate(project.getProjectEndDate());
	return projectRepository.save(proj);
	}
	else
	{
		throw new IdNotValidException();
	}
}
	

}
