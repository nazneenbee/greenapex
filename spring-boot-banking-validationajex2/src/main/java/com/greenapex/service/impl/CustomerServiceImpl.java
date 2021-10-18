package com.greenapex.service.impl;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;
import com.greenapex.repository.IAccountRepository;
import com.greenapex.repository.ICustomerRepository;
import com.greenapex.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
   @Autowired
   ICustomerRepository customerRepository;
   
   @Autowired
   IAccountRepository accountRepository;
 
  @Override
    public Account saveCustomer(Customer customer) {
	// TODO Auto-generated method stub
	Customer c= customerRepository.save(customer);
	
	Account a=new Account();
	    Random rand = new Random();
	    String card = "";
	    String number="";
	    for (int i = 0; i < 12; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        card += Integer.toString(n);
	    }
	    for (int i = 0; i < 12; i++)
	    {
	        if(i % 4 == 0)
	        number=number+" ";
	        number=number+card.charAt(i);
	    }
	
	System.out.println(number);
	a.setAccountNumber(number);
	
	/*Random random = new Random();
    char[] digits = new char[12];
    digits[0] = (char) (random.nextInt(9) + '1');
    for (int i = 1; i < 12; i++) {
        digits[i] = (char) (random.nextInt(10) + '0');
    }
    String s=new String(digits);
    System.out.println(s);*/
	a.setBalance(2000.00);
	a.setBranchCode("001446");
	a.setBranchName("Icici Bank");
	a.setIfscCode("ICIC0001446");
	a.setCustomer(c);
	accountRepository.save(a);
	
	return a;
  }

@Override
public Integer isEmailExist(String email) {
	// TODO Auto-generated method stub
	return customerRepository.countByEmail(email);
}

@Override
public Customer findCustomerByCustomerId(Integer Id) {
	// TODO Auto-generated method stub
	return customerRepository.findCustomerByCustomerId(Id);
}

@Override
public Customer saveCustomerDetail(Customer customer) {
	// TODO Auto-generated method stub
	return customerRepository.save(customer);
}

@Override
public Integer contByContactNumber(String contact) {
	// TODO Auto-generated method stub
	return customerRepository.countByContact(contact);
}


/*@Override
public Account getUserDetail(String userName) {
	// TODO Auto-generated method stub
	return customerRepository.getCustomer(userName);
}*/
	
}
