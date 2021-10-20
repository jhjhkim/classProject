package chapter10.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		String username;
		int year;
		
		// 1. 사용자 아이디
		System.out.println("아이디를 입력해주세요. 영문자와 숫자만 입력 가능합니다.");
		System.out.print("> ");
		
		try {
			
			username = getId();
			System.out.println("입력한 아이디는 " + username + " 입니다.");
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// 2. 태어난 연도
		System.out.println("태어난 연도를 입력해주세요.");
		System.out.print("> ");
		
		try{
			
			year = getYear();
			System.out.println("태어난 해: " + year + "년");
			
		} catch (InputMismatchException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static String getId() throws BadIdInputException {
		
		String username = null;
		
		Scanner sc = new Scanner(System.in);
		username = sc.nextLine();
		char[] array = new char[username.length()];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = username.charAt(i);
			int temp = (int)array[i];
			
			// char 변수를 ASCII 코드값으로 바꾸어 검사
			if((temp < 48) || (temp > 57 && temp < 65) 
					|| (temp > 90 && temp < 97) 
					|| (temp > 122)) {
				BadIdInputException e = new BadIdInputException();
				throw e;
			}
		}
		
		return username;
	}
	
	public static int getYear() {
		
		int year = 0;
		
		Scanner sc = new Scanner(System.in);
		year = sc.nextInt();
		
		return year;
	}
	
}
