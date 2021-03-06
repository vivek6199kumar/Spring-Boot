package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception {
			
			  http 
			  .csrf().disable() 
			  .cors().disable() 
			  .authorizeRequests() 
			  .antMatchers("/home/**").permitAll()
			  .anyRequest()
			  .authenticated()
			  .and()
			  .httpBasic();			 
		  	
	  }
	 
		
		  @Override 
		  protected void configure(AuthenticationManagerBuilder auth) throws Exception 
		  {
			  auth.inMemoryAuthentication().withUser("vivek").password("host").roles("admin");
			  auth.inMemoryAuthentication().withUser("bharat").password("open").roles("client");
		  
		  }
		  @Bean
		  public PasswordEncoder encoder()
		  {
			  return NoOpPasswordEncoder.getInstance();
			  
		  }
		 
	

}
