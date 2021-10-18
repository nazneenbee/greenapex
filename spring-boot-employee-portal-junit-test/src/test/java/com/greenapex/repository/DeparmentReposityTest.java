package com.greenapex.repository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenapex.entity.DepartmentEntity;

@RunWith (SpringRunner.class)
@SpringBootTest
public class DeparmentReposityTest {
	
	@Autowired
    private IDepartmentRepository departmentRepository;
	
	 @BeforeEach
	    void initUseCase ( ) {
	        List<DepartmentEntity> departmentEntity = Arrays.asList (
	                new DepartmentEntity ("IT", "CS" ),
	                new DepartmentEntity ("EC", "Support" ),
	                new DepartmentEntity ("Civil", "TL" )
	        );
	        departmentRepository.saveAll(departmentEntity);
	    }
	 
	  /*  @AfterEach
	    public void destroyAll ( ) {
		 departmentRepository.deleteById(50);
	    }*/

	    @Test
	    void saveAll_success ( ) {
	        List<DepartmentEntity> allDepartment = (List<DepartmentEntity>) departmentRepository.findAll ( );

	        AtomicInteger validIdFound = new AtomicInteger ( );
	        allDepartment.forEach ( department -> {
	            if (department.getDeptId() > 0) {
	                validIdFound.getAndIncrement ( );
	            }
	        } );

	        assert (validIdFound.intValue ( ) >= 3);
	    }

	    @Test
	    void findAll_success ( ) {
	        List<DepartmentEntity> allCustomer = (List<DepartmentEntity>) departmentRepository.findAll ( );
	        System.out.println(allCustomer.size());
	        assert (allCustomer.size ( ) > 1);
	    }

}
