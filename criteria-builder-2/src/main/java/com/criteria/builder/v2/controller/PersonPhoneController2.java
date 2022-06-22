package com.criteria.builder.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.builder.v2.daoimpl.PersonPhoneDaoImpl;

@RestController
public class PersonPhoneController2 {

	@Autowired
	private PersonPhoneDaoImpl daoImpl;
	
	@GetMapping("/GettingJoinWithoutMapping")
	public String GettingJoinWithoutMapping()
	{
		this.daoImpl.joinWithOutMapping();
		return "Getting Join Without Mapping excuted";
	}
}
