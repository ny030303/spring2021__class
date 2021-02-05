package net.gondr.dao;

import java.util.List;

import net.gondr.domain.BoardVO;

public interface BoardDAO {
	// 글 쓰는 메서드
	public void write(BoardVO data);
	// 글 보는 메서드
	public BoardVO view(Integer id);
//	글 리스트 보기
	public List<BoardVO> list(Integer start, Integer cnt);
//	글삭제
	public void delete(Integer id);
//	글수정
	public void update(BoardVO data);
//	현재 글의 갯수
	public Integer getCnt();
}
