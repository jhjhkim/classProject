package domain;

public class LoginInfo {

	private String uid;
	private String name;
	private String nick;
	private String email;

	// 생성자로 초기화
	public LoginInfo(String uid, String name, String nick, String email) {
		this.uid = uid;
		this.name = name;
		this.nick = nick;
		this.email = email;
	}

	// 읽기 전용
	public String getUid() {
		return uid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", name=" + name + ", nick=" + nick + ", email=" + email + "]";
	}
	
}
