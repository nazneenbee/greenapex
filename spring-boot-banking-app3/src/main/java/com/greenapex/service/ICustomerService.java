package com.greenapex.service;



import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;


public interface ICustomerService {
	public Account saveCustomer(Customer customer);
	public boolean isEmailExist(String email);
}
