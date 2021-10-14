package chapter05;

public class MemberMain {
	
	//	④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스)를 만들었다!
		// Member 클래스로 인스턴스를 생성하면 데이터를 저장하는 것과 같다!
		
		Member member1 = new Member("학생1", "010-0000-0000", "경영학과", 4, "email@email.com", "1998-01-01", "주소");
		Member member2 = new Member("학생2", "010-0000-1111", "수학과", 2, "email2@email.com");
		
		member1.printInfo();
		member2.printInfo();
	}
}
