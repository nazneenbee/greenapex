package com.user.service.imple;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.service.UserService;

@Service
public class userServiceImple implements UserService{

	 List<UserEntity> list = List.of(
	            new UserEntity(1311L, "Durgesh Tiwari", "23525625"),
	            new UserEntity(1312L, "Ankit Tiwari", "99999"),
	            new UserEntity(1314L, "Ravi Tiwari", "888")
	    );

	    @Override
	    public UserEntity getUser(Long id) {
	        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	    }

}
