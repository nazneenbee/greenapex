package com.greenapex.service;



import java.text.ParseException;
import java.util.Optional;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;


public interface ICustomerService {
	public Account saveCustomer(Customer customer);
	public Integer isEmailExist(String email);
	public Integer contByContactNumber(String contact);
	//public Account getUserDetail(String userName);
	public Customer findCustomerByCustomerId(Integer Id);
	public Customer saveCustomerDetail(Customer customer);
	public void send(String sms) throws ParseException;

}
