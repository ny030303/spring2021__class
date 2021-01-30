package com.mycompany.myapp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:9000/myapp/index
@Controller 
public class IndexController {
	
	
	//객체 끼워넣기 -- Autowired 적절한 객체를 찾아서 끼워넣기를 한다 
	@Autowired
	IIndexService service;//참조만 가지고 있는 상태 
	
	
	@RequestMapping("/index")
	String index() {
		
		System.out.println( service.message() );
		
		return "home"; //jsp 문서 이름 
	}
	
	@RequestMapping("/indexjson")
	@ResponseBody
	HashMap<String, String>indexjson(){
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("product_name", "갤럭시S");
		map.put("product_price", "9800000");
		map.put("product_company", "삼성전자");
		map.put("product_director", "홍길동");
		
		return map;
	}
	
	@RequestMapping("/receive")
	@ResponseBody
	HashMap<String, String>indexjson(@RequestBody HashMap<String, String> map){
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("email"));
		System.out.println(map.get("phone"));
		
		return map; 
	}
	
	
}








