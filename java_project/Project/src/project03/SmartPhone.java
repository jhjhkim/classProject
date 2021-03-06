package project03;

import java.util.Scanner;

// 3.SmartPhone 클래스의 배열을 다형성의 특징을 이용해서 
// 상위 타입의 배열을 생성해서 하위 클래스의 인스턴스를 저장하는 형태로 프로그램을 작성해봅시다.
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
	
	// 연락처 등록 메소드
	public void addContact(int select) {

		if (numOfContact < CONTACTS_SIZE) {

			System.out.println("연락처 정보 입력을 시작합니다.");

			System.out.println("이름을 입력해주세요.");
			System.out.print("> ");
			String name = sc.nextLine();

			System.out.println("전화번호를 입력해주세요. (예. 010-0000-0000)");
			System.out.print("> ");
			String phoneNumber = sc.nextLine();

			System.out.println("이메일 주소를 입력해주세요. (예. email@email.com)");
			System.out.print("> ");
			String eMail = sc.nextLine();

			System.out.println("주소를 입력해주세요.");
			System.out.print("> ");
			String address = sc.nextLine();

			System.out.println("생일을 입력해주세요. (예. 1900-01-01)");
			System.out.print("> ");
			String birthday = sc.nextLine();
			
			if(select == 1) {	
				// 회사 연락처 저장
				String group = "회사";				
				
				System.out.println("회사 이름을 입력해주세요.");
				System.out.print("> ");
				String companyName = sc.nextLine();
				
				System.out.println("부서 이름을 입력해주세요.");
				System.out.print("> ");
				String teamName = sc.nextLine();
				
				System.out.println("직급을 입력해주세요.");
				System.out.print("> ");
				String job = sc.nextLine();
				
				add(new CompanyContact(name, phoneNumber, eMail, address, birthday, group, companyName, teamName, job));

			} else if(select == 2) {	
				// 거래처 연락처 저장
				String group = "거래처";
				
				System.out.println("거래처 이름을 입력해주세요.");
				System.out.print("> ");
				String customerName = sc.nextLine();
				
				System.out.println("거래품목을 입력해주세요.");
				System.out.print("> ");
				String item = sc.nextLine();
				
				System.out.println("직급을 입력해주세요.");
				System.out.print("> ");
				String job = sc.nextLine();
				
				add(new CustomerContact(name, phoneNumber, eMail, address, birthday, group, customerName, item, job));

			}
			
			System.out.println("새로운 연락처를 입력했습니다.");
			
		} else {
			System.out.println("입력 가능한 개수를 초과했습니다. 최대 " + CONTACTS_SIZE + "개의 연락처를 등록할 수 있습니다.");
		}
	}
	
	// 목록 보기
	public void showList() {
		System.out.println("-----------------------");
		for(int i = 0; i < numOfContact; i++) {
			contacts[i].showBasicInfo();
			System.out.println("-----------------------");
		}
	}
	
	// 이름으로 배열의 index 찾는 메소드
	public int searchIndex(String name) {
		for(int i = 0; i < numOfContact; i++) {
			if(contacts[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	// 연락처 검색
	public void searchContact() {
		System.out.println("검색할 이름을 입력하세요.");
		System.out.print("> ");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index != -1) {
			contacts[index].showInfo();
		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
	}
	
	// 연락처 삭제
	public void deleteContact() {
		System.out.println("삭제할 이름을 입력하세요.");
		System.out.print("> ");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index != -1) {
			
			System.out.println("정말로 삭제하시겠습니까? Y/N");
			String yesNo = sc.nextLine();
			if(yesNo.equalsIgnoreCase("Y")) {
			
			for(int i = index; i < numOfContact-1; i++) {
				contacts[i] = contacts[i+1];
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
		System.out.println("수정할 이름을 입력하세요.");
		System.out.print("> ");
		String name = sc.nextLine();
		int index = searchIndex(name);
		
		if(index != -1) {
			
			System.out.println("수정할 전화번호를 입력해주세요. (예. 010-0000-0000) 수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			String temp = sc.nextLine();
			if(!temp.equalsIgnoreCase("X")) {
				contacts[index].setPhoneNumber(temp);
			}

			System.out.println("수정할 이메일 주소를 입력해주세요. (예. email@email.com) 수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			temp = sc.nextLine();
			if(!temp.equalsIgnoreCase("X")) {
				contacts[index].seteMail(temp);
			}

			System.out.println("수정할 주소를 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			temp = sc.nextLine();
			if(!temp.equalsIgnoreCase("X")) {
				contacts[index].setAddress(temp);
			}

			System.out.println("수정할 생일을 입력해주세요. (예. 1900-01-01) 수정하지 않으려면 X를 입력하세요.");
			System.out.print("> ");
			temp = sc.nextLine();
			if(!temp.equalsIgnoreCase("X")) {
				contacts[index].setBirthday(temp);
			}
			
			if(contacts[index] instanceof CompanyContact) {
				
				System.out.println("수정할 회사이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CompanyContact)contacts[index]).setCompanyName(temp);
				}
				
				System.out.println("수정할 부서이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CompanyContact)contacts[index]).setTeamName(temp);
				}
				
				System.out.println("수정할 직급을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CompanyContact)contacts[index]).setJob(temp);
				}
				
			} else if(contacts[index] instanceof CustomerContact) {
				
				System.out.println("수정할 거래처 이름을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CustomerContact)contacts[index]).setCustomerName(temp);
				}
				
				System.out.println("수정할 거래품목을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CustomerContact)contacts[index]).setItem(temp);
				}
				
				System.out.println("수정할 직급을 입력해주세요. 수정하지 않으려면 X를 입력하세요.");
				System.out.print("> ");
				temp = sc.nextLine();
				if(!temp.equalsIgnoreCase("X")) {
					((CustomerContact)contacts[index]).setJob(temp);
				}
				
			}
			
			System.out.println("연락처가 수정되었습니다.");
			
		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
		
	}
	
}
