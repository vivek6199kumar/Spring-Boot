package com.demo.boot.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.boot.entity.Book;

import com.demo.boot.repository.BookRepo;
import com.demo.boot.repository.SubjectBookDao;
import com.demo.boot.requestdto.BookRequestDto;

import com.demo.boot.responseDto.BookResponseDto;

import com.demo.boot.service.BookService;
import com.demo.boot.setter.BookSetter;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private SubjectBookDao subjectBookDao;
	@Autowired
	private BookRepo repo;

	// 1--Method for saving  Book details
	@Override
	public void saveBookDetails(BookRequestDto dto) {

		this.repo.save(BookSetter.bookSetter(dto));

	}

	// 2-- Method for getAll List of Book
	@Override
	public List<BookResponseDto> getAllBook() {
		List<Book> list = this.repo.findAll();
		List<BookResponseDto> l1 = new ArrayList<BookResponseDto>();
		list.forEach((e) -> {
			l1.add(BookSetter.bookgetter(e));
		});

		return l1;
	}
 
	//3-- Getting book by id
	@Override
	public BookResponseDto getBooksById(int id) {
		Book t = this.repo.getById(id);

		return BookSetter.getIdSetter(t);
	}

	// 4- Method for update Book by id
	@Override
	public void updateBook(int id, BookRequestDto dto) {
		try {
			Book tid = this.repo.getById(id);
			if (tid == null) {
				System.out.println("User not found");
			} else {
				this.repo.save(BookSetter.bookUpdate(id, dto));
				System.out.println("User Updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User not found");

		}
	}

	// 5--Delete  Book by id
	@Override
	public String deleteBook(int id) {
		
		subjectBookDao.deleteRowByBookId(id);
		repo.deleteById(id);
		return "Book deleted";
	
		
		}
	
	
	
public List<BookRequestDto> getBooksBySubjectId(int id) {
		
		List<Book> list=repo.getBookBySubjectId(id);

		List<BookRequestDto> l1=new ArrayList<>();
		
		list.forEach((e)->{
			l1.add(BookSetter.setDto(e));
		});
		
		return l1;
	}

	

}