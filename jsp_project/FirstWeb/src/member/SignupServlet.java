package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post 방식으로 데이터를 받을 때 한글 인코딩 처리 필수!
		request.setCharacterEncoding("utf-8");

		// 데이터 받기
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String username = request.getParameter("username");
		String comment = request.getParameter("comment");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		String byear = request.getParameter("byear");

		// 응답하는 데이터의 타입
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("		<title>데이터 확인</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			User Id : " + uid + " <br>");
		out.println("			Password : " + pw + " <br>");
		out.println("			이름 : " + username + " <br>");
		out.println("			자기소개 : " + comment + " <br>");
		out.println("			성별 : " + gender + " <br>");

		if (interests != null) {
			for (int i = 0; i < interests.length; i++) {
				out.println("			관심사 : " + interests[i] + " <br>");
			}
		} else {
			out.println("			관심사 : 선택된 관심사가 없습니다. <br>");
		}
		
		out.println("			태어난 연도 : " + byear + " <br>");

		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 처리");
		doGet(request, response);
	}

}
