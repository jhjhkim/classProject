package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestbookDao;
import guestbook.domain.GuestbookMessage;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookViewService {

	private GuestbookViewService() {
	}

	private static GuestbookViewService service = new GuestbookViewService();

	public static GuestbookViewService getInstance() {
		return service;
	}

	public GuestbookMessage getMessage(int idx) {
		GuestbookMessage message = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			message = GuestbookDao.getInstance().selectByIdx(conn, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}

		return message;
	}

}
