package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootUserService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserService1Application.class, args);
	}

}
