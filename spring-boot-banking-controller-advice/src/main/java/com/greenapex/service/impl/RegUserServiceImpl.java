package com.greenapex.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greenapex.entity.Registration;
import com.greenapex.repository.ICustomerRepository;
import com.greenapex.repository.IRegUserRepository;
import com.greenapex.service.IRegUserService;

@Service
public class RegUserServiceImpl implements IRegUserService, UserDetailsService{
    
	@Autowired
	IRegUserRepository regUserRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public ICustomerRepository customerRepository;
	
	@Override
	public Registration findUserByUserName(String userName) {
		return regUserRepository.findByUserName(userName).get();
	}



	@Override
	public Registration saveRegisterUser(Registration regUser) {
		String pwd=regUser.getPassword();
		
		String encPwd=passwordEncoder.encode(pwd);
		regUser.setPassword(encPwd);
		return regUserRepository.save(regUser);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<Registration> opt = regUserRepository.findByUserName(username);
		       
						if(opt.isEmpty()) {
							throw new UsernameNotFoundException("User not exist");
						}else {
							Registration user = opt.get();
							List<GrantedAuthority> auths = new ArrayList<>();
							for(String role:user.getRole()) {
								auths.add(new SimpleGrantedAuthority(role));
							}
							return new org.springframework.security.core.userdetails.
									User(username, user.getPassword(),auths);

						}
		
	}


}
