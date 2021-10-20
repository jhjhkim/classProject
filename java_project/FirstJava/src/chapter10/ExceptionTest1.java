package chapter10;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요.");
		int num2 = sc.nextInt();
		
		int result = 0;
		
		try {

			result = num1 / num2;	// try블럭 안에서 선언한 변수는 블럭이 끝나면 사라진다
									// try블럭의 영향을 받는 코드들은 블럭 안에 넣어주어야 한다!
			System.out.println("나눗셈이 정상적으로 처리되었습니다.");
			System.out.println("나눗셈의 결과는 " + result + " 입니다.");
		
		} catch(ArithmeticException e) {
			
			System.out.println("0으로 나누기를 할 수 없습니다.");
			System.out.println(e.getMessage());
			
		} catch(Exception e) {
			System.out.println("오류 발생");
		}
		
		System.out.println("프로그램을 종료합니다.");

		
		sc.close();
	}
	
}
