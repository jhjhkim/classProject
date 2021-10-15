package chapter06;
//2. Student 클래스를 정의해봅시다. 
//① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
//② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
//③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.

public class Student {
	// 변수 정의
	private String name;
	private int korean;
	private int english;
	private int math;
	
	// 생성자
	public Student() {
		
	}
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
		
	// getter/setter 메소드
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKorean() {
		return korean;
	}
	
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	// 총점을 반환하는 메소드
	public int totalScore() {
		return this.korean + this.english + this.math;
	}
	
	// 평균을 반환하는 메소드
	public float averageScore() {
		return (float)totalScore() / 3;
	}
	
	// 한 명의 정보를 출력하는 메소드
	public void printOne() {
		System.out.println(getName()
				+ "\t" + getKorean()
				+ "\t" + getEnglish() 
				+ "\t" + getMath() 
				+ "\t" + totalScore() 
				+ "\t" + averageScore());
	}
}
