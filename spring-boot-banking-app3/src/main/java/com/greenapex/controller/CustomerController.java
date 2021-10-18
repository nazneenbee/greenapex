package com.greenapex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;
import com.greenapex.service.ICustomerService;


@Controller
@RequestMapping("api")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/newuser")
   public String showUserPage()
   {
	   return "NewUser";
   }
	@GetMapping("/accountdetail")
	   public String showAccountDetailPage()
	   {
		   return "accountdetail";
	   }
	
	@GetMapping("/home")
	   public String showHomePage()
	   {
		   return "home";
	   }
	
	/*@GetMapping("/accountdetail")
	   public String showAccountDetail()
	   {
		   return "accountdetail";
	   }*/
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute Customer customer, Model model) 
	{
		System.out.println("Saving Customer");
		Account accountdetail= customerService.saveCustomer(customer);
		model.addAttribute("detail",accountdetail);
		return "accountdetail";
	}
	
	@GetMapping("/emailcheck")
	public @ResponseBody String validateEmail(@RequestParam String email)
	{ 
		String msg="";
		if(customerService.isEmailExist(email))
		{
			msg=email+" already exist";
		}
		return msg;
		
	}

}
