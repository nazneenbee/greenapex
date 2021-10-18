package com.greenapex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
public class CustomerDummy {
	
	Integer customerId;
	
	
	String firstName;
	
	
	String lastName;
	
	
	String gender;
	
	
	String email;
	
	
	String contact;
	
	
	String dob;
	
  
	long aadharNumber;
    
    
	String panNumber;
    
    
    String accountType;
	
}
