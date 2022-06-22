package com.demo.boot.service;

import java.util.List;

import com.demo.boot.requestdto.SubjectRequestDto;

import com.demo.boot.responseDto.SubjectResponseDto;

public interface SubjectService {

	// 1- Method for saving Teachers
	public void saveSubjectDetails(SubjectRequestDto dto);

	// 2-Method for getting all teacher
	public List<SubjectResponseDto> getAllSubject();

	// 4- Update teacher by id
	public void updateSubject(int id, SubjectRequestDto dto);

	// 5- Delete teacher by id
	public String deleteSubject(int id);

	// 3 Get teacher by id
	public SubjectResponseDto getSubjectsById(int id);

	// 4 getTeacherByStdId
	public List<SubjectRequestDto> getSubjectByStudentId(int id);

	// 4 getTeacherByStdId
	public List<SubjectRequestDto> getSubjectByTeacherId(int id);

}
