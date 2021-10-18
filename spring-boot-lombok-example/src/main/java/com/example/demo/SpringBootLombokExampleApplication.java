package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.student.StudentData;

@SpringBootApplication
public class SpringBootLombokExampleApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootLombokExampleApplication.class, args);
		final StudentData s=new StudentData(1,"naaz");
		System.out.println(s);
	}

}
