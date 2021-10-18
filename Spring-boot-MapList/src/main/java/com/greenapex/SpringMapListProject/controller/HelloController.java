package com.greenapex.SpringMapListProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/uri/hello")
	public String hello(@RequestParam("name") String name)
	{
		return "Hello Spring Boot using by "+name;
	}

}
