package com.example.demo.member.domain;

public class LoginParams {

	private String userId;
	private String pw;
	
	public LoginParams() {
	}

	public LoginParams(String userId, String pw) {
		this.userId = userId;
		this.pw = pw;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
