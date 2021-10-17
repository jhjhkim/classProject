package project02;

public class Contact {

	private String name;		// 이름
	private String phoneNumber;	// 전화번호
	private String eMail;		// 이메일
	private String address;		// 주소
	private String birthday;	// 생일
	private String group;		// 그룹
	
	// getter 와 setter 메소드
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
	
	// 기본 생성자
	public Contact() {
		
	}

	// 매개변수 있는 생성자
	public Contact(String name, String phoneNumber, String eMail, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	// 정보 출력 메소드
	public void printInfo() {
		System.out.println("이름: " + this.getName() 
				  + "\t" + "전화번호: " + this.getPhoneNumber());
		System.out.println("이메일주소: " + this.geteMail());
		System.out.println("주소: " + this.getAddress());
		System.out.println("생일: " + this.getBirthday());
		System.out.println("그룹: " + this.getGroup());
	}
	
}
