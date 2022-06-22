package com.demo.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.requestdto.BookRequestDto;
import com.demo.boot.responseDto.BookResponseDto;
import com.demo.boot.service.BookService;


@RestController
@RequestMapping("/v2/BookController")
public class BookController {

	@Autowired
	private BookService service;

	// Rest-API for Saving book Detail
	@PostMapping("/saveBook")
	public String saveDetails(@RequestBody BookRequestDto dto) {
		this.service.saveBookDetails(dto);
		return "Student details saved" + dto;
	}

	// Rest-API for get all  book details
	@GetMapping("/getAllBook")
	public List<BookResponseDto> getAllBooks() {

		return this.service.getAllBook();
	}

	

	// 3--Get teacher by id
	@GetMapping("getBook/{id}")
	public BookResponseDto getStudentsById(@PathVariable int id) {

		return this.service.getBooksById(id);
	}

	// 4--update the user by id
	@PutMapping("/updateBook/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody BookRequestDto dto) {
		this.service.updateBook(id, dto);
		return "Student of " + id + "updated";
	}

	// 5--Delete by Book id
	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {

		return this.service.deleteBook(id);
	}

	@GetMapping("/getBookBySubjectId/{id}")
	public ResponseEntity<?> getBookBySubjectId(@PathVariable int id){
			
		
		return new ResponseEntity<>(service.getBooksBySubjectId(id), HttpStatus.ACCEPTED);
		
	}
	
	
	
}