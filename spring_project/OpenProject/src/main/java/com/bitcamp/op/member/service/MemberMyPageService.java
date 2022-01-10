package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.dao.MemberDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.LoginInfo;
import com.bitcamp.op.member.domain.Member;

@Service
public class MemberMyPageService {

	//@Autowired
	//private MemberDao dao;
	@Autowired
	private JdbcTemplateMemberDao dao;
	
	public Member getMember(HttpSession session) throws SQLException {
		
		int memberIdx = ((LoginInfo) session.getAttribute("loginInfo")).getIdx();
		//Member member = null;
		//Connection conn = null;
		
		//try {
			//conn = ConnectionProvider.getConnection();
			
			//member = dao.selectByIdx(conn, memberIdx);
			Member member = dao.selectByIdx(memberIdx);
			
		//} finally {
		//	JdbcUtil.close(conn);
		//}
		
		return member;
	}
	
}
