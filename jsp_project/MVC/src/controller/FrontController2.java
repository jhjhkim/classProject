package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BadRequestCommandImpl;
import service.Command;
import service.DateCommandImpl;
import service.GreetingCommandImpl;

public class FrontController2 extends HttpServlet {

	// 1. HTTP 요청 받음
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 요청 받기
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 요청 받기
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 사용자의 요청 분석 : URI를 이용한 사용자 요청 분석
		String commandURI = request.getRequestURI();
		
		if(commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());
		}
		
		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		// 결과 데이터를 생성
		
		// 응답 결과 객체		
		Command command = null;
		
		if(commandURI.equals("/greeting.do")) {
			command = new GreetingCommandImpl();
			
		} else if(commandURI.equals("/date.do")) {
			command = new DateCommandImpl();
			
		} else {
			command = new BadRequestCommandImpl();
		}
		
		String viewPage = command.getPage(request, response);
		
		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
