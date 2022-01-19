package com.bitcamp.op.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.domain.Member;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;
	
	
	// 매개변수는 상황에 맞추어 정해주면 된다.
	public int send(String email, String username) {

		int resultCnt = 1;
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			// 메일 제목
			message.setSubject("[안내] " + username + "님, 회원 가입을 축하합니다.", "utf-8");
			
			// 메일 내용 : html
			String html = "<h1>환영합니다.</h1>";
			html += "<a href=\"http://www.naver.com\">네이버</a> <br>";
			html += "<a href=\"http://localhost:8080/op\">Open Project 가기</a>";
			
			message.setText(html, "utf-8", "html");
			
			// from : 보내는 사람 설정, 구글 정책은 setFrom이 적용되지 않는다.
			message.setFrom(new InternetAddress("fennecus25@naver.com"));
			
			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, username + "님", "utf-8"));
			
			// 메일 발송
			sender.send(message);
			
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		} 
		
		return resultCnt;
	}

	public int send(String subject, String content, String email) {

		return 0;
	}
	
	public int send(String[] email) {

		return 0;
	}
	
	public int send(Member member) {

		return 0;
	}

}
