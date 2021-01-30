package com.mycompany.myhome.board;

import java.util.List;

public interface BoardService {
	List<BoardDto> getList();
	void insert(BoardDto dto);
	BoardDto getView(String id);
}
/* ���񽺴� �۾�����, Dao�� ���̺� ����
 * �ϳ��� ���񽺿� �������� Dao ���� �����Ѵ�.
 *
 * ���θ� -> ���� �ȸ�, �ֹ�, ���, ����, ����Ʈ, �� ���ϸ���
*/