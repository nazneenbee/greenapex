package com.greenapex.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
import com.greenapex.entity.CustomerDummy;
import com.greenapex.entity.StoreOtp;
import com.greenapex.service.ICustomerService;


@Controller
@RequestMapping("api")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@Autowired
    private SimpMessagingTemplate webSocket;
	
	 private final String  TOPIC_DESTINATION = "/lesson/sms";
	 
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
	
	/*@GetMapping("/userdetail")
	   public String userDetail(Principal principal)
	   {
	       System.out.println(principal.getName());
	        
		   //  customerService.getUserDetail(principal.getName());
		     return "demo";
	   }*/
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@ModelAttribute CustomerDummy customer, Model model,HttpSession session) 
	{
		 try{
		session.setAttribute("firstName", customer.getFirstName());
    	session.setAttribute("lastName", customer.getLastName());
    	session.setAttribute("email", customer.getEmail());
    	session.setAttribute("dob", customer.getDob());
    	session.setAttribute("aadharNumber", customer.getAadharNumber());
    	session.setAttribute("gender", customer.getGender());
    	session.setAttribute("panNumber", customer.getPanNumber());
    	session.setAttribute("contact", customer.getContact());
    	session.setAttribute("accountType", customer.getAccountType());
    	
    	
    	model.addAttribute("data",session);
    	   
         customerService.send(customer.getContact());
        System.out.println("hello");
    }
		 
    catch(Exception e){

    	 //return new ResponseEntity<String>("Some Problem",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+customer.getContact());
   // return new ResponseEntity<String>("Otp send successfully",HttpStatus.OK);
    return "otpverify";
}
	
	 @PostMapping("/otp")
		public String saveCustomerData(@ModelAttribute Customer customer,Model model) 
		{
		 System.out.println("Saving Customer");
		/* Customer c=new Customer();
		 c.setFirstName(customer.getFirstName());
		 c.setLastName(customer.getLastName());
		 c.setEmail(customer.getEmail());
		 c.setDob(customer.getDob());
		 c.setAadharNumber(customer.getAadharNumber());
		 c.setPanNumber(customer.getPanNumber());
		 c.setAccountType(customer.getAccountType());
		 c.setContact(customer.getContact());
		 c.setGender(customer.getGender());*/
		 
		 if(customer.getOtp()==StoreOtp.getOtp())
		 	{
			Account accountdetail= customerService.saveCustomer(customer);
			model.addAttribute("detail",accountdetail);
			String s="account created successfully your account number is "+accountdetail.getAccountNumber()+" user id is "+accountdetail.getCustomer().getCustomerId();
			model.addAttribute("message", s);
			return "SuccessPage";
		 	}
		 else
		 {
			 String s="Enter ccorrect otp";
			 model.addAttribute("message", s);
			 return "otpverify";
		 }
	    }

private String getTimeStamp() {
   return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
}
		/*System.out.println("Saving Customer");
		Account accountdetail= customerService.saveCustomer(customer);
		model.addAttribute("detail",accountdetail);
		String s="account created successfully your account number is "+accountdetail.getAccountNumber()+" user id is "+accountdetail.getCustomer().getCustomerId();
		model.addAttribute("message", s);
		return "SuccessPage";*/

	
	@GetMapping("/emailcheck")
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
		
	}
}
