package com.criteria.builder.service;

import java.util.List;

import com.criteria.builder.entity.StudentEntity;

public interface StudentService {
	
	//1 method to save student
	public void saveStudent(StudentEntity save);
	
	//2 Getting List of Student from databse
	public List<StudentEntity> getStudent();
	
	//3 Getting List of student by collection of id
	public List<StudentEntity> getCollectionStudent(List<Integer> list);

}
