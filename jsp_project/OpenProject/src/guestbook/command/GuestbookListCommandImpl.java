package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.GuestbookListService;
import command.Command;

public class GuestbookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNumber = request.getParameter("p");
		int pageNum = 1;
		
		if(pageNumber != null && pageNumber.length()>0) {
			try{
				pageNum = Integer.parseInt(pageNumber);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("listView", GuestbookListService.getInstance().getPage(pageNum));
		
		return "/WEB-INF/views/guestbook/list.jsp";
	}

}
