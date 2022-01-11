package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;

@Repository
public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate template;
	
	// 로그인 처리를 위한 select
	public Member selectByIdPw(String userId, String pw) {
		
		String sql = "select * from member where userid=? and password=?";
		
		List<Member> members = template.query(sql, new MemberRowMapper(), userId, pw);
		Member member = members.isEmpty() ? null : members.get(0);
		
		// Member member = template.queryForObject(sql, new MemberRowMapper(), userId, pw);
		
		return member;
		
		// return template.queryForObject(sql, new MemberRowMapper(), userId, pw);
	}
	
	// 전체 회원의 수를 구하는 메소드
	public int selectTotalCount() {
		return template.queryForObject("select count(*) from member", Integer.class);
	}

	// 리스트 페이지에 출력할 회원정보 list 구하는 select
	public List<Member> selectList(int index, int count) {
		
		String sql = "select * from member order by regdate desc limit ?,?";
		
		return template.query(sql, new MemberRowMapper(), index, count);
	}
	
	// 회원가입을 위한 insert
	public int insertMember(MemberRegRequest request) {
		String sql = "INSERT INTO member (userid, password, username, photo) VALUES (?,?,?,?)";
		return template.update(
				sql, 
				request.getUserid(), 
				request.getPw(), 
				request.getUsername(), 
				request.getFileName());
	}
	
	public int insert(MemberRegRequest request) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int resultCnt = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String sql = "INSERT INTO member (userid, password, username, photo) VALUES (?,?,?,?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"idx"});
				pstmt.setString(1, request.getUserid());
				pstmt.setString(2, request.getPw());
				pstmt.setString(3, request.getUsername());
				pstmt.setString(4, request.getFileName());
				
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		request.setIdx(keyValue.intValue());
		
		return resultCnt;
	}
	
	// MyPage를 위한 Member 객체를 구하는 select
	public Member selectByIdx(int idx) {
		String sql = "select * from member where idx=?";
		
		List<Member> members = template.query(sql, new MemberRowMapper(), idx);
		
		return members.isEmpty() ? null : members.get(0);
		
	}
	
}
