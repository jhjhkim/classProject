package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDao;
import guestbook.domain.GuestRequest;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestbookWriteService {

	private GuestbookWriteService() {}
	private static GuestbookWriteService service = new GuestbookWriteService();
	public static GuestbookWriteService getInstance() {
		return service;
	}
	
	public int insertGuestbook(HttpServletRequest request, HttpServletResponse response) {
		int resultCnt = 0;
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content").replace("\r\n", "<br>");
		String memberidx = request.getParameter("memberidx");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			GuestRequest gRequest = new GuestRequest(subject, content, Integer.parseInt(memberidx));
			resultCnt = GuestbookDao.getInstance().insertGuestbook(conn, gRequest);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
	
	
}
