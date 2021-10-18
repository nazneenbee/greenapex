package com.greenapex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class StudentEntity {
	
	int rollNo;
	
	String name;
	
	String email;
	
	String course;
	
	String branch;
	
	String contact;
	
}
