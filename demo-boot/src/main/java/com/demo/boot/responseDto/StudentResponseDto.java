package com.demo.boot.responseDto;

public class StudentResponseDto {
	 private String name;

	   private String gender;

		public StudentResponseDto() {
		
		}

		

		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public StudentResponseDto(String name) {
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
			return "RequestDto [name=" + name + "]";
		}
		
		
}
