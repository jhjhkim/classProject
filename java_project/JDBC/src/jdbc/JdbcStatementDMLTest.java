package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcStatementDMLTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		// 1. 드라이버 로드
		try {		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2. 연결 : Connection
			// String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터베이스]";
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("데이터베이스 연결 성공!");
			
			// 3. 작업 : CRUD -> Statement 객체 생성
			stmt = conn.createStatement();
			
			// Sql : insert
			String sql = "insert into dept (deptno, dname, loc) values (50, 'test', 'SEOUL')";
			
			int cnt = stmt.executeUpdate(sql);
			
			if(cnt > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!");
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결 실패!");
			e.printStackTrace();
			
		} finally {
			
			// 4. 종료 : close() : 사용한 역순으로
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}	
}
