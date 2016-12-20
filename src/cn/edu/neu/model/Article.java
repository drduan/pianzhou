package cn.edu.neu.model;

import java.util.Date;

public class Article {
	
	private int artid;
	private int authorId;
	private String title;
	private String content;
	private Date indate;
	private int read;
	@Override
	public String toString() {
		return "Article [artid=" + artid + ", authorId=" + authorId + ", title=" + title + ", content=" + content
				+ ", indate=" + indate + ", read=" + read + "]";
	}
	public int getArtid() {
		return artid;
	}
	public void setArtid(int artid) {
		this.artid = artid;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
}