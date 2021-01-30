package com.mycompany.myapp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//도메인이 써야 함  ww.mycompany 
@CrossOrigin("*")
@RestController
public class MemberController {
	@Autowired
	MemberDao dao;
	
	@RequestMapping("/member/list")
	List<MemberDto> getList(MemberDto dto){
		System.out.println("#############################");
		return dao.getList(dto);
	}
	
	@RequestMapping("/member/insert")
	String insert(@RequestBody MemberDto dto){
		System.out.println(dto.getUser_id());
		System.out.println(dto.getUsername());
		
		dao.insert(dto);
		
		return "success";
	}
	
	// http://localhost:9090/member/view/test
	@RequestMapping("/member/view/{user_id}")
	MemberDto member_view(@PathVariable("user_id")String user_id) {
		System.out.println("사용자 아이디 : " + user_id);
		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);
		
		return dao.view(dto);
	}
	
	//id중복체크 
	//@RequestMapping("/member/idcheck/{user_id}")
	
	@RequestMapping("/test")
	String test() {
		return "test";
	}
}




