package project07;

// 1.Contact 클래스는 기본정보를 저장하고 기본 정보를 출력하는 메소드를 정의합니다.
//	- 생성자를 통해 기본 정보들을 초기화 합니다.
public abstract class Contact implements ShowData {
	
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

	
	// HashSet<E> 를 이용하기 위해 hashCode() 와 equals() 오버라이드
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof Contact) {
			Contact c = (Contact) obj;
			if(this.name.equals(c.getName())) {
				result = true;
			}
		}
		
		
		
		return result;
	}

	@Override
	public int hashCode() {
		return this.name.charAt(0) % 10;	// 이름의 첫글자를 이용하기
	}
	
}
