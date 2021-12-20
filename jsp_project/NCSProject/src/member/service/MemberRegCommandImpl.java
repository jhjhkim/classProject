package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.Member;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			view = "/WEB-INF/views/member/regform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			
			String msg = null;
			int cnt = 0;
			
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("rePassword");
			String username = request.getParameter("username");
			
			if(!password.equals(rePassword)) {
				msg = "비밀번호를 다시 확인해주세요.";	
			} else {
				Member member = new Member(userid, password, username);
				Connection conn = null;
				
				try {
					conn = ConnectionProvider.getConnection();
					cnt = MemberDao.getInstance().insertMember(conn, member);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(conn);
				}
				
				msg = cnt>0 ? "회원가입이 완료되었습니다." : "아이디 중복 혹은 잘못된 요청입니다. 다시 확인해주세요.";
			}
			
			request.setAttribute("result", cnt);
			request.setAttribute("msg", msg);
			request.setAttribute("userid", userid);
			
			view = "/WEB-INF/views/member/reg.jsp";
		}
		
		return view;
	}

}
