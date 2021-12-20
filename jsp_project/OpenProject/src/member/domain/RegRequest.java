package member.domain;

public class RegRequest {

	private String userid;
	private String pw;
	private String username;
	
	public RegRequest() {
		
	}

	public RegRequest(String userid, String pw, String username) {
		this.userid = userid;
		this.pw = pw;
		this.username = username;
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

	@Override
	public String toString() {
		return "RegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + "]";
	}
	
	// RegRequest -> Member
	public Member getMember() {
		return new Member(0, this.userid, this.pw, this.username, null);
	}
}
