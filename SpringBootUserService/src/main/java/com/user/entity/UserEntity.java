package com.user.entity;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
	 private Long userId;
	    private String name;
	    private String phone;

	    List<ContactEntity> contacts=new ArrayList<>();

	    public UserEntity(Long userId, String name, String phone, List<ContactEntity> contacts) {
	        this.userId = userId;
	        this.name = name;
	        this.phone = phone;
	        this.contacts = contacts;
	    }


	    public UserEntity(Long userId, String name, String phone) {
	        this.userId = userId;
	        this.name = name;
	        this.phone = phone;
	    }

	    public UserEntity() {
	    }

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public List<ContactEntity> getContacts() {
	        return contacts;
	    }

	    public void setContacts(List<ContactEntity> contacts) {
	        this.contacts = contacts;
	    }

}
