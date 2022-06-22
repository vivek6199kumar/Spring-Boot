package com.criteria.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.builder.entity.Teacher;
import com.criteria.builder.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService service;

	// 1st-Rest-API for saving Student Details
	@PostMapping("/saveTeacher")
	public String saveStudent(@RequestBody Teacher user) {
		this.service.saveTeacher(user);
		return "Teacher save ho gaya bhai";
	}
	
	//2nd Method getting teacher list whose age in between certain number 23 & 32
	@GetMapping("/getTeacherWhoseAge/{num1},{num2}")
	public ResponseEntity<?> getTeacherBYAge(@PathVariable int num1,@PathVariable int num2)
	{
		System.out.println(num1+"---------"+num2);
		return new ResponseEntity<>(this.service.getWithAge(num1, num2),HttpStatus.ACCEPTED);
	}
}
