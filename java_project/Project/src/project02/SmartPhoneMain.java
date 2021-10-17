package project02;

// 2. main()메소드를 아래의 요구조건을 정의해봅니다.
// ① SmartPhone 클래스의 인스턴스를 생성합니다.
// ② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
// ③ 10번 반복해서 배열에 추가합니다.
// ④ 배열의 모든 요소를 출력합니다.
// ⑤ 배열의 모든 요소를 검색합니다.
// ⑥ 배열의 요소를 삭제해 봅시다.
// ⑦ 배열의 요소를 수정해 봅시다.

public class SmartPhoneMain {
	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone();
		
		while(true) {
			
			phone.showMenu();
			
			int select = Integer.parseInt(phone.scanner.nextLine());
			
			switch(select) {
			case 1: 
				phone.insertContact();	// 입력
				break;
			case 2: 
				phone.printList();		// 모든 요소 출력
				break;
			case 3:
				phone.searchContact(); 	// 요소 검색
				break;
			case 4:
				phone.deleteContact();	// 요소 삭제
				break;
			case 5:
				phone.updateContact();	// 요소 수정
				break;
			case 6: 
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
		
	}
}
