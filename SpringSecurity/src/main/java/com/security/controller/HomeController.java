package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('admin')")
@RequestMapping("/form")
public class HomeController {

	@GetMapping("/home")
	public String home()
	{
		return "This is home page";
	}
	@GetMapping("/login")
	public String login()
	{
		return "This is login page";
	}
	@GetMapping("/register")
	public String register()
	{
		return "This is registration page";
	}
}
