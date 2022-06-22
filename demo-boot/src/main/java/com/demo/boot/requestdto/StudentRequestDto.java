package com.demo.boot.requestdto;

public class StudentRequestDto {
	
	  
    private String name;

    private String gender;

	public StudentRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public StudentRequestDto(String name,String gender) {
		super();
		this.name = name;
		this.gender=gender;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "RequestDto [name=" + name + ", gender=" + gender + "]";
	}


}
