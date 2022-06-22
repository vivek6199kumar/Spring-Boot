package com.criteria.builder.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.builder.v2.daoimpl.CombinedDaoIMpl;

@RestController
public class Controller1 {

	@Autowired
	private CombinedDaoIMpl daoIMpl;
	
	//1st Rest-API for getting List
	@GetMapping("/get")
	public void SubqueryMetaModel()
	{
		this.daoIMpl.SubqueryMetaModel();
	}
	
	//2nd Rest-API for getting Result by subQuery
	@GetMapping("/getQueryResult/{name}")
	public String subquery(@PathVariable String name)
	{
		this.daoIMpl.subquery1(name);
		return "Controller Is Running";
	}
	
	//3rd Rest-API for getting Result by subQuery
		@GetMapping("/getQueryResult1/{name}")
		public String subquery2(@PathVariable String name)
		{
			this.daoIMpl.subquery2(name);
			return "Controller Is Running";
		}
		
	//4th Rest-API for Case Expressions with CriteriaBuilder.selectCase()
		@GetMapping("/getSelectCase")
		public String selectCase()
		{
			this.daoIMpl.selectCase();
			return "Expression SelectCase Working";
		}
		
	//5th Rest-API for joinsImplementation in criteria Builder
	 @GetMapping("/getJoinsImplementation")
	 public String joinsImplementation()
	 {
		 this.daoIMpl.joinsImplementation();
		 return "joins Implementation in Criteria Builder working!!";
	 }
	
}
