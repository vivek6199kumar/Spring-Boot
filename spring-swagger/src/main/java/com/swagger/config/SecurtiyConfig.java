package com.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.swagger.service.UserDetailService;


@Configuration
@EnableWebSecurity
public class SecurtiyConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailService detailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		 .csrf().disable()
		 .authorizeRequests()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin()
		 .and()
		 .headers()
		 .frameOptions().disable();
		
		
		
	}
	
	// Creating userName and password configure

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.inMemoryAuthentication().withUser("vivek").password(passwordEn().encode("host")).roles("admin");
			//auth.userDetailsService(detailService).passwordEncoder(passwordEn());
		}

		// To encode password

		@Bean
		public BCryptPasswordEncoder passwordEn() {
			return new BCryptPasswordEncoder(10);
		}

}
