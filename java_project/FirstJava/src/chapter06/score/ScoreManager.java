package chapter06.score;

import java.util.Scanner;

public class ScoreManager {
	// 배열을 가지고 있고,
	// 배열의 요소를 추가, 검색, 삭제할 수 있는 기능을 가지는 클래스
	// static인 이유: 스캐너를 하나만 만들기 위해!
	public static final Scanner sc = new Scanner(System.in);
	
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

	// 데이터 추가 : 배열의 요소로 추가 -> Student 타입의 참조값
	public void insertScore(Student s) {
		score[numOfStudent++] = s;
		// score[numOfStudent] = s;
		// numOfStudent++;
	}
	
	// 데이터 검색 : 이름 기준 검색 -> 배열의 요소들 중 이름(검색어)을 비교
	public void searchData() {
		
		System.out.println("검색하고자 하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index != -1) {
			System.out.println(score[index]);
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

		
//		for(int i = 0; i < numOfStudent; i++) {
//			// 검색어와 요소 객체의 name 문자열을 비교
//			if(score[i].getName().equals(name)) {
//				System.out.println(score[i]);
//			}
//		}
	}
	
	// 데이터 삭제 : 이름 기준으로 삭제
	//			-> 배열의 요소에서 손흥민의 정보를 지운다! -> 손흥민 객체를 참조하는 값이 없으면 삭제된 것과 같은 의미!
	//			삭제 후 빈칸을 한칸씩 당겨오고(shift) numOfStudent도 -1 된다.
	public void deleteScore() {
		
		System.out.println("삭제하고자 하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index != -1) {
			// 시프트 : 참조값을 지운다 -> 정보 삭제
			for(int i = index; i < numOfStudent - 1; i++) {
				score[i] = score[i+1];
			}
			numOfStudent--;
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("입력하신 이름의 데이터가 존재하지 않습니다.");
		}
		
		
//		for(int i = 0; i < numOfStudent; i++) {
//			if(score[i].getName().equals(name)) {
//				
//				for(int j = i; i < numOfStudent - 1; j++) {
//					score[j] = score[j+1];
//				}
//				System.out.println("삭제되었습니다.");				
//				numOfStudent--;	
//			}
//		}
		
	}
	
	// 이름으로 배열의 index를 찾아 index 값을 반환하는 메소드
	private int searchIndex(String name) {
		int index = -1;
		
		for(int i = 0; i < numOfStudent; i++) {
			if(score[i].getName().equals(name)) {
				index = i;
				break;		// 반복문에서 벗어날 수 있는 구문
			}
		}
		
		return index;
	}
	
	// 학생 정보를 입력받고 -> 배열에 저장하는 메소드
	public void insertStudent() {
		
		System.out.println("학생 성적 데이터를 입력합니다.");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("국어 점수>> ");
		int scoreKor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수>> ");
		int scoreEng = Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수>> ");
		int scoreMath = Integer.parseInt(sc.nextLine());
		
		insertScore(new Student(name, scoreKor, scoreEng, scoreMath));
		System.out.println("성적 데이터가 입력되었습니다.");
		
	}

}
