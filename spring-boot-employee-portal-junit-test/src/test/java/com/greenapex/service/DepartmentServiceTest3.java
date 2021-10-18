package com.greenapex.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.repository.IDepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest3 {
	@Autowired
	IDepartmentService deptservice;
	
	@MockBean
	IDepartmentRepository deptrepository;
	
	/*@Test
	public void getAllDepartment()
	{
		when(deptrepository.findAll()).thenReturn(Stream.of(new DepartmentEntity(1,"anything", "anything"), 
				new DepartmentEntity(2,"whatever", "whatever")).collect(Collectors.toList()));
		
		//System.out.println(deptservice.showDepartmentData());
		assertEquals(2, deptservice.showDepartmentData().size());
	}
	@Test
	public void findUserById()
	{
		when(deptrepository.findById(1)).thenReturn(Optional.of(new DepartmentEntity(1,"anything", "anything")));
		System.out.println(deptservice.getDepartmentById(1));
		assertEquals(1, deptservice.getDepartmentById(1).getDeptId().intValue());
		
	}*/
	DepartmentEntity d;
	@BeforeEach
	public void saveDepartment()
	{
		d=new DepartmentEntity(1,"anything","anything");
		when(deptrepository.save(d)).thenReturn(d);
		assertEquals(d, deptservice.saveDepartment(d));
		
	}
	/*@Test
	public void deleteDepartment()
	{
		//DepartmentEntity d=new DepartmentEntity(1,"anything","anything");
		System.out.println(d.getDeptId());
		deptservice.deleteDepartmentDataById(d.getDeptId());
		verify(deptrepository,times(1)).deleteById(d.getDeptId());
	}
	*/
	

}
