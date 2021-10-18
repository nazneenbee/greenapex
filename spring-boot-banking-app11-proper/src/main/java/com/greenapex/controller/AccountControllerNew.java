package com.greenapex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.entity.Account;
import com.greenapex.service.IAccountService;

@RestController
@RequestMapping("api")
public class AccountControllerNew {
	@Autowired
	IAccountService accountService;
	
	@PostMapping("saveaccount")
	public Account saveAccount(@RequestBody Account account) 
	{
		System.out.println("Saving Account");
		return accountService.saveAccount(account);
	}
	
	

}
