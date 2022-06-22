package com.mapping.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mapping.dto.ResponseDto;
import com.mapping.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	
	@Query("select new com.mapping.dto.ResponseDto(c.name , p.productName) from Customer c join c.products p")
	public List<ResponseDto> getJoinInformation();

}
