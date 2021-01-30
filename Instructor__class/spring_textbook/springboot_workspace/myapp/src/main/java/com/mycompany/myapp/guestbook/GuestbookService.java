package com.mycompany.myapp.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;

	
	public List<GuestbookDto> getList() {
		
		return guestbookDao.getList();
	}

	
	public void insert(GuestbookDto dto) {
		guestbookDao.insert(dto);
		
	}

	
	public GuestbookDto getView(int id) {
		
		return guestbookDao.getView(id);
	}

	
	public void update(GuestbookDto dto) {
		
		guestbookDao.update(dto);
		
	}

	
	public void delete(GuestbookDto dto) {
		guestbookDao.delete(dto);
	}


}
