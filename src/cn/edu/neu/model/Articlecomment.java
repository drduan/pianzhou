package cn.edu.neu.model;

import java.util.Date;

public class Articlecomment {
	
	private int ac_Id;
	private int ac_articleId;
	private int ac_authorId;
	private String ac_content;
	private Date ac_indate;
    private String name;
	public int getAc_Id() {
		return ac_Id;
	}
	public void setAc_Id(int ac_Id) {
		this.ac_Id = ac_Id;
	}
	public int getAc_articleId() {
		return ac_articleId;
	}
	public void setAc_articleId(int ac_articleId) {
		this.ac_articleId = ac_articleId;
	}
	public int getAc_authorId() {
		return ac_authorId;
	}
	public void setAc_authorId(int ac_authorId) {
		this.ac_authorId = ac_authorId;
	}
	public String getAc_content() {
		return ac_content;
	}
	public void setAc_content(String ac_content) {
		this.ac_content = ac_content;
	}
	public Date getAc_indate() {
		return ac_indate;
	}
	public void setAc_indate(Date ac_indate) {
		this.ac_indate = ac_indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Articlecomment [ac_Id=" + ac_Id + ", ac_articleId=" + ac_articleId + ", ac_authorId=" + ac_authorId
				+ ", ac_content=" + ac_content + ", ac_indate=" + ac_indate + ", name=" + name + "]";
	}
	public Articlecomment() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}