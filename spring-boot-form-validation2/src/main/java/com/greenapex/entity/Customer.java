package com.greenapex.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer customerId;
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;
	
	@Column(name="gender")
	String gender;
	
	@Column(name="email")
	String email;
	
	@Column(name="address")
	String address;
	
	@Column(name="contact")
	String contact;
	
	@Column(name="dob")
	Date dob;
	
    @Column(name="adharNumber")
	String aadharNumber;
    
    @Column(name="panNumber")
	String panNumber;
    
    @Column(name="accountType")
    String accountType;
	
}
