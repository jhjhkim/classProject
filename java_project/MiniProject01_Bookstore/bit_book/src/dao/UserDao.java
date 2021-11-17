package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionProvider;
import object.User;
import util.JdbcUtil;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private UserDao () {										// 싱글톤
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static private UserDao userDao = new UserDao();
	
	static public UserDao getInstance() {	
		return userDao;		
	};

	//////////////////////////////   JOIN   ///////////////////////////////////

	// 회원가입 (새로운 회원 정보 입력)
	public int insertUser(User user) {
		int resultCnt = 0;
		String sql = "insert into bit_users values(bit_users_userid_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhnum());
			pstmt.setString(6, user.getAddress());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	// 파라미터로 들어온 아이디와 일치하는 이이디가 이미 존재하면 true를 리턴하는 메소드
	public boolean userNameCheck(String userName) {
		boolean result = false;
		
		String sql = "select * from bit_users where username = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}	
	

	//////////////////////////////   LOGIN   ///////////////////////////////////
	// 유저 ID,PW 체크하여 해당 유저가 존재하면 유저의 고유번호를 리턴하는 메소드
	public int authChk(String username, String password) {
		String sql = "select userid from bit_users where username = ? and password = ?";
		int userId = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return userId;
	}
	
	
	////////////////////////////// MY INFO   ///////////////////////////////////
	
	// 현재 로그인된 회원 정보를 리턴
	public User selectByUserId() {
		User user = null;
		String sql = "select * from bit_users where userid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logger.LoginUser.loginId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return user;
	}
	
	
	// 해당 회원번호의 비밀번호가 맞으면 true를 리턴하는 메소드
	public boolean passwordChk(String password) {
		boolean result = false;
		String sql = "select username from bit_users where userid = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logger.LoginUser.loginId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	// 회원정보 수정 : update
	public int updateUser(String password, String email, String phnum, String address, int userId) {		
		int resultCnt = 0;

		String sql = "update bit_users set password = ?, email = ?, phnum = ?, address = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.setString(3, phnum);
			pstmt.setString(4, address);
			pstmt.setInt(5, userId);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	// 회원 정보 삭제 : delete
	public int deleteUser() {
		int resultCnt = 0;
		
		String sql = "delete from bit_users where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logger.LoginUser.loginId);
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
}
