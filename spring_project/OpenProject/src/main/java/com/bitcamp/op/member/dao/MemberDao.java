package com.bitcamp.op.member.dao;

import com.bitcamp.op.member.domain.LoginParams;
import com.bitcamp.op.member.domain.Member;

public interface MemberDao {

	//public Member selectByIdPw(LoginParams params);
	public Member selectByIdPw(String userId, String pw);
	
}
