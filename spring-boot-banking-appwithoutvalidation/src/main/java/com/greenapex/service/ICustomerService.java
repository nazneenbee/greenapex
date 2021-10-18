package com.greenapex.service;



import java.util.Optional;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;


public interface ICustomerService {
	public Account saveCustomer(Customer customer);
	public boolean isEmailExist(String email);
	//public Account getUserDetail(String userName);
	public Customer findCustomerByCustomerId(Integer Id);
	public Customer saveCustomerDetail(Customer customer);

}
