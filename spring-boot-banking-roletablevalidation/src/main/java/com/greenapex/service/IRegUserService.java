package com.greenapex.service;

import java.util.Optional;

import com.greenapex.entity.Registration;

public interface IRegUserService {
	public Registration saveRegisterUser(Registration regUser);
	
	public Registration findUserByUserName(String userName);

}
