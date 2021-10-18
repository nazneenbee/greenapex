package com.greenapex.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.entity.ProjectEntity;
import com.greenapex.service.IProjectService;

@RestController
@RequestMapping("api")
public class ProjectController {
	@Autowired
	IProjectService projectService;
	
	@PostMapping("saveproject")
	public ProjectEntity saveProject(@RequestBody ProjectEntity project)
	{
		System.out.println("Saving Student");
		return projectService.saveProject(project);
	}
	
	@GetMapping("showprojects")
	public List<ProjectEntity> showProjectData()
	{
		System.out.println("Show Data");
		return projectService.showProjectData();
	}
	
	@PostMapping("savemultipleproject")
	public List<ProjectEntity> saveMultipleProject(@RequestBody List<ProjectEntity> projects)
	{
		System.out.println("Save multiple Project Data");
	  projects.forEach((project)->projectService.saveProject(project));
	  return projects;
	}
	
	@GetMapping("showproject/{Id}")
	public Optional<ProjectEntity> getProjectById(@PathVariable("Id") Integer Id)
	{
		System.out.println("Show Data By Id");
		return projectService.getProjectById(Id);
	}
	
	@DeleteMapping("deleteproject")
	public void deleteProject(@RequestParam("Id") Integer Id)
	{
		System.out.println("Delete Data By ID");
	    projectService.deleteProjectDataById(Id);
    }
	
	@PutMapping("updateproject")
	public ProjectEntity updateProject(@RequestBody ProjectEntity projectEntity)
	{
		System.out.println("Update Project");
		return projectService.updateProject(projectEntity);
	}
    
}
