package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.dao.GuestbookDao;
import guestbook.service.GuestbookWriteService;

public class GuestbookWriteAjaxCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			request.setAttribute("result", GuestbookWriteService.getInstance().insertGuestbook(request, response));
		}
		
		return "/WEB-INF/views/guestbook/writeajax.jsp";
	}

}
