package com.criteria.builder.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.criteria.builder.dao.TeacherDao;
import com.criteria.builder.entity.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	EntityManager em;

	@Override
	public void saveTeacher(Teacher save) {

		Session session = em.unwrap(Session.class);
		session.save(save);

	}
	//Using Pedicate
	@Override
	public List<Teacher> getList(int num1, int num2) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);

		Root<Teacher> root = cq.from(Teacher.class);

		// select*from teacher t where t.age>30 & t.age<15
		// Selecting path
		Path<Integer> p = root.get("age");
		
		Predicate cate1=cb.greaterThan(p, num1);
		Predicate cate2=cb.lessThan(p, num2);
		Predicate catefinal=cb.and(cate1,cate2);
		cq.select(root).where(catefinal);

		
		TypedQuery<Teacher> tq = em.createQuery(cq);
		List<Teacher> list = tq.getResultList();

		System.err.println(list);

		return list;
	}

	
	/*  @Override public List<Teacher> getList(int num1, int num2) { CriteriaBuilder
	  cb = em.getCriteriaBuilder();
	  
	  CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
	  
	  Root<Teacher> root = cq.from(Teacher.class);
	  
	  // select*from teacher t where t.age>30 & t.age<15 // Selecting path
	  Path<Integer> p = root.get("age");
	  
	  cq.select(root).where(cb.and(cb.greaterThan(p, num1), cb.lessThan(p, num2)));
	  TypedQuery<Teacher> tq = em.createQuery(cq); List<Teacher> list =
	  tq.getResultList();
	  
	  System.err.println(list);
	  
	  return list; 
	  
	  }*/
	 

}
