package com.mycompany.myapp.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//ctrl-shift-o
@Repository 
public class GuestbookDaoImpl implements GuestbookDao{

	//List<GuestbookDto> list = new ArrayList<GuestbookDto>();
	@Autowired
	SqlSessionTemplate sm;
	
	public GuestbookDaoImpl() {
		/*for(int i=1; i<=10; i++) {
			list.add(new GuestbookDto(i, "제목"+i, "홍길동"+i, "2020-11-"+i, "내용"+i ));
		}*/
		
	}
	
	@Override
	public List<GuestbookDto> getList() {
		
		GuestbookDto dto = new GuestbookDto();
		dto.setPg(0); 
		return sm.selectList("Guestbook_getList", dto);
	}

	@Override
	public void insert(GuestbookDto dto) {
		
		sm.insert("Guestbook_insert", dto);
	}

	@Override
	public GuestbookDto getView(int id) {
		
		return sm.selectOne("Guestbook_getView", id);
	}

	@Override
	public void update(GuestbookDto dto) {
		sm.update("Guestbook_update", dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		
		sm.update("Guestbook_delete", dto);
	}

}





