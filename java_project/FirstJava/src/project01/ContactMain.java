package project01;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// scanner 사용을 위해 초기화
		
		// 생성자 호출
		Contact cont = new Contact();
		
		// 사용자의 입력을 받아 인스턴스 생성
		System.out.println("이름을 입력해주세요.");
		System.out.print("> ");
		String name = new String(scanner.nextLine());
		
		System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
		System.out.print("> ");
		String phoneNumber = new String(scanner.nextLine());
		
		System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
		System.out.print("> ");
		String eMail = new String(scanner.nextLine());
		
		System.out.println("주소를 입력해주세요.");
		System.out.print("> ");
		String address = new String(scanner.nextLine());
		
		System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
		System.out.print("> ");
		String birthDay = new String(scanner.nextLine());
		
		System.out.println("그룹을 입력해주세요.");
		System.out.print("> ");
		String group = new String(scanner.nextLine());
		
		cont = new Contact(name, phoneNumber, eMail, address, birthDay, group);
		
		// 변수값 반환하는 getter 메소드를 호출하여 데이터 출력
		System.out.println("이름: " + cont.getName());
		System.out.println("전화번호: " + cont.getPhoneNumber());
		System.out.println("이메일주소: " + cont.geteMail());
		System.out.println("주소: " + cont.getAddress());
		System.out.println("생일: " + cont.getBirthDay());
		System.out.println("그룹: " + cont.getGroup());
		
		// 정보 출력 메소드 실행
		cont.printInfo();
		
		// 정보 수정 메소드 실행
		cont.updateInfo(scanner);
		
		// 정보 출력 메소드 실행
		cont.printInfo();
		
		scanner.close();	// scanner 사용 종료
	}
	
}
