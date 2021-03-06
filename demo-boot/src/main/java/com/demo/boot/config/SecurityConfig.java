package com.demo.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.boot.filter.SecurityFilter;



@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private InvalidUserAuthEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter filter;
	
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception 
	{
		
		return super.authenticationManager();
	}
	// override the Method for authentication
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				//auth.inMemoryAuthentication().withUser("Jatin").password(passwordEncoder.encode("Sir")).roles("ADMIN");
				
				auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

			}
	
	private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };
	
	
		// override method for authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception 
		{
			
			http
			   .csrf().disable()
			   .authorizeRequests()
			   .antMatchers(AUTH_WHITELIST).permitAll()
			   .antMatchers("/v2/user/save","/v2/user/login").permitAll()
			   .anyRequest().authenticated()
			   .and()
			   .exceptionHandling()
			   .authenticationEntryPoint(authenticationEntryPoint)
			   .and()
			   .sessionManagement()
			   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			   .and()
			   
			   //Register filter for 2nd request onwards
			   .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
			   //TODO : verify user for 2nd request onwards..
			   ;
			   
		}
		
		
		
		
	

}
