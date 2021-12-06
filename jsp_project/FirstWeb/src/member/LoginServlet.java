package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 : 자바 문법이 아니다. 주석도 아니다. 약속되어있는 추가적인 처리를 해주는 약속어
// (예: @Override)
// http://localhost:8080/first/Login
// http://localhost:8080/first/login
@WebServlet({ "/login", "/Login" })
public class LoginServlet extends HttpServlet {
	
	// 사용자가 요청할 때 Get 방식으로 요청했을 때 처리되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 사용자의 요청정보를 모두 가지고 있는 객체
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 사용자가 입력한 userid, pw 를 받아서 응답 메시지에 포함하여 처리
		String uid = request.getParameter("userid");	// input의 name 속성
		String pw = request.getParameter("pw");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head><title>파라미터 데이터 받기</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			userid : " + uid + " <br>");
		out.println("			pw : " + pw);
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");
		
	}

	// 사용자가 요청할 때 Post 방식으로 요청했을 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 처리!");
		doGet(request, response);
	}

}
