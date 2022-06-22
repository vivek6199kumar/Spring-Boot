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

import com.demo.boot.requestdto.SubjectRequestDto;
import com.demo.boot.responseDto.SubjectResponseDto;
import com.demo.boot.service.SubjectService;

@RestController
@RequestMapping("/v2/SubjectController")
public class SubjectController {

	@Autowired
	private SubjectService service;

	// Rest-API for Saving Subject Detail
	@PostMapping("/saveSubject")
	public String saveDetails(@RequestBody SubjectRequestDto dto) {
		this.service.saveSubjectDetails(dto);
		return "Student details saved" + dto;
	}

	// 2-- Rest-API for get all subject details
	@GetMapping("/getAllSubject")
	public List<SubjectResponseDto> getAllSubjects() {

		return this.service.getAllSubject();
	}

	// 3--Get subject by id
	@GetMapping("getSubject/{id}")
	public SubjectResponseDto getSubjectsById(@PathVariable int id) {

		return this.service.getSubjectsById(id);
	}

	// 4--update the user by id
	@PutMapping("/updateSubject/{id}")
	public String updateSubject(@PathVariable int id, @RequestBody SubjectRequestDto dto) {
		this.service.updateSubject(id, dto);
		return "Student of " + id + "updated";
	}

	// 5--Delete by subject id
	@DeleteMapping("deleteSubject/{id}")
	public String deleteStudent(@PathVariable int id) {

		return this.service.deleteSubject(id);
	}
	
	
	@GetMapping("/getsubjectByStudentId/{id}")
	public ResponseEntity<?> getSubjectByStudentId(@PathVariable int id){
		
		return new ResponseEntity<>(service.getSubjectByStudentId(id) ,HttpStatus.CREATED);
	}
	
	@GetMapping("/getsubjectByTeacherId/{id}")
	public ResponseEntity<?> getSubjectByTeacherId(@PathVariable int id){
	
		
		return new ResponseEntity<>(service.getSubjectByTeacherId(id) ,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	

}