package com.greenapex.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenapex.model.User;

public interface IUserRepo extends JpaRepository<User, Integer> {
	
	//SQL: select * from user where email=?
		Optional<User> findByUserMail(String userMail);
	

}
