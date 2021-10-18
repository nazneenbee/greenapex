package com.greenapex.controller;

import java.security.Principal;

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
	
	
	/*@GetMapping("/userdetail")
	   public String userDetail(Principal principal)
	   {
	       System.out.println(principal.getName());
	        
		   //  customerService.getUserDetail(principal.getName());
		     return "demo";
	   }*/
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute Customer customer, Model model) 
	{
		System.out.println("Saving Customer");
		Customer c=customerService.saveCustomer(customer);
	    String s="Customer added successfully customer id is "+c.getCustomerId()+" and first name is "+c.getFirstName();
		model.addAttribute("message",s);
		return "SuccessPage";
	}
	
	/*@GetMapping("/emailcheck")
	public @ResponseBody String validateemail(@RequestParam String email)
	{ 
		String msg="";
		if(customerService.isEmailExist(email)>0)
		{
			msg=email+" already exist";
		}
		return msg;
		
	}

	@GetMapping("/contactcheck")
	public @ResponseBody String validatecontact(@RequestParam String contact)
	{ 
		String msg="";
		if(customerService.contByContactNumber(contact)>0)
		{
			msg=contact+" already exist";
		}
		return msg;
		
	}*/
}
