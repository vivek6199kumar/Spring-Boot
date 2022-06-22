package com.criteria.builder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.builder.entity.StudentEntity;
import com.criteria.builder.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	// 1st-Rest-API for saving Student Details
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody StudentEntity user) {
		this.service.saveStudent(user);
		return "Student save ho gaya bhai";
	}

	// 2nd-Rest-API Getting List for Student
	@GetMapping("/getStudent")
	public ResponseEntity<?> getStudent()

	{

		return new ResponseEntity<>(this.service.getStudent(), HttpStatus.OK);
	}

	// 3rd-Rest-API Getting List of Student by collections of id
	@GetMapping("/getCollectionStudent")
	public List<StudentEntity> getStudentCollection(@RequestBody List<Integer> list) {
		System.err.println(list);
		return service.getCollectionStudent(list);
	}

}
