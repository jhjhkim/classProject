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
	
	public int deleteGuestbook(HttpServletRequest request) throws SQLException {
		int resultCnt = 0;
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		
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
