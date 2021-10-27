package project08;

import java.io.Serializable;

public abstract class Contact implements ShowData, Serializable {
	
	private String name;		// 이름
	private String phoneNumber;	// 전화번호
	private String eMail;		// 이메일
	private String address;		// 주소
	private String birthday;	// 생일
	private String group;		// 그룹
	
	public Contact() {
		this.name = "";
		this.phoneNumber = "";
		this.eMail = "";
		this.address = "";
		this.birthday = "";
		this.group = "";
	}
	
	public Contact(String name, String phoneNumber, String eMail, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void showData() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("이메일: " + eMail);
		System.out.println("주소: " + address);
		System.out.println("생일: " + birthday);
		System.out.println("그룹: " + group);
	}
	
}
