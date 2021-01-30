package com.mycompany.myapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestController;

@RestController   //함수앞에 @ResponseBody 없어도 된다. 
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET) // value가 url이고 method 특별히 지정할경우 지정된것만 
	String hello() {
		return "Hello Spring boot";
	}
}
