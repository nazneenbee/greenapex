package com.greenapex.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.repository.IDepartmentRepository;
import com.greenapex.service.impl.DepartmentServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DepartmentServiceTestSecond {
	
	@InjectMocks
   DepartmentServiceImpl departmentService;

    @Mock
    IDepartmentRepository departmentReposity;


    @BeforeEach
    public void setUp(){
        when(departmentReposity.save ( Mockito.any () )).thenReturn (createDummyDepartment() );
        when(departmentReposity.findById ( Mockito.any () )).thenReturn ( Optional.of ( createDummyDepartment() ));
    }

    @DisplayName("Test create department")
    @Test
    public void testCreateDepartment() throws Exception{
        DepartmentEntity d = departmentService.saveDepartment(createDummyDepartment());
        String deptName=d.getDeptName();
        assertEquals("XYZ",deptName );
    }

    @DisplayName("Test Get Department")
    @Test
    public void testGetDepartment() throws Exception {
    	  DepartmentEntity d = departmentService.getDepartmentById(1);
    	  String deptName=d.getDeptName();
    	  System.out.println(deptName);
          assertEquals("XYZ",deptName);
    }

    public static DepartmentEntity createDummyDepartment ( ) {
       DepartmentEntity d = new DepartmentEntity("XYZ","Mumbai");
       
        return d;
    }


}
