package dept.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {

	// 기능(메소드)만 있는 클래스 -> 인스턴스 생성을 제한
	// 싱글톤 패턴
	// 1. 생성자를 private 으로 해주어서 인스턴스 생성을 막는다.
	private DeptDao() {}
	
	// 2. 클래스 내부에서 인스턴스를 생성, 참조변수는 private, static
	private static DeptDao dao = new DeptDao();
	
	// 3. 참조값을 제공하는 메소드 필요! -> public static
	public static DeptDao getInstance() {
		return dao;
	}
	
	
	// 부서 리스트 출력을 위한 데이터들을 반환하는 메소드
	public List<Dept> selectAll(Connection conn) {
		
		// 응답 결과 객체
		List<Dept> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Dept>();
			
			// 결과를 객체에 담는다.
			while(rs.next()) {
				
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				
//				Dept dept = new Dept(deptno, dname, loc);
//				
//				list.add(dept);
				
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return list;
		
	}
	
}
