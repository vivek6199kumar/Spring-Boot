package com.criteria.builder.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criteria.builder.dao.StudentDao;
import com.criteria.builder.dao.StudentRepository;
import com.criteria.builder.daoImpl.StudentDaoImpl;
import com.criteria.builder.entity.StudentEntity;
import com.criteria.builder.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;

	@Override
	public void saveStudent(StudentEntity save) {

		this.dao.saveStudent(save);

	}

	@Override
	public List<StudentEntity> getStudent() {

		return this.dao.getStudent();
	}

	@Override
	public List<StudentEntity> getCollectionStudent(List<Integer> list) {

		return this.dao.getCollectionStudent(list);
	}

}
