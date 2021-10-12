package chapter02;

public class Member {
	/* 1. 앞서 생성 했던 Member 클래스에 main() 메소드 안에 아래 조건의 변수를 정의해봅시다.
	① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
	② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
	③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
	④ boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
	⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
	 */
	
	// 클래스 정의
	// [접근제어자] [final] 클래스이름 {}
	// {
	//		변수 정의
	//		메소드 정의
	// }
	
	String name;		// 사용자의 이름
	int age;			// 사용자의 나이
	double height;		// 사용자의 키
	boolean hasBook;	// JAVA책의 보유 여부
	
	// 공통 코드들 => 메소드로 정의 => Member 클래스에서 메소드를 정의
	
	// 회원의 데이터를 출력하는 메소드
	void printData() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("자바 도서의 보유 여부: " + hasBook);
	}
	
	
	public static void main(String[] args) {
		
		// Member 클래스로 인스턴스를 생성 -> 이름, 나이, 키, 책보유상태 저장할 수 있는 메모리 공간을 생성
		Member member = new Member();
		
		// 인스턴스의 변수를 참조해서 출력
//		System.out.println("이름: " + member.name);
//		System.out.println("나이: " + member.age);
//		System.out.println("키: " + member.height);
//		System.out.println("자바 도서의 보유 여부: " + member.hasBook);
		
		member.printData();
		
		// 인스턴스 변수의 값을 변경
		member.name = "김지현";
		member.age = 31;
		member.height = 160.5;
		member.hasBook = true;
		
		System.out.println("-----------------------");
		System.out.println("인스턴스 변수의 값을 변경");
		System.out.println("-----------------------");
		
//		System.out.println("이름: " + member.name);
//		System.out.println("나이: " + member.age);
//		System.out.println("키: " + member.height);
//		System.out.println("자바 도서의 보유 여부: " + member.hasBook);
		
		member.printData();
		
	}
	
}
