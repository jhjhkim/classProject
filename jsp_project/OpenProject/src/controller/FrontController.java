package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.command.BadRequestCommandImpl;
import member.command.Command;

public class FrontController extends HttpServlet {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("서블릿이 생성될 때 한 번 실행합니다. -> 초기화 처리 합니다.");
		
		// 설정 파일에 init-param 설정된 경로 가져오기
		String configFile = config.getInitParameter("configPath");
		
		// 프로퍼티(MAP 인터페이스에서 파생된 클래스) 파일 생성
		// 파일 -> 객체 만들어주는 역할
		Properties prop = new Properties();
		// 시스템 경로 : 실제 경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(configPath);
			
			// 파일 -> 객체 Properties
			prop.load(fis);
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Object> itr = prop.keySet().iterator();
		
		while(itr.hasNext()) {
			String command = (String) itr.next();
			String commandClassName = prop.getProperty(command);
			
			System.out.println(command+"="+commandClassName);
			
			// commands Map 에 command(key), commandClassName의 인스턴스를 저장
			// commandClassName 이름의 클래스로 인스턴스 생성 -> Class 클래스 이용
			
			try {
				// 클래스 이름으로 인스턴스 생성
				Class commandClass = Class.forName(commandClassName);
				
				// 인스턴스 생성
				Command commandObj = (Command)commandClass.newInstance();
				
				// command Map에 <요청, 객체> 저장
				commands.put(command, commandObj);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		
		// Command 설정
		// commands.put("/greeting.do", new GreetingCommandImpl());
		// commands.put("/date.do", new DateCommandImpl());
		
		System.out.println("초기화된 요청 : " + commands.size());
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commandURI = request.getRequestURI();
		
		if(commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());
		}
		
		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		// 결과 데이터를 생성
		
		// 응답 결과 객체		
		Command command = commands.get(commandURI);
		if(command == null) {
			command = new BadRequestCommandImpl();
		}
		
//		if(commandURI.equals("/greeting.do")) {
//			command = new GreetingCommandImpl();
//			
//		} else if(commandURI.equals("/date.do")) {
//			command = new DateCommandImpl();
//			
//		} else {
//			command = new BadRequestCommandImpl();
//		}
		
		String viewPage = command.getPage(request, response);
		
		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
