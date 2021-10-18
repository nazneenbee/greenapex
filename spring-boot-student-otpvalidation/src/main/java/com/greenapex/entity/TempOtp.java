package com.greenapex.entity;

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
@Table(name = "student")
public class TempOtp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int rollNo;
	@Column(name="name")
	String name;
	@Column(name="email")
	String email;
	@Column(name="course")
	String course;
	@Column(name="branch")
	String branch;
	@Column(name="contact")
	String contact;

   @Transient
    private int otp;
}
