package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserServiceApplication.class, args);
	}
	
	
	@Bean
	public LocalValidatorFactoryBean validator() {
	    return new LocalValidatorFactoryBean();
	}


}
