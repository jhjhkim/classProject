package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestbookReplyWriteService;

public class GuestbookReplyWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		if(request.getMethod().equals("POST")) {
			request.setAttribute("result", GuestbookReplyWriteService.getInstance().writeReply(request, response));
		}

		return "/WEB-INF/views/guestbook/reply/result.jsp";
	}

}
