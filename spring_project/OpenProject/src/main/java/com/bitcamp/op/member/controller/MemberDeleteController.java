package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	private MemberDeleteService deleteService;
	
	@RequestMapping("/member/delete")
	public String deleteMember(
			@RequestParam("idx") int idx
			) {
		
		deleteService.deleteMember(idx);
		
		return "redirect:/member/manager/list";
	}
	
}
