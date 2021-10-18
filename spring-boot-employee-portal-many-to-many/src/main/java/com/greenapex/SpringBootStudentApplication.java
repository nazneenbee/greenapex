package com.greenapex;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.greenapex.entity.EmployeeEntity;
import com.greenapex.entity.ProjectEntity;
import com.greenapex.repository.IEmployeeRepository;
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootStudentApplication implements CommandLineRunner{
	@Autowired
    private IEmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeEntity employee=new EmployeeEntity();
		employee.setEmpName("vasid");
		employee.setEmpRole("civil engineer");
		
		ProjectEntity project=new ProjectEntity();
		project.setProjectName("Employee Management System");
		
		ProjectEntity project1=new ProjectEntity();
		project1.setProjectName("Content Management System");
		
		employee.getProject().add(project);
        employee.getProject().add(project1);
        
        project.getEmployee().add(employee);
        project1.getEmployee().add(employee);

        employeeRepository.save(employee);
			
	}

}
