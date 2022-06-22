package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.UserEntity;
import com.sample.repo.UserRepo;

@RestController
public class UserController {
    
	@Autowired
	private UserRepo repo;
	
	//saving user
	@PostMapping("/save")
	public String saveUser(@RequestBody UserEntity user)
	{
		this.repo.save(user);
		return "User Saved"+user;
		
	}
	
	@GetMapping("/get")
	private List<UserEntity> getUser()
	{
		return this.repo.findAll();
	}
}
