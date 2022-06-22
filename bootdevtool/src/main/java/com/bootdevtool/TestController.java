package com.bootdevtool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/add")
	public String test()
	{
		int a=50;
		int b=500;
		return "This is testing /t sum of a and b is " + (a+b);
	}
}
