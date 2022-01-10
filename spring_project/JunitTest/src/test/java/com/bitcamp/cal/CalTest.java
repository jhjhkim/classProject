package com.bitcamp.cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalTest {

	Calculator cal;

	// 테스트 코드 작성 전 -> 테스트 케이스 정의
	// @Before : @Test 실행 전에 실행
	@Before
	public void setup() {
		System.out.println("@Before 메소드 실행");

		// 메소드 실행 전 변수 초기화
		cal = new Calculator();
	}

	// @After : @Test 실행 후에 실행
	@After
	public void tearDown() {
		System.out.println("@After 메소드 실행");
	}

	// @BeforeClass : 테스트객체 생성 전
	@BeforeClass
	public static void setupForClass() {
		System.out.println("@BeforeClass 메소드 실행");
	}

	// @AfterClass : 테스트객체 소멸 전
	@AfterClass
	public static void tearDownForClass() {
		System.out.println("@AfterClass 메소드 실행");
	}

	// @Test
	@Test
	public void test1() {

		System.out.println("@Test 단위테스트 메소드 실행");

		int num1 = 20;
		int num2 = 10;

		// assertEquals("메시지", 기대값, 대상값)
		// add 메소드의 테스트 케이스 -> 20, 10 을 전달하면 30 반환 => 성공
		assertEquals("add(20,10)", 30, cal.add(num1, num2));

		// substract 메소드 -> 20, 10 전달하면 결과값 10 => 성공
		assertEquals("substract(20,10)", 10, cal.substract(num1, num2));

		// multiply 메소드 -> 20, 10 전달하면 결과값 200 => 성공
		assertEquals("multiply(20,10)", 200, cal.multiply(num1, num2));

		// divide 메소드 -> 20, 10 전달하면 결과값 2 => 성공
		assertEquals("divide(20,10)", 2, cal.divide(num1, num2));
		
		// fail("무조건 실패!");
		
		// 논리값을 가지고 비교 결과
		// assertTrue(true);
		// assertTrue("비교=>", false);
		assertTrue("비교", cal.add(num1, num2)>20);
		
		// null 값을 비교 : null이면 성공
		assertNull("is null", null);
		// assertNull("is null", "test");
		
		// not null 비교 : null이 아니면 성공
		// assertNotNull("is not null", null);
		assertNotNull("is not null", "");
		
	}

}
