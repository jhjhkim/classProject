package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.dao.GuestbookDao;
import guestbook.service.GuestbookEditService;

public class GuestbookEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		String view = null;

		if (request.getMethod().equals("GET")) {
			String idx = request.getParameter("idx");
			request.setAttribute("guestbook", GuestbookEditService.getInstance().getGuestbook(Integer.parseInt(idx)));

			view = "/WEB-INF/views/guestbook/editform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			request.setAttribute("result", GuestbookEditService.getInstance().editGuestbook(request, response));
			request.setAttribute("messageidx", request.getParameter("idx"));
			
			view = "/WEB-INF/views/guestbook/edit.jsp";
		}
		
		return view;
	}

}
