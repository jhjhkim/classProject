package chapter03;

import java.util.Scanner;

// 연산자
// 단항 : 피연산자가 한 개
// 이항 : 피연산자가 두 개
//		산술연산 - a+b, a*b, ...
//		관계연산(비교연산) - 결과로 논리값이 나온다 true/false
//		논리연산자 &&, ||
// 삼항 : 논리값 ? 참일때 : 거짓일때

public class Calculator {
	
	// Calculator 클래스를 정의해봅시다. 	
	// final : 변수 앞에 -> 상수 (최초 초기화된 값을 바꾸지 못한다!!!)
	//		       클래스 앞에 -> 상속의 대상이 아니다!!!
	final float PI = (float)Math.PI;
	final String USER_NAME;
	
	// 생성자 : 초기화 메소드, 메소드 구조와 유사하지만 반환기능이 없다.
	// 클래스이름(){}
	public Calculator() {
		// 생성자를 통한 상수의 초기화가 허용된다.
		USER_NAME = "손흥민";
	}
	
	public Calculator(String name) {
		USER_NAME = name;
	}
	
	// ① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	public void printAdd(int num1, int num2) {
		long result = (long)num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	
	// ② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public void printMinus(int num1, int num2) {
		long result = (long)num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
	}
	
	// ③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	public void printMultiply(int num1, int num2) {
		long result = (long)num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
	}
	
	// ④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	public void printDivide(int num1, int num2) {
		double result = (double)num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
	}
	
	// ⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 정의
	float printCircumference(float r) {
		return 2 * PI * r;
	}
	
	// ⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 정의
	//		원의 둘레 : 2 x π x r , 원의 넓이 : π x r x r
	float printArea(float r) {
		return PI * r * r;
	}
	
	// ⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		// 상수 출력
		System.out.println("PI: " + cal.PI);
		System.out.println("USER_NAME: " + cal.USER_NAME);
		
		int num1 = 7;
		int num2 = 3;
		cal.printAdd(num1, num2);
		cal.printMinus(num1, num2);
		cal.printMultiply(num1, num2);
		cal.printDivide(num1, num2);
		
		System.out.println("---------------------------");
		
		float r = 4.5f;
		cal.printCircumference(r);
		cal.printArea(r);
		
		System.out.println("\n=============================\n");
		
		// ⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 
		//		main() 메소드에 추가해봅시다.
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 두 개 입력해주세요.");
		System.out.print("첫 번째 정수 : ");
		num1 = scanner.nextInt();
		System.out.print("두 번째 정수 : ");
		num2 = scanner.nextInt();
		System.out.println();
		cal.printAdd(num1, num2);
		cal.printMinus(num1, num2);
		cal.printMultiply(num1, num2);
		cal.printDivide(num1, num2);
		
		System.out.println("---------------------------");
		
		System.out.println("반지름을 실수 형태로 입력해주세요.");
		System.out.print("> ");
		r = scanner.nextFloat();
		System.out.println();
		System.out.println("반지름이 " + r + "인 원의 둘레: " + cal.printCircumference(r));
		System.out.println("반지름이 " + r + "인 원의 넓이: " + cal.printArea(r));
		
		System.out.println("\n=============================\n");
		
		// 강사님 코드
		System.out.println("덧셈을 시작합니다.\n숫자1을 입력해주세요.");
		num1 = Integer.parseInt(scanner.nextLine());
		// System.out.println(num1);
		System.out.println("숫자2를 입력해주세요.");
		num2 = Integer.parseInt(scanner.nextLine());

		cal.printAdd(num1, num2);
		
		System.out.println("==========================");
		System.out.println("원의 둘레와 넓이를 구합니다.\n반지름을 입력해주세요.");
		r = Float.parseFloat(scanner.nextLine());
		
		System.out.println("전달받은 반지름: " + r);
		System.out.println("원의 둘레: " + cal.printCircumference(r));
		System.out.println("원의 넓이: " + cal.printArea(r));
		
		scanner.close();
		
	}
	
}
