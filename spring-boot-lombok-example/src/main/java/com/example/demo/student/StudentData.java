package com.example.demo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class StudentData {
	int rollNo;
	String name;
	/*
	 * public StudentData(int rollNo, String name) { super(); this.rollNo = rollNo;
	 * this.name = name; }
	 */
	
}
