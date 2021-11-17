package viewer;

import controller.OrdersController;
import util.PatternChk;
import util.ScannerUtil;

public class OrdersViewer {

	OrdersController ordersController;
	PatternChk patternChk;

	public OrdersViewer() {
		ordersController = new OrdersController();
		patternChk = new PatternChk();
	}

	// 매출 현황을 보는 메소드
	public void viewOrders() {
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
			case 3:	// 월별 매출
				viewMonthlyOrders();
				break;
			case 4:	// 메뉴 종료
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
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
	
	// 로그인아이디 고유번호를 통해 주문내역 출력하는 메소드
	public void viewOrdersByLogInId() {
		ordersController.ordersByLogInId();
	}
}
