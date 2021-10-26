package chapter12.notepad;

import java.io.IOException;

public class NoteMain {

	public static void main(String[] args) throws IOException {
		
		NoteManager manager = new NoteManager();
		
		while(true) {
			
			System.out.println("==================================");
			System.out.println("\tjava 메모장 프로그램");
			System.out.println("==================================");
			System.out.println(" 1. 메모 작성");
			System.out.println(" 2. 메모 리스트 보기");
			System.out.println(" 3. 개별 메모 읽기");
			System.out.println(" 4. 종료");
			System.out.println("==================================");
			System.out.print("메뉴를 선택하세요.\n>>> ");
			
			int select = Integer.parseInt(manager.sc.nextLine());
			
			switch(select) {
			case 1:
				// 메모 작성
				manager.insertNote();
				break;
			case 2: 
				// 메모리스트 보기
				manager.printList();
				break;
			case 3:
				// 개별 메모 보기
				manager.printOne();				
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
			}
			
		}
		
	}
	
}
