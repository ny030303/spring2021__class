package com.mycompany.myhome;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//DispatcherServlet 클래스가 url과 적당한 컨트롤러를 연결시킨다.

@Controller
public class TestController {
	
	@RequestMapping("/test")
	String test1(Model model)
	{	
		// Model 객체는 jsp의 request 객체에 값을 전달할때 사용된다.
		// jsp 에서 ${user01} 형태의 표현식으로 접근해도 되고 request.getAttribute 함수를 사용해도 된다.
		// HashTable, HashMap 처럼 사용키돠 값 쌍을 저장한다.
		
		model.addAttribute("userid", "user01");
		model.addAttribute("username", "홍길동");
		
		return "test";
	}
	
	@RequestMapping("/test/list")
	String testList(Model model)
	{
		List<String> list = new ArrayList<String>();
		list.add("장미");
		list.add("작약");
		list.add("백일홍");
		list.add("꽃잔디");
		list.add("패랭이꽃");
		list.add("목련");
		
		model.addAttribute("flowerList", list);
		
		return "test/list"; // test폴더아래에 list.jsp 호출하기
	}	
	//http://localhost:9090/myhome/userinfo?userid=test&password=1234
	@RequestMapping("/userinfo")
	String userinfo(Model model, String userid, String password)
	{
		System.out.println("userid : " + userid);
		System.out.println("password : " + password);
		
		model.addAttribute("userid", userid);
		model.addAttribute("password", password);
		
		return "userinfo";
	}
	
	//http://localhost:9090/myhome/add?x=5&y=7
	@RequestMapping("/add")
	String add(Model model, int x, int y)
	{
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		
		return "add";
	}
}
