package project06;

import java.util.InputMismatchException;

public class SmartPhoneMain {

	public static void main(String[] args) throws BadInputException {

		SmartPhone phone = new SmartPhone();
		int select = 0;
		while (true) {

			System.out.println("=======================");
			System.out.println("연락처 관리 프로그램");
			System.out.println(" 1. 연락처 입력");
			System.out.println(" 2. 연락처 검색");
			System.out.println(" 3. 연락처 수정");
			System.out.println(" 4. 연락처 삭제");
			System.out.println(" 5. 연락처 전체 리스트 보기");
			System.out.println(" 6. 종료");
			System.out.println("=======================");
			
			try {
				select = getSelect(phone);
			} catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch(BadInputException e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			switch (select) {
			case 1:
				phone.addContact();
				break;
			case 2:
				phone.searchContact();
				break;
			case 3:
				phone.updateContact();
				break;
			case 4:
				phone.deleteContact();
				break;
			case 5:
				phone.showList();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;

			}
		}
		
	}
	
	public static int getSelect(SmartPhone phone) throws BadInputException {
		int select = 0;
		select = Integer.parseInt(phone.inputCheck("메뉴를 입력하세요."));
		
		if(!(select >= 1 && select <= 7)) {
			BadInputException e = new BadInputException();
			throw e;
		}
		
		return select;
	}

}
