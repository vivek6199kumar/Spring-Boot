package com.demo.boot.service;

import java.util.List;

import com.demo.boot.requestdto.BookRequestDto;
import com.demo.boot.requestdto.StudentRequestDto;
import com.demo.boot.responseDto.BookResponseDto;


public interface BookService {

	

	//1- Method for saving Book
	public void saveBookDetails(BookRequestDto dto);

	//2-Method for getting all Book
	public List<BookResponseDto> getAllBook();
	
	//4- Update Book by id
	public void updateBook(int id,BookRequestDto dto);
	
	//5- Delete Book by id
	public String deleteBook(int id);
	
	//3 Get Book by id
	public BookResponseDto getBooksById(int id);
	
	//4 getTeacherByStdId
	public List<BookRequestDto> getBooksBySubjectId(int id);
}
