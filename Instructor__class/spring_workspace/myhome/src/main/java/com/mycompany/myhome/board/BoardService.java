package com.mycompany.myhome.board;

import java.util.List;

public interface BoardService {
	List<BoardDto> getList();
	void insert(BoardDto dto);
	BoardDto getView(String id);
}
/* 서비스는 작업단위, Dao는 테이블 단위
 * 하나의 서비스에 여러개의 Dao 소유 가능한다.
 *
 * 쇼핑몰 -> 물건 팔면, 주문, 배송, 쿠폰, 포인트, 고객 마일리지
*/