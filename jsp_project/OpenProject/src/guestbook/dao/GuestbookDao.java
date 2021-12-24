package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.GuestEditRequest;
import guestbook.domain.GuestRequest;
import guestbook.domain.Guestbook;
import guestbook.domain.GuestbookMessage;
import jdbc.util.JdbcUtil;

public class GuestbookDao {

	private GuestbookDao() {
	}

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

	/*
	 * public List<Guestbook> selectList(Connection conn, int index, int count)
	 * throws SQLException { List<Guestbook> list = new ArrayList<Guestbook>();
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; String sql =
	 * "SELECT * FROM guestbook LIMIT ?,?";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setInt(1, index);
	 * pstmt.setInt(2, count); rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { list.add(getGuestbook(rs)); }
	 * 
	 * } finally { JdbcUtil.close(rs); JdbcUtil.close(pstmt); }
	 * 
	 * return list; }
	 */

	public List<GuestbookMessage> selectList(Connection conn, int index, int count) throws SQLException {
		List<GuestbookMessage> list = new ArrayList<GuestbookMessage>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, g.updatedate as updatedate, m.idx as memberidx FROM guestbook g join member m ON g.memberidx = m.idx ORDER BY regdate DESC LIMIT ?,?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(getGuestbookMessage(rs));
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public GuestbookMessage selectByIdx(Connection conn, int idx) throws SQLException {
		GuestbookMessage result = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, g.updatedate as updatedate, m.idx as memberidx FROM guestbook g join member m ON g.memberidx = m.idx WHERE g.idx = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = getGuestbookMessage(rs);
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	public Guestbook selectGuestbookByIdx(Connection conn, int idx) throws SQLException {
		Guestbook result = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM guestbook WHERE idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = getGuestbook(rs);
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	private GuestbookMessage getGuestbookMessage(ResultSet rs) throws SQLException {
		return new GuestbookMessage(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getInt(8));
	}

	private Guestbook getGuestbook(ResultSet rs) throws SQLException {
		return new Guestbook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getInt(6));
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int totalCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM guestbook";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return totalCnt;
	}

	public int updateGuestbook(Connection conn, GuestEditRequest geRequest) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "UPDATE guestbook SET subject=?, content=?, updatedate=CURRENT_TIMESTAMP WHERE idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, geRequest.getSubject());
			pstmt.setString(2, geRequest.getContent());
			pstmt.setInt(3, geRequest.getIdx());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

}
