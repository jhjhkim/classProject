package viewer;

import controller.BookController;
import controller.OrdersController;
import object.Book;
import util.BookPatternChk;
import util.PatternChk;
import util.ScannerUtil;

public class AdminViewer {

	BookController bookController;
	OrdersController ordersController;
	PatternChk patternChk;
	BookPatternChk bookChk;

	public AdminViewer() {
		bookController = new BookController();
		ordersController = new OrdersController();
		patternChk = new PatternChk();
		bookChk = new BookPatternChk();
	}

	public void adminMenu() {
		while (logger.LoginUser.loginStatus) {

			showAdminMenu(); // 관리자 메뉴 출력

			System.out.print("메뉴를 선택하세요.\n> ");
			int select = ScannerUtil.scanInt();

			switch (select) {

			case 1:
				showAddBookMenu(); // 신규도서 등록 메뉴
				break;

			case 2:
				showBookAdmin(); // 기존도서 관리
				break;

			case 3:
				viewOrders(); // 매출현황
				break;

			case 4:
				System.out.println("로그아웃되었습니다. 메인화면으로 돌아갑니다.");
				logger.LoginUser.logOut();
				return;

			default:
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}

	public void viewOrders() {

		if (ordersController.ordersChk()) {

			while (true) {
				System.out.println("============== 매출 현황 ==============");
				System.out.println("1. 전체 매출 목록");
				System.out.println("2. 일별 매출");
				System.out.println("3. 월별 매출");
				System.out.println("4. 이전 메뉴");
				System.out.println("===================================");
				System.out.print("메뉴를 선택하세요.\n> ");

				int select = ScannerUtil.scanInt();

				switch (select) {

				case 1: // 전체 목록
					ordersController.viewAllOrders();
					break;

				case 2: // 일별 매출
					viewDailyOrders();
					break;

				case 3: // 월별 매출
					viewMonthlyOrders();
					break;
				case 4: // 메뉴 종료
					System.out.println("이전 메뉴로 돌아갑니다.");
					return;
				default:
					System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
				}
			}
		} else {
			System.out.println("아직 매출내역이 없습니다.");
		}
	}

	// 월별 매출 보기 메소드
	private void viewMonthlyOrders() {
		ordersController.viewOrderMonth();

		System.out.println("자세히 보고 싶은 연월을 입력하세요. (예: 202101)");
		System.out.print("> ");
		String orderMonth = ScannerUtil.getString();

		while (!patternChk.orderMonthForm(orderMonth)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 202101)");
			System.out.print("> ");
			orderMonth = ScannerUtil.getString();
		}

		ordersController.viewMonthlyOrders(orderMonth);
	}

	// 일별 매출 보기 메소드
	private void viewDailyOrders() {
		ordersController.viewOrderdate();

		System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 20210101)");
		System.out.print("> ");
		String orderdate = ScannerUtil.getString();

		while (!patternChk.orderdateForm(orderdate)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 20210101)");
			System.out.print("> ");
			orderdate = ScannerUtil.getString();
		}

		ordersController.viewDailyOrders(orderdate);
	}

	// 기존 도서 관리
	private void showBookAdmin() {
		while (true) {
			System.out.println("===================================");
			System.out.println("1. 도서 목록 보기");
			System.out.println("2. 도서 검색(제목으로)");
			System.out.println("3. 뒤로가기");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");

			int select = ScannerUtil.scanInt();

			switch (select) {
			// 도서 목록 보기
			case 1:

				// 전체 리스트 보기 메소드
				bookController.showAll();
				System.out.println("1.수정 2.삭제 3.뒤로가기");

				int userChoice = ScannerUtil.scanInt();

				// 수정과 삭제 메뉴
				if (userChoice == 1) {

					System.out.println("수정할 도서의 일련번호를 입력해 주세요.");
					System.out.print("> ");
					int bookId = ScannerUtil.scanInt();

					updateBook(bookId);

					break;
				} else if (userChoice == 2) {
					// 삭제 메소드
					System.out.println("삭제하시려는 도서의 일련번호를 입력해 주세요.");
					System.out.print("> ");
					int bookid = ScannerUtil.scanInt();

					bookController.deleteBook(bookid);
					break;
				} else if (userChoice == 3) {
					break;
				}

				// 도서 검색(제목으로)
			case 2:
				System.out.println("도서 제목의 키워드를 입력해 주세요.");
				System.out.println("> ");
				String bookName = ScannerUtil.scanString();

				bookController.selectByName(bookName);

				System.out.println("1.수정 2.삭제 3.뒤로가기");

				userChoice = ScannerUtil.scanInt();

				// 수정과 삭제 메뉴
				if (userChoice == 1) {
					System.out.println("수정할 도서의 일련번호를 입력해 주세요.");
					System.out.println("> ");
					int bookId = ScannerUtil.scanInt();

					updateBook(bookId);

					break;
				} else if (userChoice == 2) {
					// 삭제 메소드
					System.out.println("삭제하시려는 도서의 일련번호를 입력해 주세요.");
					System.out.println("> ");
					int bookid = ScannerUtil.scanInt();

					bookController.deleteBook(bookid);
					break;
				} else if (userChoice == 3) {
					break;
				}
				
			case 3:
				return;

			}

		}
	}

	private void showAddBookMenu() {

		System.out.println("\n도서의 제목을 입력해 주세요.");
		System.out.println("도서 제목은 최대 20글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String bookName = ScannerUtil.getString();

		while (!bookChk.bookNameForm(bookName)) {
			System.out.println("도서 제목이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			bookName = ScannerUtil.getString();
		}

		System.out.println("\n도서의 가격을 입력해 주세요.");
		System.out.print("> ");
		int price = ScannerUtil.scanInt();

		System.out.println("\n도서의 저자를 입력해 주세요.");
		System.out.println("영문, 한글, '.,' 만 입력 가능하며 최대 12글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String writer = ScannerUtil.getString();

		while (!bookChk.writerForm(writer)) {
			System.out.println("저자가 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			writer = ScannerUtil.getString();
		}

		System.out.println("\n도서의 카테고리를 입력해 주세요.\n1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.print("> ");
		int category = ScannerUtil.scanInt();

		System.out.println("\n도서의 출판사를 입력해 주세요.");
		System.out.println("영문, 한글, 숫자, '&' 만 입력 가능하며 최대 10글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String publisher = ScannerUtil.getString();

		while (!bookChk.publisherForm(publisher)) {
			System.out.println("출판사명이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			publisher = ScannerUtil.getString();
		}

		System.out.println("\n도서의 수량을 입력해 주세요.");
		System.out.print("> ");
		int stock = ScannerUtil.scanInt();

		bookController.insertBook(new Book(bookName, price, writer, publisher, category, stock));

	}

	public void updateBook(int bookId) {
		System.out.println("도서 정보 수정을 시작합니다.");

		System.out.println("\n도서의 제목을 입력해 주세요.");
		System.out.println("도서 제목은 최대 20글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String bookName = ScannerUtil.getString();

		while (!bookChk.bookNameForm(bookName)) {
			System.out.println("도서 제목이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			bookName = ScannerUtil.getString();
		}

		System.out.println("\n도서의 가격을 입력해 주세요.");
		System.out.print("> ");
		int price = ScannerUtil.scanInt();

		System.out.println("\n도서의 저자를 입력해 주세요.");
		System.out.println("영문, 한글, '.,' 만 입력 가능하며 최대 12글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String writer = ScannerUtil.getString();

		while (!bookChk.writerForm(writer)) {
			System.out.println("저자가 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			writer = ScannerUtil.getString();
		}

		System.out.println("\n도서의 카테고리를 입력해 주세요.\n1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.print("> ");
		int category = ScannerUtil.scanInt();

		System.out.println("\n도서의 출판사를 입력해 주세요.");
		System.out.println("영문, 한글, 숫자, '&' 만 입력 가능하며 최대 10글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String publisher = ScannerUtil.getString();

		while (!bookChk.publisherForm(publisher)) {
			System.out.println("출판사명이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			publisher = ScannerUtil.getString();
		}

		System.out.println("\n도서의 수량을 입력해 주세요.");
		System.out.print("> ");
		int stock = ScannerUtil.scanInt();

		Book book = new Book(bookId, bookName, price, writer, publisher, category, stock);
		bookController.editBook(book);
	}

	public void showAdminMenu() {
		System.out.println("============= 관리자 메뉴 =============");
		System.out.println("1. 신규 도서 등록");
		System.out.println("2. 기존 도서 관리");
		System.out.println("3. 매출 현황");
		System.out.println("4. 뒤로가기");
		System.out.println("===================================");
	}
}
