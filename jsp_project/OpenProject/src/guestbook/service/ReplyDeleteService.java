package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.ReplyDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class ReplyDeleteService {

	private ReplyDeleteService() {}

	private static ReplyDeleteService service = new ReplyDeleteService();
	
	public static ReplyDeleteService getInstance() {
		return service;
	}
	
	public int deleteReply(HttpServletRequest request) {
		int resultCnt = 0;
		int idx = Integer.parseInt(request.getParameter("idx"));
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			resultCnt = ReplyDao.getInstance().deleteReply(conn, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
	
	
}
