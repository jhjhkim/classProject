package mm.domain;

import java.util.Date;

public class RegRequest {

	// 이메일, 비밀번호, 비밀번호 확인, 이름
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public RegRequest() {}

	public RegRequest(String email, String password, String confirmPassword, String name) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	// 비밀번호와 비밀번호확인 일치 여부
	public boolean isPwRePwEquals() {
		return this.password.equals(this.confirmPassword);
	}
	
	// RegRequest -> Member
	public Member toMember() {
		return new Member(0, email, password, name, new Date());
	}
	
}
