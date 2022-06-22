package com.criteria.builder.service;

import com.criteria.builder.dto.StudentDto;
import com.criteria.builder.entity.StudentEntity;

public interface StudentCourseService {
	
	//1st Method for saving Student with List of course
	public void saveStudentCourse(StudentDto dto);

}
