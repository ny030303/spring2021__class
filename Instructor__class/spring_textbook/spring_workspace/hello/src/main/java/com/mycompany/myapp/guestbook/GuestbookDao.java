package com.mycompany.myapp.guestbook;

import java.util.List;

//�Լ� header �� 
public interface GuestbookDao {
	List<GuestbookDto> getList();
	void insert(GuestbookDto dto);
	GuestbookDto getView(int id);
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
}
