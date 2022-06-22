package com.demo.boot.responseDto;


public class TeacherResponseDto {
	 private String name;

	   private String gender;

		public TeacherResponseDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		

		public TeacherResponseDto(String name, String gender) {
			super();
			this.name = name;
			this.gender = gender;
		}




		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public TeacherResponseDto(String name) {
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
