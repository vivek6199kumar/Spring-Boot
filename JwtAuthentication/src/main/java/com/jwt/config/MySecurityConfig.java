package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.csrf().disable()
				.cors().disable()
				.authorizeRequests()
				.antMatchers("/token").permitAll()
				.anyRequest()
				.authenticated()
				//.and()
				//.sessionManagement()
				//.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//auth.inMemoryAuthentication().withUser("vivek").password("host").roles("NORMAL");
		System.out.println("2 : " + auth );
	 	auth.userDetailsService(customService);

	}

	// Password Encoder
	@Bean
	public PasswordEncoder passwornEn() {
		return NoOpPasswordEncoder.getInstance();
		// return new BCryptPasswordEncoder(10);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}