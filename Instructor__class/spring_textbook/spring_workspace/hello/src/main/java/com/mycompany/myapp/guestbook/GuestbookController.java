package com.mycompany.myapp.guestbook;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestbookController {

	@Autowired 
	GuestbookService service;
	
	/*@RequestMapping("/guestbook/list")
	String guestbook_list(Model model) {
		//받아온 데이터를 jsp로 보내야 한다 
		//request 객체에 데이터를 담아 보낸다. 
		//Model 객체에 담아보내면 jsp 페이지에서는 request.getAttribute 함수를 이용해서 
		//객체를 받을 수 있다 
		
		//Hashmap이나 Dictionary 와 유사 키와 객체 
		model.addAttribute("guestbookList", service.getList());
		
		return "/guestbook/list";
	}*/
	
	//페이지 이동만한다 
	@RequestMapping("/guestbook/list")
	String guestbook_list(Model model) {		
		return "/guestbook/guestbook_list";
	}
	
	@RequestMapping("/guestbook/view/{id}")
	String guestbook_view(@PathVariable("id")int id, Model model) {
		
		model.addAttribute("id", id);
		return "/guestbook/guestbook_view";
	}
	
	@RequestMapping("/guestbook/write")
	String guestbook_write(Model model) {		
		return "/guestbook/guestbook_write";
	}
	
	
	
	@RequestMapping("/guestbook/listjson")
	@ResponseBody
	List<GuestbookDto> guestbook_listjson() {
		return service.getList();
	}
	
	@RequestMapping("/guestbook/insertjson")
	@ResponseBody 
	HashMap<String, String> insert(@RequestBody GuestbookDto dto) {
		dto.setPg(0);
		dto.setId(0);
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		
		service.insert(dto);
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("result", "success");
		return map;
	}
	
	//http://localhost:9000/myapp/guestbook/viewjson/1
	
	@RequestMapping("/guestbook/viewjson/{id}")
	@ResponseBody
	GuestbookDto guestbook_viewjson(@PathVariable("id")int id) {
		return service.getView(id);
	}
	
	
	@RequestMapping("/guestbook/updatejson")
	@ResponseBody 
	String update(@RequestBody GuestbookDto dto) {
		dto.setPg(0);
		dto.setId(0);
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		service.update(dto);
		return "success";
	}
	
	@RequestMapping("/guestbook/deletejson/{id}")
	String guestbook_deletejson(@PathVariable("id")int id) {
		GuestbookDto dto = new GuestbookDto();
		dto.setId(id);
		service.delete(dto);
		
		return "success";
	}
	
}







