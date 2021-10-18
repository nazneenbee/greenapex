package com.greenapex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.service.impl.DepartmentServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest {
	
	/* @Autowired
	    IDepartmentService department;*/
	 
	 @Autowired
	 DepartmentServiceImpl dept;

		private DepartmentEntity d = new DepartmentEntity( 31, "IT", "abc" );

	    @BeforeEach
	    public void createDepartment ( ) {
	        dept.createDepartment(d);
	    }

	    @Test
	    public void getDepartment ( ) {
	    	DepartmentEntity d = dept.getDepartmentById(34);
	    	
	    	
	        System.out.println ( d );
	        assert d != null;
	    }

}
