package com.greenapex.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import com.greenapex.entity.DepartmentEntity;
import com.greenapex.service.IDepartmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.greenapex.controller.DepartmentController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	 @MockBean
	    private IDepartmentService service;
	 
	 DepartmentEntity d=new DepartmentEntity(50,"Test", "Pooja" );
	 @BeforeEach
	    public void addDeparment ( ) throws Exception {
		 
	        System.out.println ( " Department added Successfully" );
	    }

	    @Test
	    public void getDepartment () throws Exception {
	    	when ( service.getDepartmentById( Mockito.anyInt( ) ) ).thenReturn
            ( new DepartmentEntity(50,"Test", "Pooja" ) );
	        MvcResult mvcResult = this.mockMvc.perform ( get ( "/api/showdepartment/50" ) ).andReturn ( );
	        String contentAsString = mvcResult.getResponse ( ).getContentAsString ( );
	        System.out.println ( "Success: " + contentAsString );
	        assert (contentAsString.isEmpty ( ) == false);
	    }

}
