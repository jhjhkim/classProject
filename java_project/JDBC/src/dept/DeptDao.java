package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Data Access Object : Sql 처리만 하는 클래스
public class DeptDao {
	
	// 변수가 없는 클래스 , 기능만 있는 클래스
	// 인스턴스를 하나만 만들어 써도 된다!!!
	// 인스턴스를 여러 개 만들어 쓰게 하지 말자!!!
	
	// 인스턴스 하나만 만들어서 사용하도록 하는 패턴
	// 외부에서 인스턴스를 생성하지 못하도록 처리! -> 생성자의 접근제어자를 private으로 처리
	private DeptDao(){}
	
	// 클래스 내부에서 인스턴스를 생성!!! , 이 인스턴스에 직접 접근 안되도록!
	private static DeptDao dao = new DeptDao();
	
	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!!
	static public DeptDao getInstance() {
		return dao;
	}
	
	// 싱글톤 패턴
	
	
	// 전체 리스트를 구하는 메소드 : select -> 매개변수로 Connection을 전달 받고, List<Dept> 을 리턴
	public List<Dept> selectAllList(Connection conn){
		
		Statement stmt = null;
		ResultSet rs = null;
		List<Dept> result = new ArrayList<Dept>();

		try {
			// 결과 생성
			stmt = conn.createStatement();
		
			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				result.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		
		
		} catch (SQLException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return result;
		
	}
	
	// 부서 정보를 검색하는 메소드 : select -> 매개변수로 Connection과 부서번호를 전달 받고, Dept 객체를 리턴
	public Dept selectByDeptno(Connection conn, int deptno) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Dept dept = null;
		
		// Sql : Select
		String sql = "select * from dept where deptno = ?"; // 결과 -> 1 또는 0행
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return dept;
		
	}
	
	// 부서 정보를 입력하는 메소드 : insert -> 매개변수로 Connection과  Dept 객체를 전달 받아서 입력
	public int insertDept(Connection conn, Dept dept) {
		
		PreparedStatement pstmt = null;
		
		int resultCnt = 0;
		
		// Sql : insert
		String sql = "insert into dept values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
		
	}
	
	// 부서 정보를 수정하는 메소드 : update -> 매개변수로 Connection과  Dept 객체를 전달 받아서 수정
	public int editDept(Connection conn, Dept dept) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		// Sql : update
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
		
	}
	
	// 부서 정보를 삭제하는 메소드 : delete -> 매개변수로 Connection과  부서번호(PK)를 전달 받아서 삭제
	public int deleteDept(Connection conn, int deptno) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		// Sql : delete
		String sql = "delete from dept where deptno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
		
	}
	
}
