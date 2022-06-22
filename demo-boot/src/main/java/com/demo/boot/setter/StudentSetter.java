package com.demo.boot.setter;

import com.demo.boot.entity.Student;

import com.demo.boot.requestdto.StudentRequestDto;
import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.StudentResponseDto;

public class StudentSetter {

	// 1--Setter Method
	public static Student studentSetter(StudentRequestDto dto) {
		Student t1 = new Student();
		t1.setName(dto.getName());
		t1.setGender(dto.getGender());
		return t1;
	}

	// 2--Getter Method
	public static StudentResponseDto studentgetter(Student entity) {
		StudentResponseDto response = new StudentResponseDto();
		response.setName(entity.getName());
		return response;
	}

	// Get teacher by id
	public static StudentResponseDto getIdSetter(Student getEntity) {
		StudentResponseDto response = new StudentResponseDto();
		response.setName(getEntity.getName());
		return response;

	}

	// 4--Update Teacher by id
	public static Student studentUpdate(int id, StudentRequestDto dto) {
		Student update = new Student();
		update.setName(dto.getName());
		update.setSid(id);
		return update;

	}
	
	
	public static StudentRequestDto setStudentDto(Student entity) {
		StudentRequestDto obj=new StudentRequestDto();
		obj.setName(entity.getName());
		obj.setGender(entity.getGender());
		return obj;
	}

}
