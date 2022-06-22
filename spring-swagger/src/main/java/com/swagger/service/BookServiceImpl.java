package com.swagger.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.dao.BookRepository;
import com.swagger.model.Book;

@Service
@Transactional
public class BookServiceImpl {

	@Autowired
	private BookRepository repo;

	// 1st Method For Saving Book
	public String saveBook(Book book) {
		this.repo.save(book);
		return "Ye hai Book ki ID bhai" + book.getBookId();
	}

	// 2nd Method For Getting Book By Id
	
	public Book getBook(int bookId) {
		//return this.repo.findById(bookId).get();
		return repo.getById(bookId);

	}

	// 3rd Method For Deleting Book By Id
	public List<Book> removeBook(int bookId) {
		repo.deleteById(bookId);
		return repo.findAll();
	}
}
