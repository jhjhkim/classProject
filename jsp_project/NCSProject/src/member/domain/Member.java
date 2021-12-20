package member.domain;

public class Member {

	private String userid;
	private String password;
	private String username;
	private String regdate;
	
	public Member(String userid, String password, String username, String regdate) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.regdate = regdate;
	}
	
	public Member(String userid, String password, String username) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.regdate = null;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
