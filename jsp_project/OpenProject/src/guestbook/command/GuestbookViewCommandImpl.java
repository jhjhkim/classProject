package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.dao.GuestbookDao;
import guestbook.service.GuestbookViewService;

public class GuestbookViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String index = request.getParameter("idx");
		request.setAttribute("message", GuestbookViewService.getInstance().getMessage(Integer.parseInt(index)));
		
		return "/WEB-INF/views/guestbook/view.jsp";
	}

}
