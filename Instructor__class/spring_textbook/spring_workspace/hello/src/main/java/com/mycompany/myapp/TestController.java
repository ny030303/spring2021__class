package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	String test() {
		System.out.println("test @@@@@@@@@@@");
		return "home";
	}
}
