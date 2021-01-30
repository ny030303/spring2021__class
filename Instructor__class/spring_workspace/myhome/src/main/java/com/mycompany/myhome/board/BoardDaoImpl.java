package com.mycompany.myhome.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	//SqlSessionTemplate - 이 클래스가 디비랑 최종연결
	//@Resource와 유사, @Resource 이름을 콕 찝어서 가져옴
	//@Autowrired 타입만 같으면 가져온다. @Autowired 문제점 개선 @Resource 이다.
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<BoardDto> getList() {
		
		return sm.selectList("Board_getList");
	}

	@Override
	public void insert(BoardDto dto) {
		// xml 파일의 id, parameterType에 전달될 객체
		sm.insert("Board_insert", dto);
		
	}

	@Override
	public BoardDto getView(String id) {
		// TODO Auto-generated method stub
		return sm.selectOne("Board_view", id);
	}

}
