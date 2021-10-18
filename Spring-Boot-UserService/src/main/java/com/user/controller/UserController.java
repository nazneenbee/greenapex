package com.user.controller;
import com.user.entity.UserEntity;
import com.user.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private UserService userService;

	     @Autowired
	   private RestTemplate restTemplate;

	    @GetMapping("/{userId}")
	    public Optional<UserEntity> getUser(@PathVariable("userId") Long userId) {

	        Optional<UserEntity> user = userService.getUser(userId);
	        //http://localhost:9002/contact/user/1311

	        List contacts = this.restTemplate.getForObject("http://localhost:9091/contact/user/" + user.get().getUserId() , List.class);
	        user.get().setContacts(contacts);
	        return user;

	    }
	    @PostMapping("savedata")
	    public UserEntity saveUser(@RequestBody UserEntity user) {
			return userService.saveUser(user);
           
	       

	    }
}
