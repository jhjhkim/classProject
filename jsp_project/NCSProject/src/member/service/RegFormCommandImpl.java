package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		// 결과데이터 필요 없다!
		// request 속성에 저장할 필요 X
		return "/WEB-INF/views/member/regform.jsp";
	}

}
