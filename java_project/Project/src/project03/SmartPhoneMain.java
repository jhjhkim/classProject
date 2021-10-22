package project03;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone phone = new SmartPhone();

		while (true) {

			System.out.println("=======================");
			System.out.println("연락처 관리 프로그램");
			System.out.println("=======================");
			System.out.println(" 1. 회사 연락처 등록");
			System.out.println(" 2. 거래처 연락처 등록");
			System.out.println(" 3. 연락처 목록 보기");
			System.out.println(" 4. 연락처 검색");
			System.out.println(" 5. 연락처 삭제");
			System.out.println(" 6. 연락처 수정");
			System.out.println(" 7. 프로그램 종료");
			System.out.println("=======================");
			System.out.println("메뉴를 입력하세요.");
			System.out.print("> ");

			int select = Integer.parseInt(SmartPhone.sc.nextLine());

			switch (select) {
			case 1:
			case 2:
				phone.addContact(select);
				break;
			case 3:
				phone.showList();
				break;
			case 4:
				phone.searchContact();
				break;
			case 5:
				phone.deleteContact();
				break;
			case 6:
				phone.updateContact();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

}
