package com.user.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class userServiceImple implements UserService{
	@Autowired
	UserRepository user;

	    @Override
	    public Optional<UserEntity> getUser(Long id) {
	        return user.findById(id);
	    }

		@Override
		public UserEntity saveUser(UserEntity user1) {
			// TODO Auto-generated method stub
			return user.save(user1);
		}

}
