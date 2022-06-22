package com.demo.boot.setter;


import com.demo.boot.entity.Book;

import com.demo.boot.requestdto.BookRequestDto;
import com.demo.boot.responseDto. BookResponseDto;

public class BookSetter {

	

	// 1--Setter Method
	public static Book bookSetter(BookRequestDto dto) {
		 Book t1 = new  Book();
		t1.setName(dto.getName());
		t1.setAuthor(dto.getAuthor());
		return t1;
	}

	// 2--Getter Method
	public static  BookResponseDto bookgetter( Book entity) {
		 BookResponseDto response = new  BookResponseDto();
		response.setName(entity.getName());
		return response;
	}

	//3-- Get  Book by id
	public static  BookResponseDto getIdSetter( Book getEntity) {
		 BookResponseDto response = new  BookResponseDto();
		response.setName(getEntity.getName());
		return response;

	}

	// 4--Update  Book by id
	public static  Book bookUpdate(int id,BookRequestDto dto) {
		 Book update = new  Book();
		update.setName(dto.getName());
		update.setBid(id);
		return update;

	}
	
	public static BookRequestDto setDto(Book e) {

		BookRequestDto dto = new BookRequestDto();
		dto.setName(e.getName());
		dto.setAuthor(e.getAuthor());

		return dto;
	}
	
	
}