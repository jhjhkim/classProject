package chapter06.score;

public class ScoreManager {
	// 배열을 가지고 있고,
	// 배열의 요소를 추가, 검색, 삭제할 수 있는 기능을 가지는 클래스
	
	private Student[] score;
	private int numOfStudent;
	
	public ScoreManager(int size) {
		score = new Student[size];
		numOfStudent = 0;
	}
	
	public ScoreManager() {
		this(10);
	}
	
	// 전체 데이터 출력 : 배열의 "입력된" 모든 데이터를 출력
	public void showAllData() {
		System.out.println("학생 점수 리스트");
		System.out.println("-------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < numOfStudent; i++) {
			System.out.println(score[i]);
		}
			
		System.out.println("-------------------------------------");
	}

	// 데이터 추가
	
	
	// 데이터 검색 : 이름 기준 검색
	
	
	// 데이터 삭제 : 이름 기준으로 삭제
	
	
}
