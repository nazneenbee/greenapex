package com.greenapex.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;
import com.greenapex.entity.Registration;
import com.greenapex.repository.IAccountRepository;
import com.greenapex.repository.IRegUserRepository;
import com.greenapex.service.IAccountService;
import com.greenapex.service.ICustomerService;
import com.greenapex.service.IRegUserService;

@Controller
@RequestMapping
public class RegUserController {
	@Autowired
	IRegUserService regUserService;
	
	@Autowired
	IAccountService accountService;
	
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/api/userreg")
	   public String userRegistration()
	   {
		   return "Registration";
	   }
	
	@GetMapping("/api/loginsuccess")
	   public String userLoginSuccess(Principal principal, HttpSession session)
	   {
		   Registration r=regUserService.findUserByUserName(principal.getName());
		   session.setAttribute("user", r.getUserName());
		   return "loginsuccess";
	   }
	
	@GetMapping("/api/deposit")
	public String deposit()
	{
		return "deposit";
	}
	
	@PostMapping("/api/depositamount")
	public String amountDeposit(Principal principal, HttpSession session, Model model,@ModelAttribute Account account)
	{
		session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		  System.out.println(a.getBalance());
		  
		  double bal=a.getBalance()+account.getBalance();
		  System.out.println(bal);
		  if(a!=null)
		  {
			  Account a1=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
			  a1.setBalance(bal);
			  accountService.saveAccount(a1);
		  }
		  String s="deposit successful your current balance is = "+bal;
		  model.addAttribute("deposit",s);
		return "depositsuccess";
		
	}
	
	@GetMapping("/api/withdraw")
	public String withdraw()
	{
		return "withdraw";
	}
	
	@PostMapping("/api/withdrawamount")
	public String amountWithdraw(Principal principal, HttpSession session, Model model,@ModelAttribute Account account) throws Exception
	{
		session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		  //System.out.println(a.getBalance());
		  
		  if(a.getBalance()>2000 && account.getBalance()<=a.getBalance()-2000)
		  {
		  double bal=a.getBalance()-account.getBalance();
		  System.out.println(bal);
		  if(a!=null)
		  {
			  Account a1=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
			  a1.setBalance(bal);
			  accountService.saveAccount(a1);
		  }
		  
		  String s="withdraw successful your current balance is = "+bal;
		  model.addAttribute("withdraw",s);
		  }
		  else
		  {
			  String s="withdraw unsuccessful because when transfer "+account.getBalance()+" your balance is less than 2000 your current balance is = "+a.getBalance();
			  model.addAttribute("withdraw",s);
		  }
		
		return "withdrawsuccess";
		
	}
	
	
	@GetMapping("/api/checkbalace")
	public String getAccountDetail(Principal principal, HttpSession session, Model model)
	{
		session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		  session.setAttribute("acc", a);
		return "checkbalance";
	}
	
	@PostMapping("/api/savereguser")
	public String saveRegisterUser(@ModelAttribute Registration registration, Model model) 
	{
		System.out.println("Saving registered User");
		Registration registerUser= regUserService.saveRegisterUser(registration);
		//model.addAttribute("regUserDetail",registerUser);
		return "RegistrationSuccess";
		
	}
	
	@GetMapping("/api/userprofile")
	public String userProfile(Principal principal, HttpSession session, Model model) 
	{
		 session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		  model.addAttribute("customerreg",r);
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		    model.addAttribute("account",a);
			 session.setAttribute("acc", a);
		   return "profile";
		
	}
	
	@GetMapping("/api/userdetail")
	   public String SuccessPage(Principal principal, HttpSession session, Model model)
	   {
		  session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		
		  model.addAttribute("customerreg",r);
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		    model.addAttribute("account",a);
			 session.setAttribute("acc", a);
		  
		   return "accountdetail";
	   }
	
	@PostMapping("/api/userupdate")
	public String updateProfile(Principal principal,HttpSession session)
	{
		
		session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		
		  session.setAttribute("userreg", r);
		  Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
			 session.setAttribute("acc", a);
		  
		return "userupdate";
	}
   
	@PostMapping("/api/saveupdateddata")
	public String saveUpdateData(Principal principal,HttpSession session,@ModelAttribute Customer customer, Model model)
	{ 
		session.setAttribute("user", principal.getName());
		  
		  Registration r=regUserService.findUserByUserName(principal.getName());
		
		  session.setAttribute("userreg", r);
		  
		  Customer c=customerService.findCustomerByCustomerId(r.getCustomer().getCustomerId());
		  
		  
		  if(c!=null)
		  {
			  Customer c1=customerService.findCustomerByCustomerId(r.getCustomer().getCustomerId());
			 c1.setFirstName(customer.getFirstName());
			 c1.setLastName(customer.getLastName());
			 c1.setEmail(customer.getEmail());
			 c1.setGender(customer.getGender());
			 c1.setDob(customer.getDob());
			 c1.setAadharNumber(customer.getAadharNumber());
			 c1.setContact(customer.getContact());
			 c1.setPanNumber(customer.getPanNumber());
			 c1.setAccountType(customer.getAccountType());
			 customerService.saveCustomerDetail(c1);
			  
		  }
		  
		  return "updatesuccessful";
	}
	
	@GetMapping("/api/transfermoney")
	public String transferMoneyForm()
	{
		return "moneytransfer";
	}
	
	@PostMapping("/api/amounttranfersuccess")
	public String transferMoney(Principal principal,HttpSession session,@ModelAttribute Account account, Model model)
	{
		session.setAttribute("user", principal.getName());
		Registration r=regUserService.findUserByUserName(principal.getName());
		Account a=accountService.FindAccountByCustomerId(r.getCustomer().getCustomerId());
		System.out.println(a.getBalance());
		
		Account acc=accountService.FindAccountByAccountNumber(account.getAccountNumber());
		System.out.println(acc.getBalance());
	    //double bal=acc.getBalance()+account.getBalance();
		if(a.getAccountNumber().equals(account.getAccountNumber()))
	    {
	    	 String s="transfer unsuccessful because you are trying to transfer in same account";
			  model.addAttribute("message",s);
	    }
		else if(a!=null && acc!=null && a.getBalance()>2000 && account.getBalance()<=a.getBalance()-2000 )
	    {
	    	double bal1=acc.getBalance()+account.getBalance();
	    	double bal2=a.getBalance()-account.getBalance();
	    	a.setBalance(bal2);
	    	acc.setBalance(bal1);
	    	accountService.saveAccount(a);
	    	accountService.saveAccount(acc);
	    	String s="deposit to account "+acc.getAccountNumber()+" is successful your current balance is = "+bal2;
			model.addAttribute("message",s);
	    }
	    else
		  {
			  String s="transfer unsuccessful because when transfer "+account.getBalance()+" your balance is less than 2000 your current balance is = "+a.getBalance();
			  model.addAttribute("message",s);
		  }
	    
		return "transfersuccess";
	}
}
