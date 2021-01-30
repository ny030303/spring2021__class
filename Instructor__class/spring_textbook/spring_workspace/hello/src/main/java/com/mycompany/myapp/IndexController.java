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
	
	
	//��ü �����ֱ� -- Autowired ������ ��ü�� ã�Ƽ� �����ֱ⸦ �Ѵ� 
	@Autowired
	IIndexService service;//������ ������ �ִ� ���� 
	
	
	@RequestMapping("/index")
	String index() {
		
		System.out.println( service.message() );
		
		return "home"; //jsp ���� �̸� 
	}
	
	@RequestMapping("/indexjson")
	@ResponseBody
	HashMap<String, String>indexjson(){
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("product_name", "������S");
		map.put("product_price", "9800000");
		map.put("product_company", "�Ｚ����");
		map.put("product_director", "ȫ�浿");
		
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








