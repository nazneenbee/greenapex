package com.greenapex.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greenapex.model.User;
import com.greenapex.repo.IUserRepo;
import com.greenapex.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUser(User user) {
		String pwd = user.getUserPwd();

		// encode it
		String encPwd = encoder.encode(pwd);
		// set back to same object
		user.setUserPwd(encPwd);
		user = repo.save(user);
		return user.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetch user object based on emailId(username)
		Optional<User> opt = repo.findByUserMail(username);

		// if user not exist
		if (!opt.isPresent()) {
			throw new UsernameNotFoundException("Username not exist!");
		} else {
			// read model class user
			User user = opt.get();

			return new org.springframework.security.core.userdetails.User(username, user.getUserPwd(), user
					.getUserRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		}
	}

}
