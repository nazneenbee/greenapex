package com.greenapex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class SpringSecurityCheckController {
	@GetMapping("/hello")
	@ResponseBody
	public String showData()
	{
		return "helloall";
	}
	@GetMapping("/welcomeemployee")
	public String showemployeeData()
	{
		return "welcomeemp";
	}
	@GetMapping("/welcomeadmin")
	public String showAdminData()
	{
		return "welcomead";
	}
}
