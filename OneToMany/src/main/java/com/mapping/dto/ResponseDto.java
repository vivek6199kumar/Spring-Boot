package com.mapping.dto;


public class ResponseDto {

	private String name;
	private String productName;
	
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(String name, String productName) {
		super();
		this.name = name;
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ResponseDto [name=" + name + ", productName=" + productName + "]";
	}
	
	
	
}
