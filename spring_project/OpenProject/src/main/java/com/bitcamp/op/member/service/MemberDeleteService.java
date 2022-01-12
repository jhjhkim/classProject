package com.bitcamp.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;

@Service
public class MemberDeleteService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int deleteMember(int memberIdx) {

		dao = template.getMapper(MemberDao.class);

		return dao.deleteByIdx(memberIdx);
	}

}
