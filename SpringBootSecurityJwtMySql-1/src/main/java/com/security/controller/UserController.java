package com.security.controller;

import java.security.Principal;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.model.UserRequest;
import com.security.model.UserResponse;
import com.security.service.UserService;
import com.security.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService; // HAS-A

	@Autowired
	private JwtUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	// Save user data in database
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {

		Integer id = userService.saveUser(user);
		String body = "User '" + id + "' saved";
		// return new ResponseEntity<String>(body,HttpStatus.OK);
		return ResponseEntity.ok(body);

	}

	// 2. validate user and generate token(login)
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request) {
		System.out.println(request.getUsername());
		// validate usernName/password with database
		this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		String token = util.generateToken(request.getUsername());

		return ResponseEntity.ok(new UserResponse(token, "Success! Genrated by Mr.Vivek Developer"));
	}

	// 3. After Login only
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal p) {
		return ResponseEntity.ok("Hello User!" + p.getName());
	}

}
