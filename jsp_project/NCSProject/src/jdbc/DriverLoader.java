package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet {
       
	public void init(ServletConfig config) throws ServletException {

		// 외부에서 경로가 바뀌어도 괜찮도록 (-> web.xml에서 변경하면 된다) 외부 문자열 읽어오기
		String driver = config.getInitParameter("driver");
		
		// DB 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("mysql 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
	}

}
