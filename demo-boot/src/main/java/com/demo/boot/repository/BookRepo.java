package com.demo.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.boot.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {


	@Query("select b from Book b where id in (select x.bookId from SubjectBook x where subjectId=:id)")
	public List<Book> getBookBySubjectId(int id);

}
