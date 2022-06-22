package com.demo.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.boot.entity.SubjectBook;



public interface SubjectBookDao extends JpaRepository<SubjectBook, Integer> {
	@Modifying
	@Query("delete from SubjectBook where bookId =:id")
	public void  deleteRowByBookId(int id);
	@Modifying
	@Query("delete from SubjectBook where subjectId =:id")
	public void deleteRowBySubjectId(int id);
	
	


}
