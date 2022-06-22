package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// Getting all book
	@GetMapping(value = "/book")
	public ResponseEntity<List<Book>> getBook() {

		List<Book>list=bookService.gelAll();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/book/{id}")
	public Book getBooks(@PathVariable("id") int id) {

		return bookService.getBookById(id);
	}

	// Rest-API for adding book data
	@PostMapping(value = "/addBook")
	public String addBook(@RequestBody Book b) {
		
		
		bookService.addBook(b);
		return "Book Added succesfully";
	}
	
	//Deleting books by id
	@DeleteMapping(value= "/del/{id}")
	public String delBook(@PathVariable("id") int id)
	{
		bookService.delete(id);
		return "Books of id " +id +  "is Deleted Successfully";
	}

	
	//update book handler
	@PutMapping(value="update/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable("id") int id)
	
	{
		bookService.updateBook(book,id);
		return "Your Book is Successfully Updated";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
