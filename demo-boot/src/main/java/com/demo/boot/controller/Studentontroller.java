package com.demo.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.requestdto.StudentRequestDto;

import com.demo.boot.responseDto.StudentResponseDto;

import com.demo.boot.service.StudentService;

@RestController
@RequestMapping("/v2/StudentController")
public class Studentontroller {

	
	@Autowired
	private StudentService service;

	// Rest-API for Saving Teacher Detail
	@PostMapping("/saveStudent")
	public String saveDetails(@RequestBody StudentRequestDto dto) {
		this.service.saveStudentDetails(dto);
		return "Student details saved" + dto;
	}

	// 2--Rest-API for get all teacher details
	@GetMapping("/getAllStudent")
	public List<StudentResponseDto> getAllStudents() {
		
		return this.service.getAllStudent();
	}
	
	
	
	//3--Get teacher by id
	@GetMapping("getStudent/{id}")
	public StudentResponseDto getStudentsById(@PathVariable int id)
	{
		
		return this.service.getStudentsById(id);
	}
	
	
	
	// 4--update the user by id
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id,@RequestBody StudentRequestDto dto)
	{
		this.service.updateStudent(id, dto);
		return "Student of " +id +  "updated" ;
	}
	
	
	
	
	//5--Delete by teacher id
	@DeleteMapping("deleteStudent/{id}")
	public String deleteStudent(@PathVariable int  id)
	{
		
		return this.service.deleteStudent(id);
	}
	
	
	@GetMapping("/getStdByTeacher/{id}")
	public ResponseEntity<?> getStdByTeacher(@PathVariable int id) {

		return new ResponseEntity<>(service.getStudentsByTeacherId(id), HttpStatus.CREATED);

	}
	
	

}