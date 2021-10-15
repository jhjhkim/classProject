package project01;

public class SmartPhoneMain {
	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone();
		
		while(true) {
			
			phone.showMenu();
			
			int select = Integer.parseInt(phone.scanner.nextLine());
			
			switch(select) {
			case 1: 
				phone.insert();
				break;
			case 2: 
				phone.printList();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6: 
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}
		
	}
}
