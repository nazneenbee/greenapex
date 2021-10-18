package com.greenapex.sanitytest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.greenapex.entity.DepartmentEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DepartmentTest {

	 //@LocalServerPort
    private int port = 9090;

    @Autowired
    private TestRestTemplate restTemplate;

    public String BASE_URL = new StringBuilder().append("http://localhost:").append(port).toString();

    @Test
    public void addDepartment() throws Exception {

        this.restTemplate.postForEntity(BASE_URL + "/api/savedepartment",
                new DepartmentEntity("CS", "abcde"), String.class);
        assert (this.restTemplate.getForObject(BASE_URL + "/api/showdepartments",
                List.class).size() > 1);
    }
    
    @Test
    public void deleteDepartments() {
		
		
//		  Map<String, Integer> params = new HashMap<String, Integer>();
//		  params.put("Id",22);
		 
       restTemplate.delete(BASE_URL + "/api/deletedepartment/33");
    }
    
    public String getBASE_URL() {
        return BASE_URL;
    }
    
}
