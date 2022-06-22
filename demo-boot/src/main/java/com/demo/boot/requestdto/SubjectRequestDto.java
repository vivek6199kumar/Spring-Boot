package com.demo.boot.requestdto;

public class SubjectRequestDto {
	
	  
    private String name;



	public SubjectRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public SubjectRequestDto(String name) {
		super();
		this.name = name;
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "SubjectRequestDto [name=" + name + "]";
	}
	
	







}
