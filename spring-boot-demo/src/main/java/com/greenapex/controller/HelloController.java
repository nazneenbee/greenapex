package com.greenapex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//
//	@GetMapping("/hello")
//	public String greeting(@RequestParam("name") String name)
//	{
//		return "green apex "+name;
//	}
	
	

	@GetMapping("/hello/{name}")
	public String greeting(@PathVariable("name") String name)
	{
		return "green apex "+name;
	}
}
