package com.example.demo.member.mapper;

import java.util.List;

import com.example.demo.member.domain.Member;

public interface MemberDao {

	public List<Member> selectList();
	
}
