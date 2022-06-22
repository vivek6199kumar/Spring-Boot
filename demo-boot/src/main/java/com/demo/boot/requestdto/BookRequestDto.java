package com.demo.boot.requestdto;

public class BookRequestDto {


	private String name;
	private String author;

	public BookRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookRequestDto( String name, String author) {
		super();
	
		this.name = name;
		this.author = author;
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
		return "BookRequestDto [name=" + name + ", author=" + author + "]";
	}

	

}
