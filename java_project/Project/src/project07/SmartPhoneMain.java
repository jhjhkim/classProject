package project07;

public class SmartPhoneMain {

	public static void main(String[] args) {

		//SmartPhoneUsedList phone = new SmartPhoneUsedList();
		//SmartPhoneUsedSet phone = new SmartPhoneUsedSet();
		SmartPhoneUsedMap phone = new SmartPhoneUsedMap();

		while (true) {

			System.out.println("=======================");
			System.out.println("연락처 관리 프로그램");
			System.out.println("=======================");
			System.out.println(" 1. 회사 연락처 등록");
			System.out.println(" 2. 거래처 연락처 등록");
			System.out.println(" 3. 연락처 목록 간략 보기");
			System.out.println(" 4. 연락처 목록 펼쳐 보기");
			System.out.println(" 5. 연락처 검색");
			System.out.println(" 6. 연락처 삭제");
			System.out.println(" 7. 연락처 수정");
			System.out.println(" 8. 프로그램 종료");
			System.out.println("=======================");
			System.out.println("메뉴를 입력하세요.");
			System.out.print("> ");

			// 메뉴 입력시 발생할 수 있는 예외 처리
			try {
				//int select = Integer.parseInt(SmartPhoneUsedList.sc.nextLine());
				//int select = Integer.parseInt(SmartPhoneUsedSet.sc.nextLine());
				int select = Integer.parseInt(SmartPhoneUsedMap.sc.nextLine());
				
				switch (select) {
				case 1:
				case 2:
					phone.addContact(select);
					break;
				case 3:
					phone.showBasicList();
					break;
				case 4:
					phone.showAllList();
					break;
				case 5:
					phone.searchContact();
					break;
				case 6:
					phone.deleteContact();
					break;
				case 7:
					phone.updateContact();
					break;
				case 8:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default:
					System.out.println("해당하는 메뉴가 없습니다. 다시 입력해주세요.");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하셔야 합니다. 메뉴 번호를 다시 입력해주세요.");
			}
		}
	}

}
