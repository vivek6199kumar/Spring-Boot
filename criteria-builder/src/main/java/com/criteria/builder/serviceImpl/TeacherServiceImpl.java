package com.criteria.builder.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criteria.builder.dao.TeacherDao;
import com.criteria.builder.entity.Teacher;
import com.criteria.builder.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao dao;
	
	@Override
	public void saveTeacher(Teacher save) {
		this.dao.saveTeacher(save);
	
	}

	@Override
	public List<Teacher> getWithAge(int num1, int num2) {
		
		return this.dao.getList(num1, num2);
	}

}
