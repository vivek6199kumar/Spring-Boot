package com.criteria.builder.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.criteria.builder.dao.StudentDao;
import com.criteria.builder.entity.StudentEntity;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	EntityManager em;
	
	//1-Method For saving student
	public void saveStudent(StudentEntity save)
	{
		Session session=em.unwrap(Session.class);
		session.save(save);
	}

	//2-Getting List of student
	@Override
	public List<StudentEntity> getStudent() {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Create Query Object
		CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);

		// call from method on CriteriaQuery object to set the query root
		Root<StudentEntity> std = cq.from(StudentEntity.class);

		// Create an instance of query interface & specify the type of method used to
		// access the database records;
		Query q = em.createQuery(cq);

		@SuppressWarnings("unchecked")
		List<StudentEntity> list = q.getResultList();
		return list;
	}

	//3-Getting List of Student with collection of id
	@Override
	public List<StudentEntity> getCollectionStudent(List<Integer> list) {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Create Query Object
		CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);

		// call from method on CriteriaQuery object to set the query root
		Root<StudentEntity> stud = cq.from(StudentEntity.class);
		cq.where(stud.in(list));
		TypedQuery<StudentEntity> q = em.createQuery(cq);

		List<StudentEntity> list1 = q.getResultList();

		return list1;
	}

}
