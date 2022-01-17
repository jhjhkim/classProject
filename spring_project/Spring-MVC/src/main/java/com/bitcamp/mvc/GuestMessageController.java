package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.GuestMessage;

//@Controller
@RestController
public class GuestMessageController {

	@RequestMapping("/guest/list.json")
	//@ResponseBody
	public List<GuestMessage> getMessageList(){
		
		List<GuestMessage> list = new ArrayList<GuestMessage>();
		list.add(new GuestMessage(1, "테스트메시지", new Date()));
		list.add(new GuestMessage(2, "안녕하세요", new Date()));
		list.add(new GuestMessage(3, "다음에 만나요", new Date()));
		
		return list;
		
	}
	
}
