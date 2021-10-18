package com.greenapex.service;

import java.util.List;
import java.util.Optional;

import com.greenapex.entity.ProjectEntity;

public interface IProjectService {
	public ProjectEntity saveProject(ProjectEntity project);
	public List<ProjectEntity> showProjectData();
	public Optional<ProjectEntity> getProjectById(Integer Id);
	public void deleteProjectDataById(Integer Id);
	public ProjectEntity updateProject(ProjectEntity project);
}
