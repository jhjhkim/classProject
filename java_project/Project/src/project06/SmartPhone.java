package project06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {

	Contact[] contacts;
	int numOfContact;
	final static int CONTACTS_SIZE = 10; // 기본 배열 길이
	public static Scanner sc = new Scanner(System.in);

	// 배열의 길이를 파라미터로 갖는 생성자
	public SmartPhone(int size) {
		contacts = new Contact[size];
		numOfContact = 0;
	}

	// 기본 생성자
	public SmartPhone() {
		this(CONTACTS_SIZE);
	}

	// 연락처 배열에 넣는 메소드
	public void add(Contact c) {
		contacts[numOfContact++] = c;
	}

	// String값을 입력받고 공백이 입력되면 다시 입력받는 메소드
	public String getString() {
		String result = null;

		while (true) {
			result = sc.nextLine();
			result = result.trim();

			if (result.isEmpty()) {
				System.out.println("내용이 입력되지 않았습니다. 다시 입력해주세요.");
				System.out.print("> ");
			} else {
				break;
			}
		}

		return result;
	}

	// 연락처 이름 입력 시에 공백에 대한 예외처리와 영문자와 한글만 허용하는 예외 처리를 해봅시다.
	public String getName() {
		String result = null;

		while (true) {
			result = sc.nextLine().trim();
			if (result.isEmpty()) {
				BadNameInputException bne = new BadNameInputException("공백은 입력할 수 없습니다.");
				try {
					throw bne;
				} catch (BadNameInputException e) {
					System.out.println(e.getMessage());
					System.out.print("다시 입력해주세요.\n> ");
				}
			} else {

				boolean nameChk = false;

				for (int i = 0; i < result.length(); i++) {
					char c = result.charAt(i);
					if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '가' && c <= '힣')) {
						// c가 영문소문자, 영문대문자, 한글 중 하나가 아닐 때 -> 예외처리
						nameChk = true;
						BadNameInputException bne = new BadNameInputException();

						try {
							throw bne;
						} catch (BadNameInputException e) {
							System.out.println(e.getMessage());
							System.out.print("다시 입력해주세요.\n> ");
							break; // 예외가 발생하면 예외 처리 후 검사를 위한 for문의 반복을 멈춘다.
						}
					}
				}

				if (!nameChk) {
					break; // 양식에 맞는 이름이라면 while(true) 반복을 멈추고 리턴한다.
				}

			}
		}
		return result;
	}

	// 파라미터로 들어온 전화번호가 배열에 이미 저장된 전화번호이면 true를 리턴하는 메소드
	public boolean checkPhone(String phoneNumber) {
		boolean result = false;

		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
				result = true;
				break;
			}
		}

		return result;
	}

	// 전화번호 형식에 맞지 않을 때 예외처리를 하고 중복될 때 예외 상황이 발생하도록 하고 예외 처리를 합시다.
	public String checkPhone() {
		String number = null;

		while (true) {
			number = sc.nextLine().trim();
			boolean checkNumber = false; // 중복된 전화번호가 있는지 여부를 저장하는 변수

			if (number.isEmpty()) {
				// 공백 입력시
				System.out.print("공백은 입력할 수 없습니다.\n다시 입력해주세요.\n> ");
			} else {

				try {
					String pattern = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}";
					boolean regex = Pattern.matches(pattern, number); // 입력한 번호가 양식에 맞는지 확인

					if (!regex) {
						throw new BadPhoneNumberException();
					}

					for (int i = 0; i < numOfContact; i++) {
						if (contacts[i].getPhoneNumber().equals(number)) {
							throw new BadPhoneNumberException("이미 등록된 전화번호입니다.");
						}
					}
				} catch (BadPhoneNumberException e) {
					System.out.println(e.getMessage());
					System.out.print("다시 입력해주세요.\n> ");
					checkNumber = true;
				}

				if (!checkNumber) {
					break;
				}

			}

		}

		return number;
	}

	// 연락처 등록 메소드
	public void addContact(int select) {

		if (numOfContact < CONTACTS_SIZE) {

			System.out.println("연락처 정보 입력을 시작합니다.");

			System.out.println("이름을 입력해주세요.");
			System.out.print("> ");
			String name = getName();

			System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
			System.out.print("> ");
			String phoneNumber = checkPhone();

			System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
			System.out.print("> ");
			String eMail = getString();

			System.out.println("주소를 입력해주세요.");
			System.out.print("> ");
			String address = getString();

			System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
			System.out.print("> ");
			String birthday = getString();

			if (select == 1) {
				// 회사 연락처 저장
				String group = "회사";

				System.out.println("회사 이름을 입력해주세요.");
				System.out.print("> ");
				String companyName = getString();

				System.out.println("부서 이름을 입력해주세요.");
				System.out.print("> ");
				String teamName = getString();

				System.out.println("직급을 입력해주세요.");
				System.out.print("> ");
				String job = getString();

				add(new CompanyContact(name, phoneNumber, eMail, address, birthday, group, companyName, teamName, job));

			} else if (select == 2) {
				// 거래처 연락처 저장
				String group = "거래처";

				System.out.println("거래처 이름을 입력해주세요.");
				System.out.print("> ");
				String customerName = getString();

				System.out.println("거래품목을 입력해주세요.");
				System.out.print("> ");
				String item = getString();

				System.out.println("직급을 입력해주세요.");
				System.out.print("> ");
				String job = getString();

				add(new CustomerContact(name, phoneNumber, eMail, address, birthday, group, customerName, item, job));

			}

			System.out.println("새로운 연락처를 입력했습니다.");

		} else {
			System.out.println("입력 가능한 개수를 초과했습니다. 최대 " + CONTACTS_SIZE + "개의 연락처를 등록할 수 있습니다.");
		}
	}

	// 목록 간략히 보기
	public void showBasicList() {
		System.out.println("간략한 목록을 출력합니다. (총 " + numOfContact + "명)");
		System.out.println("-----------------------");
		for (int i = 0; i < numOfContact; i++) {
			contacts[i].showBasicData();
			System.out.println("-----------------------");
		}
	}

	// 목록 자세히 보기
	public void showAllList() {
		System.out.println("자세한 목록을 출력합니다. (총 " + numOfContact + "명)");
		System.out.println("-----------------------");
		for (int i = 0; i < numOfContact; i++) {
			contacts[i].showData();
			System.out.println("-----------------------");
		}
	}

	// 이름으로 배열의 index 찾는 메소드
	public int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	// 연락처 검색
	public void searchContact() {
		System.out.println("검색할 이름을 입력하세요.");
		System.out.print("> ");
		String name = getName();
		int index = searchIndex(name);

		if (index != -1) {
			contacts[index].showData();
		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
	}

	// 연락처 삭제
	public void deleteContact() {
		System.out.println("삭제할 이름을 입력하세요.");
		System.out.print("> ");
		String name = getName();
		int index = searchIndex(name);

		if (index != -1) {

			System.out.println(name + "의 정보를 정말로 삭제하시겠습니까? Y/N");
			String yesNo = getString();
			if (yesNo.equalsIgnoreCase("Y")) {

				for (int i = index; i < numOfContact - 1; i++) {
					contacts[i] = contacts[i + 1];
				}

				numOfContact--;
				System.out.println(name + "의 정보가 삭제되었습니다.");

			} else {
				System.out.println("연락처 삭제를 취소합니다.");
			}

		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
	}

	// 연락처 수정
	public void updateContact() {
		System.out.println("수정할 이름을 입력하세요.");
		System.out.print("> ");
		String name = getName();
		int index = searchIndex(name);

		if (index != -1) {
			System.out.println(name + "의 정보를 수정합니다.");
			
			System.out.println("수정할 전화번호를 입력해주세요. (예. 010-0000-0000)");
			System.out.print("> ");
			String phoneNumber = getString();

			System.out.println("수정할 이메일 주소를 입력해주세요. (예. email@email.com)");
			System.out.print("> ");
			String eMail = getString();

			System.out.println("수정할 주소를 입력해주세요.");
			System.out.print("> ");
			String address = getString();

			System.out.println("수정할 생일을 입력해주세요. (예. 1900-01-01)");
			System.out.print("> ");
			String birthday = getString();

			if (contacts[index] instanceof CompanyContact) {

				System.out.println("수정할 회사이름을 입력해주세요.");
				System.out.print("> ");
				String companyName = getString();

				System.out.println("수정할 부서이름을 입력해주세요.");
				System.out.print("> ");
				String teamName = getString();

				System.out.println("수정할 직급을 입력해주세요.");
				System.out.print("> ");
				String job = getString();
				
				CompanyContact contact = (CompanyContact)contacts[index];
				
				contact.setPhoneNumber(phoneNumber);
				contact.seteMail(eMail);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setCompanyName(companyName);
				contact.setTeamName(teamName);
				contact.setJob(job);

			} else if (contacts[index] instanceof CustomerContact) {

				System.out.println("수정할 거래처 이름을 입력해주세요.");
				System.out.print("> ");
				String customerName = getString();

				System.out.println("수정할 거래품목을 입력해주세요.");
				System.out.print("> ");
				String item = getString();

				System.out.println("수정할 직급을 입력해주세요.");
				System.out.print("> ");
				String job = getString();

				CustomerContact contact = (CustomerContact)contacts[index];
				
				contact.setPhoneNumber(phoneNumber);
				contact.seteMail(eMail);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setCustomerName(customerName);
				contact.setItem(item);
				contact.setJob(job);
			}

			System.out.println(name + "의 정보가 수정되었습니다.");

		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}

	}

}
