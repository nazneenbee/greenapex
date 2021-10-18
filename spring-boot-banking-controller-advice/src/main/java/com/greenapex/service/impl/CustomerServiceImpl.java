package com.greenapex.service.impl;


import java.text.ParseException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;
import com.greenapex.entity.StoreOtp;
import com.greenapex.repository.IAccountRepository;
import com.greenapex.repository.ICustomerRepository;
import com.greenapex.service.ICustomerService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
   @Autowired
   ICustomerRepository customerRepository;
   
   @Autowired
   IAccountRepository accountRepository;
   
   private final String ACCOUNT_SID ="AC1790197ca89bd0705ffee81e5c4ae228";

   private final String AUTH_TOKEN = "aa21c03dcd562c7f0050bef03d0a577d";

   private final String FROM_NUMBER = "+17272631594";

   public void send(String sms) throws ParseException {
   	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
     
   	
       int min = 100000;  
        int max = 999999; 
       int number=(int)(Math.random()*(max-min+1)+min);
     
       
       String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Er Prince kumar Technoidentity.com";
      
       
       Message message = Message.creator(new PhoneNumber(sms), new PhoneNumber(FROM_NUMBER), msg)
               .create();
      
       StoreOtp.setOtp(number);
   }
   public void receive(MultiValueMap<String, String> smscallback) {
   	   
   }
   
 
  @Override
    public Account saveCustomer(Customer customer) {
	
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
	String num=number.trim();
	System.out.println(num);
	a.setAccountNumber(num);
	
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
	return customerRepository.countByEmail(email);
}

@Override
public Customer findCustomerByCustomerId(Integer Id) {
	return customerRepository.findCustomerByCustomerId(Id);
}

@Override
public Customer saveCustomerDetail(Customer customer) {
	return customerRepository.save(customer);
}

@Override
public Integer contByContactNumber(String contact) {
	return customerRepository.countByContact(contact);
}


/*@Override
public Account getUserDetail(String userName) {
	// TODO Auto-generated method stub
	return customerRepository.getCustomer(userName);
}*/
	
}
