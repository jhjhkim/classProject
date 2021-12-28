package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestbookDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookDeleteService {

	private GuestbookDeleteService() {}
	private static GuestbookDeleteService service = new GuestbookDeleteService();
	public static GuestbookDeleteService getInstance() {
		return service;
	}
	
	public int deleteGuestbook(int index) throws SQLException {
		// 방명록 존재 유무 확인 -> 없으면 예외 발생
		
		
		int resultCnt = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			resultCnt = GuestbookDao.getInstance().deleteGuestbook(conn, index);
			
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
}
