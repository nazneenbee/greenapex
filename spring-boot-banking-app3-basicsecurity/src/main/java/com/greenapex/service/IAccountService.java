package com.greenapex.service;


import org.springframework.stereotype.Service;

import com.greenapex.entity.Account;

public interface IAccountService {
	public Account saveAccount(Account account);
}
