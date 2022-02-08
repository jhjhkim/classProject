package com.example.demo.member.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.domain.Member;
import com.example.demo.member.mapper.MemberDao;

@RestController
public class IndexController {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@RequestMapping("/")
	@ResponseBody
	public String getIndex() {
		return "INDEX Page";
	}
	
	@RequestMapping("/members")
	@ResponseBody
	public List<Member> getList(){
		
		return template.getMapper(MemberDao.class).selectList();
		
	}
	
}
