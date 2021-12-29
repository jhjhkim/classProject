package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.GuestbookDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookDeleteService {

	private GuestbookDeleteService() {}
	
	private static GuestbookDeleteService service = new GuestbookDeleteService();
	
	public static GuestbookDeleteService getInstance() {
		return service;
	}
	
	public int deleteGuestbook(int idx, int memberIdx) throws SQLException {
		int resultCnt = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			resultCnt = GuestbookDao.getInstance().deleteGuestbook(conn, idx, memberIdx);
			
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
}
