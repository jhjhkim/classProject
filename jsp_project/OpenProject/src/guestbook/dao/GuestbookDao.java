package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.GuestRequest;
import jdbc.util.JdbcUtil;

public class GuestbookDao {

	private GuestbookDao() {}
	private static GuestbookDao dao = new GuestbookDao();
	public static GuestbookDao getInstance() {
		return dao;
	}
	
	public int insertGuestbook(Connection conn, GuestRequest gRequest) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gRequest.getSubject());
			pstmt.setString(2, gRequest.getContent());
			pstmt.setInt(3, gRequest.getMemberidx());
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
}
