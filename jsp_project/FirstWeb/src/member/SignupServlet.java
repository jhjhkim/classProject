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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head><title>Sign Up Data</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			User Id : " + uid + " <br>");
		out.println("			Password : " + pw + " <br>");
		out.println("			Name : " + username + " <br>");
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 처리");
		doGet(request, response);
	}

}
