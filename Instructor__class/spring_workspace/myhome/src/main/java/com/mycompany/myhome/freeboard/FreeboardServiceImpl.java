package com.mycompany.myhome.freeboard;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("freeboardService")
public class FreeboardServiceImpl implements FreeboardService{
	@Resource(name="freeboardDao")
	FreeboardDao dao;

	@Override
	public List<FreeboardDto> getList(FreeboardDto dto) {
		return dao.getList(dto);
	}

	@Override
	public void insert(FreeboardDto dto) {
		dao.insert(dto);
	}

	@Override
	public FreeboardDto getView(String id) {
		return dao.getView(id);
	}

	@Override
	public int getTotalCount(FreeboardDto dto) {
		return dao.getTotalCount(dto);
	}
	
	
	
	
}
