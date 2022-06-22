package com.criteria.builder.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criteria.builder.dao.StudentRepository;
import com.criteria.builder.dto.StudentDto;
import com.criteria.builder.entity.StudentEntity;
import com.criteria.builder.service.StudentCourseService;
import com.criteria.builder.setter.StudentCourseSetter;

@Service
@Transactional
public class StudentCourseImpl implements StudentCourseService {
    @Autowired
	private StudentRepository repo;
	@Override
	public void saveStudentCourse(StudentDto dto) {
	
		 this.repo.save(StudentCourseSetter.setStudnent(dto));
	}

}
