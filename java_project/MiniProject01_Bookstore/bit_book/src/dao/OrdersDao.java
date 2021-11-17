package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionProvider;
import object.Orders;
import util.JdbcUtil;

public class OrdersDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private OrdersDao() { // 싱글톤
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static private OrdersDao ordersDao = new OrdersDao();
	
	static public OrdersDao getInstance() {
		return ordersDao;
	}
	
	// 주문이 존재하면 true를 리턴하는 메소드
	public boolean selectCount() {
		boolean result = false;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from bit_orders_log";
			rs = stmt.executeQuery(sql);
			
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return result;
	}

	// 전체 주문 목록 (+가격) 을 리턴하는 메소드 : 책가격을 포함한 view orders_view 를 이용
		public List<Orders> selectAllList() {
			List<Orders> result = new ArrayList<Orders>();

			try {
				stmt = conn.createStatement();
				String sql = "select * from orders_view";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					result.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
										  rs.getInt(5), rs.getString(6)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
			}

			return result;
		}
	
	// 매출이 있는 날짜의 목록을 리턴하는 메소드
	public List<String> selectOrderdate(){
		List<String> result = new ArrayList<String>();
		
		String sql = "select TO_CHAR(orderdate, 'YYYY-MM-DD') from bit_orders group by TO_CHAR(orderdate, 'YYYY-MM-DD') order by TO_CHAR(orderdate, 'YYYY-MM-DD')";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	// 매출이 있는 월을 리턴하는 메소드
	public List<String> selectOrderMonth(){
		List<String> result = new ArrayList<String>();
		
		String sql = "select TO_CHAR(orderdate, 'YYYY-MM') from bit_orders group by TO_CHAR(orderdate, 'YYYY-MM') order by TO_CHAR(orderdate, 'YYYY-MM')";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	// 선택한 날짜의 주문 목록을 리턴하는 메소드
	public List<Orders> selectByDate(String orderdate) {
		List<Orders> result = new ArrayList<Orders>();

		String sql = "select * from orders_view where to_char(orderdate, 'YYYYMMDD') = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderdate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	// 선택한 날짜의 매출 총액을 리턴하는 메소드
	public int dailyTotalSales(String orderdate) {
		int result = 0;
		
		String sql = "select nvl(sum(price),0) from orders_view where to_char(orderdate, 'YYYYMMDD') = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderdate);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	// 선택한 월의 주문 목록을 리턴하는 메소드
	public List<Orders> selectByMonth(String orderMonth) {
		List<Orders> result = new ArrayList<Orders>();

		String sql = "select * from orders_view where to_char(orderdate, 'YYYYMM') = ? order by orderdate";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderMonth);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return result;
	}
	
	// 선택한 월의 매출 총액을 리턴하는 메소드
	public int monthlyTotalSales(String orderMonth) {
		int result = 0;
		
		String sql = "select nvl(sum(price),0) from orders_view where to_char(orderdate, 'YYYYMM') = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderMonth);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	
	// 로거클래스에 저장된 userId 가 구입한 목록을 리턴하는 메소드
	public List<Orders> selectByUserId(){
		List<Orders> result = new ArrayList<Orders>();
		
		String sql = "select * from orders_view where userId = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logger.LoginUser.loginId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), 
									  rs.getString(4), rs.getInt(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
}