package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	private Connection conn;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	void contextLoads() {
	}
	
	// 테스트용 코드 : 한글을 사용하는 게 더 직관적일 수 있다.
	@Test
	public void 커넥션생성테스트() throws SQLException {

		System.out.println("dataSource ---> " + dataSource);
		
		conn = dataSource.getConnection();
		System.out.println("connection ---> " + conn);
		
		conn.close();
		
	}
	
	@Test
	public void 세션팩토리생성() {
		System.out.println("sqlSessionFactory ---> " + sqlSessionFactory);
	}

}
