package com.mycompany.myhome.freeboard;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeboardController {
	@Resource(name="freeboardService")
	FreeboardService service;
	
	@RequestMapping("/freeboard/list")
	String freeboard_list(Model model, FreeboardDto dto)
	{
		List<FreeboardDto> list = service.getList(dto);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		model.addAttribute("freeboardList", list);
		model.addAttribute("totalCount", service.getTotalCount(dto));
		return "freeboard/list";
	}
	
	@RequestMapping("/freeboard/write")
	String freeboard_write()
	{
		return "freeboard/write";
	}
	
	@RequestMapping("/freeboard/save")
	String freeboard_save(FreeboardDto dto)
	{
		service.insert(dto);
		return "redirect:/freeboard/list";
	}
	
	@RequestMapping("/freeboard/view")
	String freeboard_save(Model model, String id)
	{
		model.addAttribute("freeboardDto", service.getView(id));
		return "freeboard/view";
	}
}
