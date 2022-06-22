package com.demo.boot.service;

import java.util.List;

import com.demo.boot.requestdto.TeacherRequestDto;
import com.demo.boot.responseDto.TeacherResponseDto;

public interface TeacherService {
    
	//1- Method for saving Teachers
	public void saveTeacherDetails(TeacherRequestDto dto);

	//2-Method for getting all teacher
	public List<TeacherResponseDto> getAllTeacher();
	
	//4- Update teacher by id
	public void updateTeacher(int id,TeacherRequestDto dto);
	
	//5- Delete teacher by id
	public String deleteTeacher(int id);
	
	//3 Get teacher by id
	public TeacherResponseDto getTeachersById(int id);
	
	//4 getTeacherByStdId
	public List<TeacherResponseDto> getTeacherByStdId(int id);
}
