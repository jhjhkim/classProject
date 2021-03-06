package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberListService;

public class MemberListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// http://localhost:8080/op/member/manager/list.do?p=2
		String pageNumber = request.getParameter("p");
		int pageNum = 1;	// 초기화 1 : 어쨌든 1페이지 가야 하니까!
		
		if(pageNumber != null && pageNumber.length()>0) {
			
			try {
			pageNum = Integer.parseInt(pageNumber);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("listView", MemberListService.getInstance().getPage(pageNum));
		
		return "/WEB-INF/views/member/manager/list.jsp";
	}

}
