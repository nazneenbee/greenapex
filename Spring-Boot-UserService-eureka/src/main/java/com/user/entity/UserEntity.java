package com.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long userId;
	@Column(name="name")
	    private String name;
	@Column(name="phone")
	    private String phone;
	
	@Transient
	private List<ContactEntity> contacts;
}
//8655550148
