package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDao;
import guestbook.domain.GuestEditRequest;
import guestbook.domain.Guestbook;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookEditService {
	
	private GuestbookEditService() {}
	private static GuestbookEditService service = new GuestbookEditService();
	public static GuestbookEditService getInstance() {
		return service;
	}
	
	public Guestbook getGuestbook(int index) {
		Guestbook guestbook = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			guestbook = GuestbookDao.getInstance().selectGuestbookByIdx(conn, index);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return guestbook;
	}

	public int editGuestbook(HttpServletRequest request, HttpServletResponse response) {
		int resultCnt = 0;
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content").replace("\r\n", "<br>");
		String idx = request.getParameter("idx");
		
		Connection conn = null;
		GuestEditRequest geRequest = new GuestEditRequest(subject, content, Integer.parseInt(idx));
		
		try {
			conn = ConnectionProvider.getConnection();
			resultCnt = GuestbookDao.getInstance().updateGuestbook(conn, geRequest);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
}
