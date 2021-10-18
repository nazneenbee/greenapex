package com.greenapex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("naaz").password("{noop}naaz").authorities("USERS");
		//auth.inMemoryAuthentication().withUser("ravi").password("{noop}ravi").authorities("EMPLOYEE");
		//auth.inMemoryAuthentication().withUser("udit").password("{noop}udit").authorities("GUEST");
		
	}
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().
		antMatchers("/api/home"). permitAll()
		.antMatchers("/api/savecustomer","/api/newuser").hasAuthority("USERS")
		.anyRequest().authenticated()




		.and()
		.formLogin()
		.defaultSuccessUrl("/api/newuser", true)
		.failureUrl("/login?error")// def:

		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout") // def: /login?logout
		.and().exceptionHandling().accessDeniedPage("/denied");
		//http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
		
		
	}

}
