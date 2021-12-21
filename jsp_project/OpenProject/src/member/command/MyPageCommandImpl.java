package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.LoginInfo;
import member.domain.Member;
import member.service.MyPageService;

public class MyPageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		boolean loginChk = false;
		HttpSession session = request.getSession();
		
		// 세션에 로그인 정보가 있는지 여부를 확인
		if(session != null && session.getAttribute("loginInfo") != null) {
			loginChk = true;
			
			// 로그인한 회원의 정보를 담은 Member 객체 생성
			request.setAttribute("member", MyPageService.getInstance().myPageInfo(request));
		}
		
		request.setAttribute("loginChk", loginChk);
		
		return "/WEB-INF/views/member/my/mypage.jsp";
	}

}
