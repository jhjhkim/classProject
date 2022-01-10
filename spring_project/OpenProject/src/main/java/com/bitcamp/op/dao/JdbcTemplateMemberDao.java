package com.bitcamp.op.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.member.domain.Member;

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

	public List<Member> selectList(int index, int count) {
		
		String sql = "select * from member order by regdate desc limit ?,?";
		
		return template.query(sql, new MemberRowMapper(), index, count);
	}
	
}
