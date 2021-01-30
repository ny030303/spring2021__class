package com.mycompany.myhome.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//@Resource 가 boardDao라는 이름의 객체를 찾아서 연결작업(Dependency Injection)
	@Resource(name="boardDao")
	BoardDao boardDao;
	
	@Override
	public List<BoardDto> getList() {
		
		return boardDao.getList();
	}

	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
		
	}
	
	@Override
	public BoardDto getView(String id) {
		return boardDao.getView(id);
	}

}
