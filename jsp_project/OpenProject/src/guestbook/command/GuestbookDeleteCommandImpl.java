package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestbookDeleteService;

public class GuestbookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));		
		
		try {
			request.setAttribute("result", GuestbookDeleteService.getInstance().deleteGuestbook(idx, memberIdx));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
