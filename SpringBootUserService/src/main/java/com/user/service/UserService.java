package com.user.service;

import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;

@Service
public interface UserService {
	public UserEntity getUser(Long id);

}
