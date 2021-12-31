package mm.main;

import java.util.Scanner;

import mm.assembler.Assembler;
import mm.dao.Dao;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class MemberManager {
	
	static Assembler assembler = new Assembler();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			printMenu();
			
			String command = sc.nextLine();
			
			// exit
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}
			
			if(command.startsWith("new")) {
				String[] values = command.split(" ");
				processNewMember(values);
			}
			
			if(command.startsWith("change")) {
				
			}
			
		}
		
	}

	static void printMenu() {
		
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("---------------------------------");
		System.out.println("신규 입력");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인");	// new son@gmail.com 손흥민 123 123
		System.out.println("new son@gmail.com 손흥민 123 123");
		System.out.println();
		System.out.println("비밀번호 수정");
		System.out.println("change 이메일 현재비번 새로운비번");	// change son@gmail.com 123 000
		System.out.println("change son@gmail.com 123 000");
		System.out.println("---------------------------------");
		
	}

	private static void processNewMember(String[] values) {
		
		
	}

}
