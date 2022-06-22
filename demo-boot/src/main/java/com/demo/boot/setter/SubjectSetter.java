package com.demo.boot.setter;

import com.demo.boot.entity.Subject;
import com.demo.boot.requestdto.StudentRequestDto;
import com.demo.boot.requestdto.SubjectRequestDto;
import com.demo.boot.responseDto.StudentResponseDto;
import com.demo.boot.responseDto.SubjectResponseDto;

public class SubjectSetter {

	
	// 1--Setter Method
		public static Subject subjectSetter(SubjectRequestDto dto) {
			Subject t1 = new Subject();
			t1.setName(dto.getName());
			return t1;
		}

		// 2--Getter Method
		public static SubjectResponseDto subjectGetter(Subject entity) {
			SubjectResponseDto response = new SubjectResponseDto();
			response.setName(entity.getName());
			return  response;
		}

		// Get Subject by id
		public static SubjectResponseDto getIdSetter(Subject getEntity) {
			SubjectResponseDto response = new SubjectResponseDto();
			response.setName(getEntity.getName());
			return response;

		}

		// 4--Update Subject by id
		public static Subject subjectUpdate(int id, SubjectRequestDto dto) {
			Subject update = new Subject();
			update.setName(dto.getName());
			update.setSubjectID(id);
			return update;

		}
		
		public static SubjectRequestDto setDto(Subject e) {
			
			SubjectRequestDto dto =new SubjectRequestDto();
			dto.setName(e.getName());
			
			return dto;
		}
		
		
}