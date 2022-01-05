package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/regForm";
	}
	
	/*public void getForm() {
		/WEB-INF/views
		/member/reg
		.jsp
	}*/
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg() {
		return "member/reg";
	}
	
}
