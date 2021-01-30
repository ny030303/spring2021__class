package com.mycompany.myapp.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;

	@Override
	public List<GuestbookDto> getList() {
		
		return guestbookDao.getList();
	}

	@Override
	public void insert(GuestbookDto dto) {
		guestbookDao.insert(dto);
		
	}

	@Override
	public GuestbookDto getView(int id) {
		
		return guestbookDao.getView(id);
	}

	@Override
	public void update(GuestbookDto dto) {
		
		guestbookDao.update(dto);
		
	}

	@Override
	public void delete(GuestbookDto dto) {
		guestbookDao.delete(dto);
	}


}
