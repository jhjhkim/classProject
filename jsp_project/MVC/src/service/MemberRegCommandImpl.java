package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			view = "/WEB-INF/views/member/regform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			
			Member member = new Member(userid, password, username);
			
			
			
			view = "/WEB-INF/views/member/reg.jsp";
		}
		
		return view;
	}

}
