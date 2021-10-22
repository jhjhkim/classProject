package project05.first;

import java.util.Scanner;

// 3.SmartPhone 클래스의 배열을 다형성의 특징을 이용해서 
// 상위 타입의 배열을 생성해서 하위 클래스의 인스턴스를 저장하는 형태로 프로그램을 작성해봅시다.
public class SmartPhone {

	Contact[] array;
	int numOfContact;
	final static int ARRAY_SIZE = 10; // 기본 배열 길이
	public static Scanner sc = new Scanner(System.in);

	// 배열의 길이를 파라미터로 갖는 생성자
	public SmartPhone(int size) {
		array = new Contact[size];
		numOfContact = 0;
	}

	// 기본 생성자
	public SmartPhone() {
		this(ARRAY_SIZE);
	}

	// 연락처를 배열에 추가하는 메소드
	public void add(Contact c) {
		array[numOfContact++] = c;
	}

	// 메시지를 출력하여 String값을 입력받고 공백이 입력되면 다시 입력받는 메소드
	public String inputCheck(String message) {
		System.out.println(message);
		System.out.print("> ");
		String result = sc.nextLine();

		while (result.isEmpty()) {
			System.out.println("내용이 입력되지 않았습니다. 다시 입력해주세요.");
			System.out.println(message);
			System.out.print("> ");
			result = sc.nextLine();
		}

		return result;
	}

	// 파라미터로 들어온 전화번호가 배열에 이미 저장된 전화번호이면 true를 리턴하는 메소드
	public boolean checkPhone(String phoneNumber) {
		boolean result = false;

		for (int i = 0; i < numOfContact; i++) {
			if (array[i].getPhoneNumber().equals(phoneNumber)) {
				result = true;
				break;
			}
		}

		return result;
	}

	// 연락처 등록 메소드
	public void addContact() {

		if (numOfContact < ARRAY_SIZE) {

			System.out.println("연락처 정보 입력을 시작합니다.");

			System.out.println("1. 회사 연락처 입력 2. 거래처 연락처 입력");
			System.out.print("> ");
			int select = Integer.parseInt(sc.nextLine());
			while (!(select == 1 || select == 2)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("1. 회사 연락처 입력 2. 거래처 연락처 입력");
				System.out.print("> ");
				select = Integer.parseInt(sc.nextLine());
			}

			String message = "이름을 입력해주세요.";
			String name = inputCheck(message);

			message = "전화번호를 입력해주세요. (예. 010-0000-0000)";
			String phoneNumber = inputCheck(message);
			while (checkPhone(phoneNumber)) {
				System.out.println("이미 등록된 전화번호입니다.");
				message = "전화번호를 다시 입력해주세요. 첫화면으로 돌아가려면 X를 입력하세요.";
				phoneNumber = inputCheck(message);
			}

			if (phoneNumber.equalsIgnoreCase("X")) {
				// 첫화면으로 돌아가기
				System.out.println("입력을 중단하고 첫 화면으로 돌아갑니다.");
				
			} else {
				message = "이메일 주소를 입력해주세요. (예. email@email.com)";
				String eMail = inputCheck(message);

				message = "주소를 입력해주세요.";
				String address = inputCheck(message);

				message = "생일을 입력해주세요. (예. 1900-01-01)";
				String birthday = inputCheck(message);

				if (select == 1) {
					// 회사 연락처 저장
					String group = "회사";

					message = "회사 이름을 입력해주세요.";
					String company = inputCheck(message);

					message = "부서 이름을 입력해주세요.";
					String team = inputCheck(message);

					message = "직급을 입력해주세요.";
					String rank = inputCheck(message);

					add(new CompanyContact(name, phoneNumber, eMail, address, birthday, group, company, team, rank));

				} else if (select == 2) {
					// 거래처 연락처 저장
					String group = "거래처";

					message = "거래처 이름을 입력해주세요.";
					String customerName = inputCheck(message);

					message = "거래품목을 입력해주세요.";
					String item = inputCheck(message);

					message = "직급을 입력해주세요.";
					String rank = inputCheck(message);

					add(new CustomerContact(name, phoneNumber, eMail, address, birthday, group, customerName, item,
							rank));

				}

				System.out.println("새로운 연락처를 입력했습니다.");
			}
		} else {
			System.out.println("입력 가능한 개수를 초과했습니다. 최대 " + ARRAY_SIZE + "개의 연락처를 등록할 수 있습니다.");
		}
	}

	// 목록 보기
	public void showList() {
		System.out.println("-----------------------");
		for (int i = 0; i < numOfContact; i++) {
			array[i].showBasicInfo();
			System.out.println("-----------------------");
		}
	}

	// 이름으로 배열의 index 찾는 메소드
	public int searchIndex(String name) {
		for (int i = 0; i < numOfContact; i++) {
			if (array[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	// 연락처 검색
	public void searchContact() {
		String message = "검색할 이름을 입력하세요.";
		String name = inputCheck(message);
		int index = searchIndex(name);

		if (index != -1) {
			array[index].showData();
		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
	}

	// 연락처 삭제
	public void deleteContact() {
		String message = "삭제할 이름을 입력하세요.";
		String name = inputCheck(message);
		int index = searchIndex(name);

		if (index != -1) {

			message = "정말로 삭제하시겠습니까? Y/N";
			String yesNo = inputCheck(message);
			if (yesNo.equalsIgnoreCase("Y")) {

				for (int i = index; i < numOfContact - 1; i++) {
					array[i] = array[i + 1];
				}

				numOfContact--;
				System.out.println("연락처가 삭제되었습니다.");

			} else {
				System.out.println("연락처 삭제를 취소합니다.");
			}

		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
	}

	// 연락처 수정
	public void updateContact() {
		String message = "수정할 이름을 입력하세요.";
		String name = inputCheck(message);
		int index = searchIndex(name);

		if (index != -1) {

			message = "수정할 전화번호를 입력해주세요. (예. 010-0000-0000) 수정하지 않으려면 X를 입력하세요.";
			String temp = inputCheck(message);
			if (!temp.equalsIgnoreCase("X")) {
				array[index].setPhoneNumber(temp);
			}

			message = "수정할 이메일 주소를 입력해주세요. (예. email@email.com) 수정하지 않으려면 X를 입력하세요.";
			temp = inputCheck(message);
			if (!temp.equalsIgnoreCase("X")) {
				array[index].seteMail(temp);
			}

			message = "수정할 주소를 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
			temp = inputCheck(message);
			if (!temp.equalsIgnoreCase("X")) {
				array[index].setAddress(temp);
			}

			message = "수정할 생일을 입력해주세요. (예. 1900-01-01) 수정하지 않으려면 X를 입력하세요.";
			temp = inputCheck(message);
			if (!temp.equalsIgnoreCase("X")) {
				array[index].setBirthday(temp);
			}

			if (array[index] instanceof CompanyContact) {

				message = "수정할 회사이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CompanyContact) array[index]).setCompany(temp);
				}

				message = "수정할 부서이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CompanyContact) array[index]).setTeam(temp);
				}

				message = "수정할 직급을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CompanyContact) array[index]).setRank(temp);
				}

			} else if (array[index] instanceof CustomerContact) {

				message = "수정할 거래처 이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CustomerContact) array[index]).setCustomerName(temp);
				}

				message = "수정할 거래품목을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CustomerContact) array[index]).setItem(temp);
				}

				message = "수정할 직급을 입력해주세요. 수정하지 않으려면 X를 입력하세요.";
				temp = inputCheck(message);
				if (!temp.equalsIgnoreCase("X")) {
					((CustomerContact) array[index]).setRank(temp);
				}

			}

			System.out.println("연락처가 수정되었습니다.");

		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}

	}

}
