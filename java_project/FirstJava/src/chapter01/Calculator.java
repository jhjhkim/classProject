package chapter01;

public class Calculator {

	/*
	3. Calculator 클래스를 정의해 봅시다.
	① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	④ 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
	 */
	
	// ① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	// 데이터 반환 : 숫자 두 개를 더하기 연산한 결과를 반환
	// 매개변수 : 숫자 두 개를 매개변수의 인자로 전달받아 -> int num1, int num2
	//	num1+num2 => int
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// ② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	int minus(int num1, int num2) {
		return num1 - num2;
	}
	
	// ③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	// 매개변수 : 숫자 두 개를 매개변수의 인자로 전달받아 -> long num1, long num2
	//	int * int => int, (long)int * int => 22억
	// 	long * int => long
	long multiply(long num1, long num2) {
		return num1 * num2;
	}
	
	// ④ 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
	// int / int => int
	// divide(1,2)
	// divide(1.5,2.0)
	// 메소드의 오버로딩은 메소드의 호출시에 정해진다!
	int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	// 오버로딩 : 이름이 같은 메소드를 정의
	// 오버로딩의 조건 : 이름이 같다, 매개변수의 개수 또는 데이터타입이 달라야 한다!, 반환타입은 상관 없다!
	float divide(float num1, float num2) {
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		
		// 클래스에 정의된 메소드의 사용 => 클래스를 이용해서 인스턴스(객체)를 생성
		// 클래스의 멤버(변수, 메소드)들이 메모리에 로드된다!
		// 객체 생성 : new 클래스이름() => 참조값(객체의 메모리 주소값)
		// 참조변수 : 객체의 주소값을 저장하는 변수
		// 클래스이름 변수이름
		Calculator cal = new Calculator();
		System.out.println("더하기 메소드 호출");
		System.out.println("1+2=" + cal.add(1, 2));
		System.out.println("빼기 메소드 호출");
		System.out.println("20-10=" + cal.minus(20, 10));
		System.out.println("곱하기 메소드 호출");
		System.out.println("1000000*1000000=" + cal.multiply(1000000, 1000000));
		// 자동 형변환 : byte -> short -> int -> long
		System.out.println("정수 나누기 메소드 호출");
		System.out.println("10/3=" + cal.divide(10, 3));
		System.out.println("실수 나누기 메소드 호출");
		System.out.println("10.0/3.0=" + cal.divide(10.0f, 3.0f));
		// 정수의 기본타입은 => int
		// 실수의 기본 타입은 => double
		// 10.0/3.0 => double/double
		}
}
