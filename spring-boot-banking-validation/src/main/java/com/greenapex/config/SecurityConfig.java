package com.greenapex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	 
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		//auth.inMemoryAuthentication().withUser("naaz").password("{noop}naaz").authorities("USERS");
		//auth.inMemoryAuthentication().withUser("ravi").password("{noop}ravi").authorities("EMPLOYEE");
		//auth.inMemoryAuthentication().withUser("udit").password("{noop}udit").authorities("GUEST");
		
		auth.userDetailsService(userDetailService).passwordEncoder(passEncoder);
		
		
	}
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().
		antMatchers("/api/home","/api/savecustomer","/api/newuser","/api/userreg","/api/savereguser","/images/**"). permitAll()
		.antMatchers("/api/userdetail","/api/loginsuccess","/api/checkbalace","/api/userprofile","/api/userupdate","/api/saveupdateddata",
				"/api/deposit","/api/depositamount","/api/withdraw","/api/withdrawamount","/api/transfermoney","/api/amounttranfersuccess").hasAuthority("USERS")
		.anyRequest().authenticated()
    	.and()
		.formLogin()
		.defaultSuccessUrl("/api/loginsuccess", true)
		.failureUrl("/login?error")// def:

		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout") // def: /login?logout
		.and().exceptionHandling().accessDeniedPage("/denied");
		//http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
		
		// http.authorizeRequests().antMatchers("/images/**").permitAll();
		
		
	}

}
