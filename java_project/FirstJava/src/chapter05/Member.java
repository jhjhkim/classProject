package chapter05;

//	Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//	단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 

public class Member {

//	① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	String name;		// 이름
	String phoneNumber;	// 전화번호
	String major;		// 전공
	int grade;			// 학년
	String eMail;		// 이메일주소
	String birthDay;	// 생일
	String address;		// 주소
	
//	② 위에서 정의한 정보를 출력하는 메소드 정의
	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("전공: " + major);
		System.out.println("학년: " + grade);
		System.out.println("이메일: " + eMail);
		System.out.println("생일: " + birthDay);
		System.out.println("주소: " + address);
	}
	
//	③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
	public Member(String name, String phoneNumber, String major, int grade, String eMail, String birthDay, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.eMail = eMail;
		this.birthDay = birthDay;
		this.address = address;		
	}
	
	public Member(String name, String phoneNumber, String major, int grade, String eMail) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.eMail = eMail;		
	}
	
	// 기본생성자
	public Member() {}
	
//	④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	public static void main(String[] args) {
		Member member1 = new Member("학생1", "010-0000-0000", "경영학과", 4, "email@email.com", "1998.01.01.", "주소");
		Member member2 = new Member("학생2", "010-0000-1111", "수학과", 2, "email2@email.com");
		
		member1.printInfo();
		System.out.println("--------------------------\n");
		member2.printInfo();
	}
}
