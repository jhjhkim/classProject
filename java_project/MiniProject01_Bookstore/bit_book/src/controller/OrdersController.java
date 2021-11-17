package controller;

import java.util.List;

import dao.OrdersDao;
import object.Orders;

public class OrdersController {

	public OrdersDao ordersDao;

	public OrdersController() {
		ordersDao = OrdersDao.getInstance();
	}
	
	// 주문내역이 있으면 true를 리턴하는 메소드
	public boolean ordersChk() {
		boolean result = ordersDao.selectCount();
		
		return result;
	}

	public void viewAllOrders() {
		List<Orders> list = ordersDao.selectAllList();

		System.out.println("==================== 전체 주문 리스트 ====================");
		System.out.println("주문번호\t사용자\t책번호\t가격\t주문일");
		System.out.println("----------------------------------------------------");
		for (Orders o : list) {
			System.out.println(o.admin());
		}
		System.out.println("====================================================\n");

	}

	// 파라미터로 들어온 주문일의 모든 주문 목록을 출력하는 메소드
	public void viewDailyOrders(String orderdate) {
		List<Orders> list = ordersDao.selectByDate(orderdate);

		String year = orderdate.substring(0, 4);
		String month = orderdate.substring(4, 6);
		String day = orderdate.substring(6);

		int totalSales = ordersDao.dailyTotalSales(orderdate);

		if (list.isEmpty()) {
			System.out.println("선택한 주문일의 주문건이 없습니다.");
		} else {
			System.out.println("=============== " + year + "년 " + month + "월 " + day + "일 주문 리스트 ===============");
			System.out.println("주문번호\t사용자\t책번호\t가격\t주문일");
			System.out.println("----------------------------------------------------");
			for (Orders o : list) {
				System.out.println(o.admin());
			}
			System.out.println("----------------------------------------------------");

			// 일별 매출액 구하는 메소드 만들기
			System.out.println(year + "년 " + month + "월 " + day + "일 매출 총액 : " + totalSales + " 원");

			System.out.println("====================================================\n");
		}
	}

	public void viewMonthlyOrders(String orderMonth) {
		List<Orders> list = ordersDao.selectByMonth(orderMonth);
		String year = orderMonth.substring(0, 4);
		String month = orderMonth.substring(4);

		int totalSales = ordersDao.monthlyTotalSales(orderMonth);

		if (list.isEmpty()) {
			System.out.println("선택한 주문연월의 주문건이 없습니다.");
		} else {
			System.out.println("================= " + year + "년 " + month + "월 주문 리스트 =================");
			System.out.println("주문번호\t사용자\t책번호\t가격\t주문일");
			System.out.println("----------------------------------------------------");
			for (Orders o : list) {
				System.out.println(o.admin());
			}
			System.out.println("----------------------------------------------------");

			// 일별 매출액 구하는 메소드 만들기
			System.out.println(year + "년 " + month + "월 매출 총액 : " + totalSales + " 원");

			System.out.println("====================================================\n");
		}
	}

	// 매출이 있는 날짜의 목록을 출력
	public void viewOrderdate() {
		List<String> list = ordersDao.selectOrderdate();

		System.out.println("========= 주문일 목록 =========");
		for (String s : list) {
			System.out.println("\t" + s);
		}
		System.out.println("===========================\n");
	}

	// 매출이 있는 달의 목록을 출력
	public void viewOrderMonth() {
		List<String> list = ordersDao.selectOrderMonth();

		System.out.println("========= 주문월 목록 =========");
		for (String s : list) {
			System.out.println("\t" + s);
		}
		System.out.println("===========================\n");
	}

	// 로그인아이디 고유번호를 보내서 해당 고객의 구매내역을 리턴 > 컨트롤러에서 출력으로변경
	public void ordersByLogInId() {
		List<Orders> list = ordersDao.selectByUserId();
		if (list.isEmpty()) {
			System.out.println("아직 주문하신 내역이 없습니다.");
		} else {
			System.out.println("====================================================");
			System.out.println("주문번호\t책이름\t\t가격\t주문일");
			System.out.println("----------------------------------------------------");
			for (Orders o : list) {
				System.out.println(o.user());
			}
			System.out.println("====================================================\n");
		}
	}

}
