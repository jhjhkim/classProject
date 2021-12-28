package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.ReplyDeleteService;

public class GuestbookReplyDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			request.setAttribute("result", ReplyDeleteService.getInstance().deleteReply(request));
		}
		
		return "/WEB-INF/views/guestbook/reply/result.jsp";
	}

}
