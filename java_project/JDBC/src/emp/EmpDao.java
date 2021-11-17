package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	
	// 1. 모든 데이터 출력 : select
	public List<Emp> selectAllList(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from emp order by empno";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 2. 이름으로 검색 : select
	public Emp selectByName(Connection conn, String ename) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;
		
		String sql = "select * from emp where ename like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	// 3. 새로운 사원 정보를 입력 : insert
	public int insertEmp(Connection conn, Emp emp) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into emp values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
		
	}
	
	
	// 4. 이름으로 급여정보를 바꾸는 : update
	public int updateSalByName(Connection conn, String ename, int sal) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "update emp set sal = ? where ename like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sal);
			pstmt.setString(2, ename);
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultCnt;
	}
		
	
	// 5. 모든 사원정보를 출력하되 부서정보를 함께 출력
	
	
}
