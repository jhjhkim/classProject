package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class RestTestController {

	//@RequestMapping(method=RequestMethod.GET) : 스프링 3 버전에서는 GetMapping을 못 쓰기 때문
	@GetMapping
	public String form() {
		return "mc/form";
	}
	
	@PostMapping
	@ResponseBody
	public String simple(
			// uname=cool&age=11
			@RequestBody String bodyContent
			) {
		//@ResponseBody : 해당 메소드의 응답 내용의 data가 body의 내용이 된다.
		
		System.out.println("body : " + bodyContent);
		return "Y";
	}
	
}
