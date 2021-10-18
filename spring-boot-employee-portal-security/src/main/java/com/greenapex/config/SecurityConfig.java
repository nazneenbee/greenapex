package com.greenapex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("naaz").password("{noop}naaz").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("ravi").password("{noop}ravi").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("udit").password("{noop}udit").authorities("GUEST");
		
		
	}
	public void configure(HttpSecurity http) throws Exception
	{
	 http.authorizeRequests().antMatchers("/hello").permitAll()
	 .antMatchers("/welcomeadmin").hasAuthority("ADMIN")
	.antMatchers("/welcomeemployee").hasAuthority("EMPLOYEE").anyRequest().authenticated()
	.and().formLogin().defaultSuccessUrl("/hello", true)
	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.and().exceptionHandling().accessDeniedPage("/denied");
		
		
	}
	
	

}
