package com.greenapex.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
	@Id
	String accountNumber;
	
	
	@Column(name="ifscCode")
	String ifscCode;
	
	@Column(name="branchName")
	String branchName;
	
	@Column(name="branchCode")
	String branchCode;
	
	@ManyToOne
	@JoinColumn(name ="customerId")
	private Customer customer;
	

	
	
}
