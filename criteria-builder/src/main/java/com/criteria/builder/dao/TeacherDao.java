package com.criteria.builder.dao;

import java.util.List;

import com.criteria.builder.entity.Teacher;

public interface TeacherDao {

	// 1st Method to save Teacher
	public void saveTeacher(Teacher save);
	
	//2nd Method get List of Teacher where age<30 & age>20
	public List<Teacher> getList(int num1,int num2);

}
