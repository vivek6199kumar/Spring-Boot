package com.criteria.builder.dao;

import java.util.List;

import com.criteria.builder.entity.StudentEntity;

public interface StudentDao {
	
	//1-Method For saving student
	public void saveStudent(StudentEntity save);
	
	
	//2 Method for Getting List of Student
	public List<StudentEntity> getStudent();

	//3 Method Getting List of student by collection of id
	public List<StudentEntity> getCollectionStudent(List<Integer> list);
}
