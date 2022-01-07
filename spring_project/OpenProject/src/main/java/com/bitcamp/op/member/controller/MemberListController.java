package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/manager/list")
	public void getListPage(
			@RequestParam(value="p", defaultValue="1") int pageNumber,
			Model model
			) throws SQLException {
		
		model.addAttribute("listView", listService.getPageView(pageNumber));
		
	}
	
}
