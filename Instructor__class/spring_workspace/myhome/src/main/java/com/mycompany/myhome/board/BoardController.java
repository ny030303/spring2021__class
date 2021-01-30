package com.mycompany.myhome.board;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	//DI-Dependency Injection
	@Resource(name="boardService")
	BoardService boardService;
	
	@RequestMapping("/board/list")
	String board_list(Model model)
	{
		model.addAttribute("boardList", boardService.getList());
		return "board/board_list";
	}
	
	//write 페이지로 이동
	@RequestMapping("/board/write")
	String board_write() {
		return "board/board_write";
	}
	//저장하기
	@RequestMapping("/board/save")
	String board_save(BoardDto dto) {
		
		// 알아서 파라미터 값들이 dto 안에 들어와 있다.
		boardService.insert(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/view")
	String board_save(Model model, String id) {
		
		model.addAttribute("boardDto", boardService.getView(id));
		return "board/board_view";
	}
}
