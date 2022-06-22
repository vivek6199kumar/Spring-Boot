package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('client')")
@RequestMapping(value="/client")
public class Client {
	
	@GetMapping(value="/bharat")
	public String client()
	{
		return "Mian hi client hu bhai";
	}

}
