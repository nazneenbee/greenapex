package com.greenapex.service;



import java.util.Optional;

import com.greenapex.entity.Customer;


public interface ICustomerService {
	public Customer saveCustomer(Customer customer);
	public Integer isEmailExist(String email); 
    /*public Integer
	 /* contByContactNumber(String contact); //public Account getUserDetail(String
	 * userName); public Customer findCustomerByCustomerId(Integer Id); public
	 * Customer saveCustomerDetail(Customer customer);
	 */

}
