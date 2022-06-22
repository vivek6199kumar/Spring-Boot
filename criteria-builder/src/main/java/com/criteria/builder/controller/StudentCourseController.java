package com.criteria.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.builder.dao.StudentRepository;
import com.criteria.builder.dto.StudentDto;
import com.criteria.builder.service.StudentCourseService;
import com.criteria.builder.setter.StudentCourseSetter;

@RestController
public class StudentCourseController {

	@Autowired
	private StudentCourseService service;

	// 1st Method to save Student and List of course
	@PostMapping("/saveStudentCourse")
	public ResponseEntity<?> saveStudentCourse(@RequestBody StudentDto dto) {
		this.service.saveStudentCourse(dto);
		return new ResponseEntity<>(dto ,HttpStatus.ACCEPTED);
	}
}
