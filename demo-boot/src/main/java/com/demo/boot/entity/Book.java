package com.demo.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "bid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;

	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;



	public Book() {
		super();

	}

	public Book(int tid, String name) {
		super();
		this.bid = tid;
		this.name = name;
	
	}

	

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + "]";
	}

	



	
	
	

}
