package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.CustomerDetails;
import com.security.model.User;
import com.security.service.CustomerDetailsService;
import com.security.service.UserService;

@RestController
@PreAuthorize("hasRole('admin')")
@RequestMapping("/user")
public class Controller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerDetailsService customerDetailsService;

	// Rest API for saving userLogin and password
	@PostMapping("/login")
	public String getUserPassword(@RequestBody User user) {
		System.out.println(user);
		this.userService.addUserLoginPassword(user);
		return "UserLogin and Password Saved In Database";
	}
	
	
	// Rest API for saving CustomerDetails
	@PostMapping("/addcust")
	public String addCustomer(@RequestBody CustomerDetails cust)
	{
		this.customerDetailsService.addCustomer(cust);
		return "Customer saved ho gaya bhai";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
