package viewer;

import controller.BookController;
import controller.OrdersController;
import controller.UserController;
import util.PatternChk;
import util.ScannerUtil;

public class UserViewer {

	PatternChk		 patternChk;
	BookViewer 		 bookViewer;
	OrdersViewer	 ordersViewer;
	UserController   userController;
	BookController   bookController;
	OrdersController ordersController;
	
	public UserViewer() {
		userController   = new UserController();
		bookController   = new BookController();
		ordersController = new OrdersController();
		patternChk		 = new PatternChk();
		bookViewer 		 = new BookViewer();
		ordersViewer	 = new OrdersViewer();
	}
	
	
	
	// 일반회원 메뉴
	public void userMenu() {
		while (logger.LoginUser.loginStatus) {

			showMenu();			//	메뉴보이기

			System.out.print("메뉴를 선택하세요.\n> ");
			int select = ScannerUtil.scanInt();

			switch (select) {
			
			case 1: // 내 정보 확인
					showMyInfo();								
					break;
					
			case 2: // 도서 검색
					bookViewer.showBookMenu();					
					break;
					
			case 3:	// 지난 주문내역
					ordersViewer.viewOrdersByLogInId();
					break;
					
			case 4:	// 랜덤 도서 추천 기능
					bookController.showRandomBook();
					break;
					
			case 5: // 로그아웃 후 이전메뉴로 돌아가기
					System.out.println("로그아웃 후 메인화면으로 돌아갑니다.");
					logger.LoginUser.logOut();
					return;
					
			default:
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}


	
	public void showMenu() {
		System.out.println("============== 비트서점 ==============");
		System.out.println("1. 내 정보 확인");
		System.out.println("2. 도서 검색 및 구매");
		System.out.println("3. 내 주문 내역");
		System.out.println("4. 랜덤 도서 추천");
		System.out.println("5. 로그아웃");
		System.out.println("===================================");
	}


	// 내 정보 확인
	private void showMyInfo() {
		while (logger.LoginUser.loginStatus) {
			userController.showInfo();
			System.out.println("================================");

			System.out.println("1. 정보수정\t 2. 회원탈퇴\t 3. 뒤로가기");
			System.out.print("메뉴를 선택해주세요.\n> ");
			int select = ScannerUtil.scanInt();

			switch (select) {
			case 1: // 정보수정
					updateMyInfo();
					break;
					
			case 2: // 회원탈퇴
					deleteAccount();
					break;
					
			case 3:	// 뒤로가기
					return;
					
			default:
				System.out.println("해당하는 메뉴가 없습니다. 다시 확인해주세요.");
			}
		}
	}

	
	// 정보 수정
	private void updateMyInfo() {
		int logInId = logger.LoginUser.loginId;
		System.out.println("회원정보 수정을 시작합니다.");
		System.out.println("정말로 수정하시겠습니까? 수정하시려면 비밀번호를 입력해주세요.");
		String password = ScannerUtil.getString();

		if (userController.userDao.passwordChk(password)) {
			System.out.print("변경할 비밀번호를 입력하세요.\n> ");
			String newPassword = ScannerUtil.getString();

			System.out.print("변경할 이메일을 입력하세요.\n> ");
			String email = ScannerUtil.getString();
			while (!userController.patternChk.emailForm(email)) {
				System.out.println("올바른 이메일 형식으로 입력하세요.");
				System.out.print("변경할 이메일을 입력하세요.\n> ");
				email = ScannerUtil.getString();
			}

			System.out.print("변경할 전화번호를 입력하세요.\n> ");
			String phnum = ScannerUtil.getString();
			while (!userController.patternChk.phnumForm(phnum)) {
				System.out.println("올바른 전화번호 형식으로 입력하세요.");
				System.out.print("변경할 전화번호를 입력하세요.\n> ");
				phnum = ScannerUtil.getString();
			}

			System.out.print("변경할 주소를 입력하세요.\n> ");
			String address = ScannerUtil.getString();

			userController.updateInfo(newPassword, email, phnum, address, logInId);
			System.out.println("회원정보가 수정되었습니다.");

		} else {
			System.out.println("회원정보 수정을 취소하였습니다.");
		}
	}

	
	// 회원 탈퇴
	private void deleteAccount() {
		System.out.println("정말로 탈퇴하시겠습니까? Y/N");
		String yesNo = ScannerUtil.getString();

		if (yesNo.equalsIgnoreCase("Y")) {
			System.out.println("탈퇴하시려면 비밀번호를 입력해주세요.");
			String password = ScannerUtil.getString();

			userController.deleteUser(password);
			
		} else {
			System.out.println("회원 탈퇴가 취소되었습니다.");
		}
	}


}
