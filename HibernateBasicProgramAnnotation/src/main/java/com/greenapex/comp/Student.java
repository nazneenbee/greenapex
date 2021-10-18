package com.greenapex.comp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="rno")
	int rno;
	@Column(name="student_name")
	String studentName;
	@Column(name="fee")
	float fee;
	public Student(int rno, String studentName, float fee) {
		this.rno = rno;
		this.studentName = studentName;
		this.fee = fee;
	}
	public Student() {
		
	}
	
	
	

}
