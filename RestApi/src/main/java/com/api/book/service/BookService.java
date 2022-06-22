package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.book.entity.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		/*
		 * list.add(new Book(1, "Java Complete Book", "Mr.Vivek")); list.add(new Book(2,
		 * "Java Complete Book", "Mr.Bharat"));
		 */

	}

	// get all book
	public List<Book> gelAll() {
		return list;
	}

	// get book by id
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

	// Adding the book
	public void addBook(Book b) {
		list.add(b);
	}

	/*
	 * // Delete book by id public void delete(int id) { for (Book d : list) { if
	 * (d.getId() == id) { list.remove(id); } } }
	 */

	// Deleting book by id
	public void delete(int id) {
		list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());

	}

	// Update
	public void updateBook(Book book, int id) {
		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());

			}
			return b;
		}).collect(Collectors.toList());

	}

}
