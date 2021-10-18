package com.greenapex.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "userreg")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regid;
	
	@ManyToOne
	@JoinColumn(name ="customerId")
	private Customer customer;
	
    private  String userName;
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
			name="roles",
			joinColumns = @JoinColumn(name="customerId", nullable = false, unique = true)
			)
    private Set<String> role;


}
