package com.greenapex.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.greenapex.service.IAccountService;
import com.greenapex.service.ICustomerService;

@Component
public class TestRunner  implements CommandLineRunner{
	
	@Autowired
	private IAccountService service;
	
	private ICustomerService custService;
	
	
	@Override
	public void run(String... args) throws Exception  {
		//System.out.println(service.FindAccountByCustomerId(1));
		/*Customer c=new Customer();
		c.setEmail("Nazneen@gmail.com");
		custService.saveCustomerDetail(c)*/
		
	}

}
