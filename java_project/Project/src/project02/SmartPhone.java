package project02;

// 1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다.
// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
// ② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

import java.util.Scanner;

public class SmartPhone {
	// 변수와 상수 선언
	final int ARRAY_SIZE = 10;
	public static final Scanner scanner = new Scanner(System.in);
	private Contact[] array;
	private int numOfContact;

	// 생성자
	public SmartPhone() {
		array = new Contact[ARRAY_SIZE];
		numOfContact = 0;
	}

	public SmartPhone(int size) {
		array = new Contact[size];
		numOfContact = 0;
	}

	// 메뉴를 출력하는 메소드
	public void showMenu() {
		System.out.println("\t연락처 관리 프로그램");
		System.out.println("-------------------------------------");
		System.out.println("1. 연락처 신규 등록");
		System.out.println("2. 연락처 전체 보기");
		System.out.println("3. 연락처 검색");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 수정");
		System.out.println("6. 프로그램 종료");
		System.out.println("-------------------------------------");
		System.out.println("메뉴의 번호를 입력해주세요. >>>");
	}

	// 1. 신규 등록 : 새로운 연락처를 입력받아 배열에 저장하는 메소드
	public void insertContact() {
		if (numOfContact < ARRAY_SIZE) {

			System.out.println("연락처 정보 입력을 시작합니다.");

			System.out.println("이름을 입력해주세요.");
			System.out.print("> ");
			String name = scanner.nextLine();

			System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
			System.out.print("> ");
			String phoneNumber = scanner.nextLine();

			System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
			System.out.print("> ");
			String eMail = scanner.nextLine();

			System.out.println("주소를 입력해주세요.");
			System.out.print("> ");
			String address = scanner.nextLine();

			System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
			System.out.print("> ");
			String birthday = scanner.nextLine();

			System.out.println("그룹을 입력해주세요.");
			System.out.print("> ");
			String group = scanner.nextLine();

			array[numOfContact++] = new Contact(name, phoneNumber, eMail, address, birthday, group);
			System.out.println("새로운 연락처를 입력했습니다.");
			
		} else {
			System.out.println("입력 가능한 개수를 초과했습니다.");
		}
	}

	// 2. 연락처 전체 출력
	public void printList() {
		System.out.println("연락처 전체 목록");
		System.out.println("-------------------------------------");
		for (int i = 0; i < numOfContact; i++) {
			array[i].printInfo();
			System.out.println("-------------------------------------");
		}
	}

	// 이름을 통해 해당 이름이 배열의 몇번 인덱스에 있는지 찾는 메소드
	private int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < numOfContact; i++) {
			if (array[i].getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	// 3. 연락처 검색
	public void searchContact() {
		System.out.println("검색할 이름을 입력하세요.");
		String name = scanner.nextLine();
		int index = searchIndex(name);
		if (index != -1) {
			System.out.println("-------------------------------------");
			array[index].printInfo();
			System.out.println("-------------------------------------");
		} else {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}
	}

	// 4. 연락처 삭제
	public void deleteContact() {
		System.out.println("삭제할 이름을 입력하세요.");
		String name = scanner.nextLine();
		int index = searchIndex(name);

		if (index != -1) {
			System.out.println("정말로 삭제하시겠습니까? Y/N");
			String yesNo = scanner.nextLine();
			if (yesNo.equalsIgnoreCase("Y")) {

				for (int i = index; i < numOfContact - 1; i++) {
					array[i] = array[i + 1];
				}
				numOfContact--;
				System.out.println("연락처가 삭제되었습니다.");

			} else {
				System.out.println("연락처 삭제가 취소되었습니다.");
			}
		} else {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}
	}

	// 5. 연락처 수정
	public void updateContact() {
		System.out.println("수정할 이름을 입력하세요.");
		String name = scanner.nextLine();
		int index = searchIndex(name);

		if (index != -1) {

			System.out.println("수정할 전화번호를 입력해주세요. (예. 010-0000-0000)\n수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String phoneNumber = scanner.nextLine();
			if (!phoneNumber.equalsIgnoreCase("X")) {
				array[index].setPhoneNumber(phoneNumber);
			}

			System.out.println("수정할 이메일 주소를 입력해주세요. (예. email@email.com)\n수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String eMail = scanner.nextLine();
			if (!eMail.equalsIgnoreCase("X")) {
				array[index].seteMail(eMail);
			}

			System.out.println("수정할 주소를 입력해주세요.\n수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String address = scanner.nextLine();
			if (!address.equalsIgnoreCase("X")) {
				array[index].setAddress(address);
			}

			System.out.println("수정할 생일을 입력해주세요. (예. 1900-01-01)\n수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String birthday = scanner.nextLine();
			if (!birthday.equalsIgnoreCase("X")) {
				array[index].setBirthday(birthday);
			}

			System.out.println("수정할 그룹을 입력해주세요.\n수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String group = scanner.nextLine();
			if (!group.equalsIgnoreCase("X")) {
				array[index].setGroup(group);
			}

			System.out.println("연락처가 수정되었습니다.");

			System.out.println("-------------------------------------");
			array[index].printInfo();
			System.out.println("-------------------------------------");

		} else {
			System.out.println("입력하신 이름이 존재하지 않습니다.");
		}
	}

//	// 변수값을 바꾸는 setter 메소드를 이용한 정보 수정 메소드
//	public void updateInfo() {
//		System.out.println("정보를 수정합니다.\n");
//		System.out.println("수정할 이름을 입력해주세요.");
//		System.out.print("> ");
//		this.setName(scanner.nextLine());
//		
//		System.out.println("수정할 전화번호를 입력해주세요. (예. 010-0000-0000)");
//		System.out.print("> ");
//		this.setPhoneNumber(scanner.nextLine());
//		
//		System.out.println("수정할 이메일 주소를 입력해주세요. (예. email@email.com)");
//		System.out.print("> ");
//		this.seteMail(scanner.nextLine());
//		
//		System.out.println("수정할 주소를 입력해주세요.");
//		System.out.print("> ");
//		this.setAddress(scanner.nextLine());
//		
//		System.out.println("수정할 생일을 입력해주세요. (예. 1900-01-01)");
//		System.out.print("> ");
//		this.setBirthday(scanner.nextLine());
//		
//		System.out.println("수정할 그룹을 입력해주세요.");
//		System.out.print("> ");
//		this.setGroup(scanner.nextLine());
//	}
}