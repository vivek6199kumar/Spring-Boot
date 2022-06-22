package com.criteria.builder.service;

import java.util.List;

import com.criteria.builder.entity.Teacher;

public interface TeacherService {
	
	//1st-method for saving teacher details
	public void saveTeacher(Teacher save);
	
	//2nd Methods for getting teacher by condition
	public List<Teacher> getWithAge(int num1,int num2);

}
