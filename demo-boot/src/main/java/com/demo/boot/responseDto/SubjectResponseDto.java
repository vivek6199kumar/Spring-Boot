package com.demo.boot.responseDto;

public class SubjectResponseDto {
	
	private String name;

	  

		public SubjectResponseDto() {
		
		}

		public SubjectResponseDto(String name) {
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
