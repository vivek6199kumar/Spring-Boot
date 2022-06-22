package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/home")
public class HomeController {

	@GetMapping(value="/car")
	public String student()
	{
		return "100 Car";
		
	}
}
