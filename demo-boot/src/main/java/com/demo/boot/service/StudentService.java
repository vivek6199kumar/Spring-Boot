package com.demo.boot.service;

import java.util.List;

import com.demo.boot.requestdto.StudentRequestDto;

import com.demo.boot.responseDto.StudentResponseDto;
import com.demo.boot.responseDto.TeacherResponseDto;


public interface StudentService {

	   
		//1- Method for saving Student
		public void saveStudentDetails(StudentRequestDto dto);

		//2-Method for getting all Student
		public List<StudentResponseDto> getAllStudent();
		
		//4- Update Student by id
		public void updateStudent(int id,StudentRequestDto dto);
		
		//5- Delete Student by id
		public String deleteStudent(int id);
		
		//3 Get Student by id
		public StudentResponseDto getStudentsById(int id);
		
		//4 getTeacherByStdId
		public List<StudentRequestDto> getStudentsByTeacherId(int id);
}
