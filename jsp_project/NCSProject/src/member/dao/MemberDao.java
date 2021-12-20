package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {
	
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 회원 등록
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (userid, password, username) VALUES (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUsername());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

}
