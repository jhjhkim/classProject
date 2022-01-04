package com.bitcamp.mvc;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// HelloService service = new HelloService();
	
	@Autowired
	HelloService service;

	// 사용자 요청 uri 등록 : 실행할 메소드를 정의
	// http://localhost:8080/mvc/hello
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		ModelAndView view = new ModelAndView();
		// view name 지정
		view.setViewName("hello/hello");	// /WEB-INF/views/hello/hello.jsp
		// view에 전달할 결과데이터 설정
		view.addObject("greeting", getGreeting());
		
		return view;
		
	}
	
	private String getGreeting() {

		String str = "안녕하세요.";
	
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour>=6 && hour<=10) {
			str = "좋은 아침입니다.";
		} else if(hour>=12 && hour<=15) {
			str = "점심 식사는 하셨나요?";
		} else if(hour>=18 && hour<22) {
			str = "내일 만나요!";
		}
		
		return str;

	}
	
}
