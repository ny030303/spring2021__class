package com.mycompany.myhome.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	//SqlSessionTemplate - �� Ŭ������ ���� ��������
	//@Resource�� ����, @Resource �̸��� �� �� ������
	//@Autowrired Ÿ�Ը� ������ �����´�. @Autowired ������ ���� @Resource �̴�.
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<BoardDto> getList() {
		
		return sm.selectList("Board_getList");
	}

	@Override
	public void insert(BoardDto dto) {
		// xml ������ id, parameterType�� ���޵� ��ü
		sm.insert("Board_insert", dto);
		
	}

	@Override
	public BoardDto getView(String id) {
		// TODO Auto-generated method stub
		return sm.selectOne("Board_view", id);
	}

}
