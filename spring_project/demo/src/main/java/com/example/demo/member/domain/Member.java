package com.example.demo.member.domain;

public class Member {

	private int idx;
	private String userid;
	private String password;
	private String username;
	private String photo;
	private String regdate;
	
	public Member() {}

	public Member(int idx, String userid, String password, String username, String photo, String regdate) {
		this.idx = idx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.photo = photo;
		this.regdate = regdate;
	}



	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", password=" + password + ", username=" + username
				+ ", photo=" + photo + ", regdate=" + regdate + "]";
	}

	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.idx, this.userid, this.username, this.photo);
	}
	
}
