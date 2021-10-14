package project01;

// 1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다.
// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
// ② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

import java.util.Scanner;

public class SmartPhone {
	// 변수와 상수 선언
	Contact[] array;
	final int ARRAY_SIZE = 10;
	
	// 생성자
	public SmartPhone() {
		array = new Contact[ARRAY_SIZE];
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		SmartPhone smartPhone = new SmartPhone();
		
		for(int i = 0; i < smartPhone.array.length; i++) {
			System.out.println("===== " + (i+1) + "번째 입력 =====");
			smartPhone.add(i, scanner);
		}
		
		// 배열의 모든 요소를 출력합니다.
		System.out.println("배열의 각 요소를 출력합니다.");
		for(int i = 0; i < smartPhone.array.length; i++) {
			smartPhone.array[i].printInfo();
		}
		
		// 배열의 모든 요소를 검색합니다.
		
		// 배열의 요소를 삭제해봅시다.
		
		// 배열의 요소를 수정해봅시다.
		
		scanner.close();
	}
	
	
	// 새로운 연락처를 array의 i번 인덱스에 저장하는 메소드
	public void add(int i, Scanner scanner) {
		Contact c = new Contact();
		
		System.out.println("이름을 입력해주세요.");
		System.out.print("> ");
		c.setName(scanner.nextLine());
		
		System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
		System.out.print("> ");
		c.setPhoneNumber(scanner.nextLine());
		
		System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
		System.out.print("> ");
		c.seteMail(scanner.nextLine());
		
		System.out.println("주소를 입력해주세요.");
		System.out.print("> ");
		c.setAddress(scanner.nextLine());
		
		System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
		System.out.print("> ");
		c.setBirthDay(scanner.nextLine());
		
		System.out.println("그룹을 입력해주세요.");
		System.out.print("> ");
		c.setGroup(scanner.nextLine());
		
		array[i] = c;
	}
	
	// i번 인덱스에 저장된 연락처 c를 수정하는 메소드
	public void update(int i, Scanner scanner) {
		Contact c = new Contact();
		c.setName(array[i].getName());
		c.setPhoneNumber(array[i].getPhoneNumber());
		c.seteMail(array[i].geteMail());
		c.setAddress(array[i].getAddress());
		c.setBirthDay(array[i].getBirthDay());
		c.setGroup(array[i].getGroup());
		
		c.updateInfo(scanner);
	}
}
