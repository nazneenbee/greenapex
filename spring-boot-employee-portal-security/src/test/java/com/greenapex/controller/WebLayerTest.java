package com.greenapex.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenapex.entity.DepartmentEntity;
import com.greenapex.service.IDepartmentService;

@WebMvcTest(DepartmentController.class)
public class WebLayerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IDepartmentService service;

	@Test
	public void addDeparment() throws Exception {
		// this.mockMvc.perform ( post("/api/savedepartment") ).andDo ( print ( )
		// ).andExpect ( status ( ).isOk ( ) );
		// this.mockMvc.perform(post("/api/savedepartment")).andDo(print()).andExpect(status().isOk());

//		 this.mockMvc.perform(post("/api/savedepartment")).andDo(print()).andExpect(status().isOk())
//			.andExpect(content().string(containsString("Hello, World")));

		// DepartmentEntity d=new DepartmentEntity("ITTT","Indore");
//		 when(service.saveDepartment(d)).thenReturn
//            ( d); 
		// when( this.mockMvc.perform ( post ( "/api/savedepartment"
		// ).contentType(MediaType.APPLICATION_JSON) )).thenReturn(d);

		/*
		 * mockMvc.perform(post("/api/savedepartment")
		 * .contentType(MediaType.APPLICATION_JSON)
		 * .content("{'deptId': 1, 'deptName': 'unknown', 'deptLocation':'mumbai'}")
		 * .accept(MediaType.APPLICATION_JSON)) .andExpect(status().isCreated())
		 * .andExpect(header().string("Location", "/api/account/12345"))
		 * .andExpect(jsonPath("$.deptId").value("1"))
		 * .andExpect(jsonPath("$.deptName").value("unknown"))
		 * .andExpect(jsonPath("$.deptLocation").value("mumbai")) .andDo ( print ( )
		 * ).andExpect ( status ( ).isOk());
		 */
		DepartmentEntity d=new DepartmentEntity(1,"anything", "anything");
		
		ObjectMapper o=new ObjectMapper();
		
		      mockMvc.perform(post("/api/savedepartment")
		        .contentType("application/json")
		        .content(o.writeValueAsString(d)))
		        .andExpect(status().isOk());
		      
		     /* MvcResult mvcResult = this.mockMvc.perform(get("/api/showdepartment/1")).andReturn();
				String contentAsString = mvcResult.getResponse().getContentAsString();
				System.out.println(contentAsString);
				System.out.println("Success: " + contentAsString);*/

		System.out.println("department added successfully");
	}

	@Test
	public void getDepartment() throws Exception {
		when(service.getDepartmentById(Mockito.anyInt())).thenReturn(new DepartmentEntity(1, "Test", "Pooja"));
		MvcResult mvcResult = this.mockMvc.perform(get("/api/showdepartment/1")).andReturn();
		String contentAsString = mvcResult.getResponse().getContentAsString();
		System.out.println("Success: " + contentAsString);
		assert (contentAsString.isEmpty() == false);
	}

}
