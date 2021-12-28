package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestbookDeleteService;

public class GuestbookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 정말 삭제할 거냐고 물어보기
		
		
		String index = request.getParameter("idx");
		try {
			request.setAttribute("result", GuestbookDeleteService.getInstance().deleteGuestbook(Integer.parseInt(index)));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
