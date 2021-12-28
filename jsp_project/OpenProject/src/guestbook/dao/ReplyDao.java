package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.ReplyListItem;
import guestbook.domain.ReplyRequest;
import jdbc.util.JdbcUtil;

public class ReplyDao {

	private ReplyDao() {}
	private static ReplyDao dao = new ReplyDao();
	public static ReplyDao getInstance() {
		return dao;
	}
	public int insertReply(Connection conn, ReplyRequest replyRequest) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO reply (content, memberidx, guestbookidx) VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyRequest.getMessage());
			pstmt.setInt(2, replyRequest.getMemberIdx());
			pstmt.setInt(3, replyRequest.getGuestbookIdx());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	public List<ReplyListItem> selectList(Connection conn, int guestbookIdx) throws SQLException {
		List<ReplyListItem> list = new ArrayList<ReplyListItem>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT r.idx, r.content, r.regdate, r.guestbookidx, r.memberidx, m.username, m.photo FROM reply r JOIN member m ON r.memberidx = m.idx WHERE guestbookidx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestbookIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ReplyListItem(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}
	public int deleteReply(Connection conn, int idx) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM reply WHERE idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
}
