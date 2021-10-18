package com.home.accountsservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.accountsservice.model.Customer;
import com.mysql.cj.xdevapi.JsonString;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONString;

/*
 * In this test, the full Spring application context is started but without the server
 * */
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

 
    
    @BeforeEach
    public void addCustomer ( ) throws Exception {
    	   ObjectMapper mapper=new ObjectMapper();
    	   String testJson = "{\n" + "  \"user\": {\n" + "    \"0\": {\n" + "      \"firstName\": \"Monica\",\n" + "      \"lastName\": \"Belluci\"\n" + "    },\n" + "    \"1\": {\n" + "      \"firstName\": \"John\",\n" + "      \"lastName\": \"Smith\"\n" + "    },\n" + "    \"2\": {\n" + "      \"firstName\": \"Owen\",\n" + "      \"lastName\": \"Hargreaves\"\n" + "    }\n" + "  }\n" + "}";
    	Customer c = mapper.readValue(testJson, Customer.class);
         System.out.println(c);
//    	when( this.mockMvc.perform ( post ( "/customer/add" ) )).thenReturn((ResultActions) c);
//        this.mockMvc.perform ( post ( "/customer/add" ) ).andDo ( print ( ) ).andExpect ( status ( ).isOk ( ) );
        System.out.println ( "Customers added Successfully" );
    }

    @Test
    public void getCustomer ( ) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform ( get ( "/customer/1" ) ).andReturn ( );
        String contentAsString = mvcResult.getResponse ( ).getContentAsString ( );
        System.out.println ( "Success: " + contentAsString );
        assert (contentAsString.isEmpty ( ) == false);
    }
}