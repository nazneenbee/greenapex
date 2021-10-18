package com.contact.entity;

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
@Entity
@Table(name = "contact")
public class ContactEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
	
    @Column(name="email")
    private String email;
    
    @Column(name="contact")
    private String contactName;

   @Column(name="userId")
   private Long userId;
   
}