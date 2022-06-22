package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home()
	{
		System.out.println("This is our home page");
		return "home";
		
	}
}
