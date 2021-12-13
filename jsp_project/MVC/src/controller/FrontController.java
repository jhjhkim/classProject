package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

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
		// http://localhost:8080/mvc/greeting.do => commandURI : /mvc/greeting.do
		// http://localhost:8080/mvc/date.do => commandURI : /mvc/date.do
		
		// request.getContextPath() => /mvc
		if(commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());
		}
		// commandURI : /mvc/greeting.do -> /greeting.do
		
		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		// 결과 데이터를 생성
		
		// 응답 결과 객체
		Object result = null;	// view 페이지에서 toString() 으로 출력
		
		// view page 경로
		String viewPage = "/WEB-INF/views/simpleview.jsp"; // servlet은 서버 내부에서 실행되므로 시스템경로로...
		
		if(commandURI.equals("/greeting.do")) {
			result = "안녕하세요.";	// Object <- String : 다형성
			viewPage = "/WEB-INF/views/greeting.jsp";

		} else if(commandURI.equals("/date.do")) {
			result = new Date();	// Object <- Date
			viewPage = "/WEB-INF/views/date.jsp";

		} else {	// /*.do 형식
			result = "Invalid Request";
		}
		
		// 4. 결과를 request 객체의 속성에 저장 : view 페이지에 결과 데이터를 공유(전달)
		request.setAttribute("result", result);
		
		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
