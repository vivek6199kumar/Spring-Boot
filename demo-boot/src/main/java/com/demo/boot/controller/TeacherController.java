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

import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.TeacherResponseDto;
import com.demo.boot.service.TeacherService;

@RestController
@RequestMapping("/v2/TeacherController")
public class TeacherController {

	@Autowired
	private TeacherService service;

	// Rest-API for Saving Teacher Detail
	@PostMapping("/saveTeacher")
	public String saveDetails(@RequestBody TeacherRequestDto dto) {
		this.service.saveTeacherDetails(dto);
		return "Teacher and student details saved" + dto;
	}

	// Rest-API for get all teacher details
	@GetMapping("/getAllTeachers")
	public List<TeacherResponseDto> getAllTeachers() {

		return this.service.getAllTeacher();
	}

	// 2-Method for another way to get all list of teacher
	@GetMapping("/getAllTeachers1")
	public ResponseEntity<List<TeacherResponseDto>> getAllTeacherRespo() {
		return new ResponseEntity<List<TeacherResponseDto>>(this.service.getAllTeacher(), HttpStatus.OK);
	}

	// 3--Get teacher by id
	@GetMapping("getTeachers/{id}")
	public TeacherResponseDto getTeachersById(@PathVariable int id) {

		return this.service.getTeachersById(id);
	}

	// 4--update the user by id
	@PutMapping("/updateTeacher/{id}")
	public String updateTeacher(@PathVariable int id, @RequestBody TeacherRequestDto dto) {
		this.service.updateTeacher(id, dto);
		return "Teacher of " + id + "updated";
	}

	// 5--Delete by teacher id
	@DeleteMapping("deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable int id) {

		return this.service.deleteTeacher(id);
	}

	@GetMapping("/getTeacherByStdId/{id}")
	public ResponseEntity<?> getTeacherByStdId(@PathVariable int id) {

		return new ResponseEntity<>(service.getTeacherByStdId(id), HttpStatus.CREATED);
	}

}
