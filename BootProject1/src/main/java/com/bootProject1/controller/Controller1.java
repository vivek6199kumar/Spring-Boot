package com.bootProject1.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootProject1.entity.User;
import com.bootProject1.serviceimp.ServiceImpl;

@RestController
public class Controller1 {
	@Autowired
	private ServiceImpl serviceImp;
	
	//Getting by id
	@GetMapping("/list/{id}")
	public User getUser(@PathVariable  int id)
	{
		return serviceImp.getUser(id);
		
	}
	@GetMapping("/show")
	public List<User> getAllList()
	{
		return serviceImp.getAllList();
	}
	
	@PostMapping(value="/addUser")
	public String addUser(@RequestBody User user)
	{
		 serviceImp.addUser(user);
		 return "User Succesfully Added";
	}
	
	
}
