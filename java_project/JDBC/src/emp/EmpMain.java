package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpMain {

	public static void main(String[] args) {
		
		EmpDao empDao = new EmpDao();
		Connection conn;
		List<Emp> list = new ArrayList<Emp>();
		
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = ConnectionProvider.getConnection();
			
			// 1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
//			System.out.println("1. EMP 테이블에 새로운 사원 정보를 입력");
//			Emp emp1 = new Emp(7890, "DOE", "CLERK", 7566, "2021-11-08", 1000, 0, 20);
//			int insertCnt = empDao.insertEmp(conn, emp1);
//			
//			if(insertCnt > 0) {
//				System.out.println("입력 성공");
//				System.out.println(emp1);
//			} else {
//				System.out.println("입력 실패");
//			}
			
			System.out.println("-----------------------------------");
			
			// 2.EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
			System.out.println("2.EMP 테이블의 모든 데이터를 출력");
			list = empDao.selectAllList(conn);
			
			for(Emp emp : list) {
				System.out.println(emp);
			}
			
			System.out.println("-----------------------------------");
			
			// 3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
			System.out.println("3. EMP 테이블에서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 변경");
			int editCnt = empDao.updateSalByName(conn, "SCOTT", 1000);
			
			if(editCnt > 0) {
				System.out.println("수정 성공");
			}
			
			System.out.println("-----------------------------------");
			
			// 4.EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
			System.out.println("4. EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력");
			
			Emp emp2 = empDao.selectByName(conn, "SCOTT");
			System.out.println(emp2);
			
			System.out.println("-----------------------------------");
			
			// 5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
			System.out.println("5. 모든 사원정보를 출력하되 부서정보를 함께 출력");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		
	}
	
}
