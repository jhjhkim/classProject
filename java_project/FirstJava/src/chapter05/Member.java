package chapter05;

//	Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//	단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 

public class Member {

	//	① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	private String name;		// 이름
	private String phoneNumber;	// 전화번호
	private String major;		// 전공
	private int grade;			// 학년
	private String eMail;		// 이메일주소 QQQ@dd.com
	private String birthDay;	// 생일 20001020, 2000-10-20, 2000/10/20
	private String address;		// 주소
		
	// 기본생성자
	public Member() {
		
	}	
	
	// 모든 정보를 저장하도록 하는 생성자
	public Member(String name, 
				  String phoneNumber, 
				  String major, int grade, 
				  String eMail, 
				  String birthDay, 
				  String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.eMail = eMail;
		this.birthDay = birthDay;
		this.address = address;		
	}
	
	// 생일과 주소를 저장하지 않는 생성자
	public Member(String name, 
				  String phoneNumber, 
				  String major, int grade, 
				  String eMail) {
		// this.name = name;
		// this.phoneNumber = phoneNumber;
		// this.major = major;
		// this.grade = grade;
		// this.eMail = eMail;
		// this.birthDay = "";
		// this.address = "";
		// this(name, phoneNumber, major, grade, eMail, null, null);
		this(name, phoneNumber, major, grade, eMail, "생일정보 없음", "주소정보 없음");
	}
	
	// 위에서 정의한 정보를 출력하는 메소드 정의
	public void printInfo() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("전공: " + this.major);
		System.out.println("학년: " + this.grade);
		System.out.println("이메일: " + this.eMail);
		System.out.println("생일: " + this.birthDay);
		System.out.println("주소: " + this.address);
		System.out.println("--------------------------\n");
	}
}
