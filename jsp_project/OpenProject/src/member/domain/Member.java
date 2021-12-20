package member.domain;

import java.sql.Timestamp;

public class Member {

	private int idx;
	private String userid;
	private String pw;
	private String username;
	// private Timestamp regdate;	// java.sql.Timestamp -> java.util.Date
	private String regdate;			// DB: 2021.12.20.12:21 => 날짜계산 안할 거라면!
	
	public Member() {
	}
	
	public Member(int idx, String userid, String pw, String username, String regdate) {
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.username = username;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
