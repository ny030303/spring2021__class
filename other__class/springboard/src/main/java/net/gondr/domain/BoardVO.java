package net.gondr.domain;

import java.sql.Date;

public class BoardVO {
	private Integer id;
	private String title;
	private String content;
	private String writer;
	private Date write;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite() {
		return write;
	}
	public void setWrite(Date write) {
		this.write = write;
	}
	
}
