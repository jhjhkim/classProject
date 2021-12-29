package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberRegService;

public class MemberRegCommandImpl2 implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			// int cnt = MemberRegService.getInstance().insertMember(request, response);
			
			// request 속성 처리
			// request.setAttribute("result", cnt);
			request.setAttribute("result", MemberRegService.getInstance().insertMember(request, response));
			
		}
		
		return "/WEB-INF/views/member/reg2.jsp";
	}

}
