package com.mycompany.myhome.freeboard;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("freeboardDao")
public class FreeboardDaoImpl implements FreeboardDao{
	
	@Resource(name="sm")
	SqlSessionTemplate sm;
	
	@Override
	public List<FreeboardDto> getList(FreeboardDto dto) {
		return sm.selectList("FreeBoard_getList", dto);
	}

	@Override
	public void insert(FreeboardDto dto) {
		sm.insert("FreeBoard_insert", dto);
	}

	@Override
	public FreeboardDto getView(String id) {
		sm.update("FreeBoard_hit", id); // 조회수 증가
		return sm.selectOne("FreeBoard_view", id);
	}

	@Override
	public int getTotalCount(FreeboardDto dto) {
		
		return sm.selectOne("FreeBoard_getTotal", dto);
	}

}
