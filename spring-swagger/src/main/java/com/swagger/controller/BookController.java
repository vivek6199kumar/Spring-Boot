package com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Book;
import com.swagger.service.BookServiceImpl;

@RestController
@RequestMapping("/v2/book")
public class BookController {
    @Autowired
	private BookServiceImpl bookServiceImpl;
    
    //Rest Api for saving Book
    @PostMapping("/save{id}")
    public String saveBook(@RequestBody Book book, @PathVariable int id)
    {
    	bookServiceImpl.saveBook(book);
    	
    	return "Book Detailed Saved with id "+id;
    }
    
    @GetMapping(value="/dempId{id}")
    public String demoId(@PathVariable int id)
    {
    	return "This is your" +id;
    }
    
    //Rest API for getting book by id
    @GetMapping(value="/searchBook/{bookId}")
    public Book getBook(@PathVariable int bookId)
    {
    	return  bookServiceImpl.getBook(bookId);
    	
    }
    
    //Rest API for deleting book by id
    @DeleteMapping(value="/deleteBook/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId)
    {
    	return bookServiceImpl.removeBook(bookId);
    	
    }
    
    
}
