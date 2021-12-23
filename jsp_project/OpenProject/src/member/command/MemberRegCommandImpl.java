package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberRegService;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/member/regform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			// int cnt = MemberRegService.getInstance().insertMember(request, response);
			
			// request 속성 처리
			// request.setAttribute("result", cnt);
			request.setAttribute("result", MemberRegService.getInstance().insertMember(request, response));
			
			view = "/WEB-INF/views/member/reg.jsp";
			
		}
		
		return view;
	}

}
