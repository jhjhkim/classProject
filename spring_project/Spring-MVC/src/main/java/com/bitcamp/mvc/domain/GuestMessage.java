package com.bitcamp.mvc.domain;

import java.util.Date;

public class GuestMessage {
	
	private int idx;
	private String message;
	private Date date;
	
	public GuestMessage() {}
	
	public GuestMessage(int idx, String message, Date date) {
		this.idx = idx;
		this.message = message;
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestMessage [idx=" + idx + ", message=" + message + ", date=" + date + "]";
	}

}
