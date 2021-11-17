package main;

import util.ScannerUtil;
import viewer.MainViewer;
public class BookMain {

	
	public static void main(String[] args) {
		
		MainViewer mainViewer = new MainViewer();
			
		while(true) {

			System.out.println("1. 로그인 \n2. 회원가입\n3. 프로그램 종료");
			System.out.println("번호를 입력해주세요.");
			
			int userChoice = ScannerUtil.scanInt();
			
			switch (userChoice) {
			
			case 1: // 로그인
				mainViewer.showLogin();
				break;

			case 2:	// 회원가입
				mainViewer.showJoinForm();
				break;
				
			case 3:	// 종료
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
			default:
				System.out.println("선택한 메뉴번호가 존재하지 않습니다.");
			}
			
		}
		
	}
}
