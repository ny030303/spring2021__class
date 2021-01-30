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
	
	//write �������� �̵�
	@RequestMapping("/board/write")
	String board_write() {
		return "board/board_write";
	}
	//�����ϱ�
	@RequestMapping("/board/save")
	String board_save(BoardDto dto) {
		
		// �˾Ƽ� �Ķ���� ������ dto �ȿ� ���� �ִ�.
		boardService.insert(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/view")
	String board_save(Model model, String id) {
		
		model.addAttribute("boardDto", boardService.getView(id));
		return "board/board_view";
	}
}
