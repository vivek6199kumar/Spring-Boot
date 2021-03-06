package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.helper.JwtUtil;
import com.jwt.model.JwtRequest;
import com.jwt.model.JwtResponse;
import com.jwt.service.CustomUserDetailService;

//For Generating Token for first time

@RestController
public class JwtController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(value = "/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwt) throws Exception {
		//System.out.println(jwt);
		try {
		      System.out.println("1 :" + jwt);
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwt.getUsername(), jwt.getPassword()));
			
		   } 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Bad Credntials");

		}
		
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwt.getUsername());
		
		System.out.println("User name"+userDetails);
		// calling jwtutil for token generate
		String token = this.jwtUtil.generateToken(userDetails);
		//System.out.println("JWT" + token);
		return ResponseEntity.ok(new JwtResponse(token));

	}
}
