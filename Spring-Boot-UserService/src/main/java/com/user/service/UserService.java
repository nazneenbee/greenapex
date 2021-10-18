package com.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;

@Service
public interface UserService {
	public Optional<UserEntity> getUser(Long id);
	public UserEntity saveUser(UserEntity user);

}
