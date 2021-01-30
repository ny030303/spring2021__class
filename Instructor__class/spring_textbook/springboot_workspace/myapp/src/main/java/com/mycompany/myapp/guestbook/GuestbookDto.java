package com.mycompany.myapp.guestbook;

public class GuestbookDto {
	private int pg=0;
	
	private int id;
	private String title;
	private String writer;
	private String wdate;
	private String contents;
	
	public GuestbookDto() {}
	
	public GuestbookDto(int id, String title, String writer, String wdate, String contents) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.contents = contents;
	}
	
	
	
	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	
}
