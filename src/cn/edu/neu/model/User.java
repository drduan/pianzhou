package cn.edu.neu.model;

public class User { 

	private int userId;
	private String userName;
	private String userPass;
	private String userSex;
	private String userEmail;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPass=" + userPass + ", userSex=" + userSex
				+ ", userEmail=" + userEmail + "]";
	}
	public User(int userId, String userName, String userPass, String userSex,
			String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userSex = userSex;
		this.userEmail = userEmail;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	
}
