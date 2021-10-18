package com.greenapex.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.entity.Customer;
import com.greenapex.repository.ICustomerRepository;
import com.greenapex.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
   @Autowired
   ICustomerRepository customerRepository;
   
  
 
  @Override
    public Customer saveCustomer(Customer customer) {
	// TODO Auto-generated method stub
	return customerRepository.save(customer);
  }



@Override
public Integer isEmailExist(String email) {
	// TODO Auto-generated method stub
	return customerRepository.countByEmail(email);
}


/*@Override
public Account getUserDetail(String userName) {
	// TODO Auto-generated method stub
	return customerRepository.getCustomer(userName);
}*/
  
 
	
}
