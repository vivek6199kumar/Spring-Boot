package com.demo.rc.controller;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.EmpEntity;

@RestController
@CrossOrigin
//@RequestMapping("home")
public class Controller {

	@RequestMapping("hi")
	public ResponseEntity<?> demoTest()
	{
		EmpEntity emp=new EmpEntity(1,"Vivek Kumar",new Date(),HttpStatus.ACCEPTED);
		return   ResponseEntity.ok(emp);
	}
	
	@RequestMapping("/how")
	public String demo()
	{
		return "Hello";
	}
}
