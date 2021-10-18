package com.greenapex.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greenapex.entity.Account;

public interface IAccountService {
	public Account saveAccount(Account account);
	 
	public Account FindAccountByCustomerId(Integer customerId);
	
	
	//public Account findAccountDetailByUserName(String userName);
	
}
