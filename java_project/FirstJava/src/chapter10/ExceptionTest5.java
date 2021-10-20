package chapter10;

import java.util.Scanner;

public class ExceptionTest5 {

	public static void main(String[] args) {
		
		System.out.println("나이를 입력해주세요.");
		
		try {
			int age = getAge();
			System.out.println("나이는 " + age + "세입니다.");
			
		} catch(AgeInputException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
			e.print();
		}
		
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	// 사용자의 나이를 입력받아 반환하는 메소드
	public static int getAge() throws AgeInputException {
		// throws AgeInputException
		// 메소드 내부에서 AgeInputException 예외가 발생하면
		// 메소드 내부에서 
		
		int age = 0;
		
		Scanner sc = new Scanner(System.in);
		age = sc.nextInt();
		if(age < 0) {
			AgeInputException e = new AgeInputException();
			throw e;
		}
		
		return age;
	}
	
}
