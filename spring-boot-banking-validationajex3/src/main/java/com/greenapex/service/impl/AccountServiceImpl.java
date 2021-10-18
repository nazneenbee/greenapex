package com.greenapex.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.entity.Account;
import com.greenapex.repository.IAccountRepository;
import com.greenapex.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;
	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@Override
	public Account FindAccountByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return accountRepository.findAccountByCustomerId(customerId);
	}
	/*@Override
	public Account findAccountDetailByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountRepository.findAccountByUserName(userName);
	}*/
	@Override
	public Account FindAccountByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findAccountByAcccountNumber(accountNumber);
	}
	

}
