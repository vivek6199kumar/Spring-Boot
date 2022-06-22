package com.demo.boot.setter;

import com.demo.boot.entity.Teacher;
import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.TeacherResponseDto;

public class TeacherSetter {

	// 1--Setter Method
	public static Teacher teacherSetter(TeacherRequestDto dto) {
		Teacher t1 = new Teacher();
		t1.setName(dto.getName());
		t1.setGender(dto.getGender());

		return t1;
	}

	// 2--Getter Method
	public static TeacherResponseDto teachergetter(Teacher entity) {
		TeacherResponseDto response = new TeacherResponseDto();
		response.setName(entity.getName());
		response.setGender(entity.getGender());
		return response;
	}

	// Get teacher by id
	public static TeacherResponseDto getIdSetter(Teacher getEntity) {
		TeacherResponseDto response = new TeacherResponseDto();
		response.setName(getEntity.getName());
		response.setGender(getEntity.getGender());
		return response;

	}

	// 4--Update Teacher by id
	public static Teacher teacherUpdate(int id, TeacherRequestDto dto) {
		Teacher update = new Teacher();
		update.setName(dto.getName());
		update.setGender(dto.getGender());
		update.setTid(id);
		return update;

	}

	public static TeacherResponseDto setDto(Teacher e) {

		TeacherResponseDto dto = new TeacherResponseDto();
		dto.setName(e.getName());
		dto.setGender(e.getGender());

		return dto;
	}

}
