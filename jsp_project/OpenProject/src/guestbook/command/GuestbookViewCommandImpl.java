package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.dao.GuestbookDao;
import guestbook.service.GuestbookViewService;
import guestbook.service.ReplyListService;

public class GuestbookViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("message", GuestbookViewService.getInstance().getMessage(request));
		request.setAttribute("replyList", ReplyListService.getInstance().getList(request));
		
		return "/WEB-INF/views/guestbook/view.jsp";
	}

}
