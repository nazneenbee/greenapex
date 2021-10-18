package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data

public class ContactEntity {
	
    private Long cId;
	
   
    private String email;
    
 
    private String contactName;
    
 
    private UserEntity user;

   
}