package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	    @GetMapping(value="/welcome")
		public String welcome()
		{
			String text="This is welcome page";
			
			return text;
		}
}
