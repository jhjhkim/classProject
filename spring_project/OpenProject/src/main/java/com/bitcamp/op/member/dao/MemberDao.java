package com.bitcamp.op.member.dao;

import java.util.List;

import com.bitcamp.op.member.domain.LoginParams;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.Member2;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchParams;

public interface MemberDao {

	//public Member selectByIdPw(LoginParams params);
	public Member selectByIdPw(String userId, String pw);
	
	public int selectTotalCount();
	
	//public List<Member> selectList(SearchParams params);
	public List<Member> selectList(int index, int count);
	
	public int insertMember(MemberRegRequest regRequest);
	
	public Member selectByIdx(int idx);
	
	public Member2 selectByIdx2(int idx);
	
}
