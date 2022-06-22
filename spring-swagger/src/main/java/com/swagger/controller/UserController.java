package com.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.User;
import com.swagger.service.UserSevcie;

@RestController
@RequestMapping("/v2/user")
public class UserController {
	
    @Autowired
	private UserSevcie sevcie;
    
	// Rest API for Saving User
    @PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
        Integer id=this.sevcie.userSave(user);		
		String body="User Saved and its Id " +id;
		return ResponseEntity.ok(body);
	}
}
