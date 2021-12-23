package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.GuestbookWriteService;
import command.Command;

public class GuestbookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/views/guestbook/list.jsp";
	}

}
