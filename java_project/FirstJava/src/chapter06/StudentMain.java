package chapter06;

public class StudentMain {
	private Student[] scoreArray;
	
	public StudentMain() {
		scoreArray = new Student[10];
	}
	
	// 메인메소드
	public static void main(String[] args) {
		StudentMain main = new StudentMain();
		
		// 랜덤하게 학생 정보 생성		
		for(int i = 0; i < main.scoreArray.length; i++) {
			Student s = new Student();
			s.setName("학생"+(i+1));
			s.setKorean((int)(Math.random()*51)+50);
			s.setEnglish((int)(Math.random()*51)+50);
			s.setMath((int)(Math.random()*51)+50);
			main.scoreArray[i] = s;
		}
		
		main.printAll();
		
	}
	

	
	// 배열의 모든 student 변수를 출력하는 메소드
	public void printAll() {
		System.out.println("이름\t국어\t영어\t수학\t학생총점\t학생평균");
		System.out.println("---------------------------------------------");
		
		for(Student s : scoreArray) {
			s.printOne();
		}
		
		System.out.println("---------------------------------------------");
		
		float korAve = korSum()/10.0f;
		float engAve = engSum()/10.0f;
		float mathAve = mathSum()/10.0f;
		
		System.out.println("과목총점\t" + korSum() + "\t" + engSum() + "\t" + mathSum());
		System.out.printf("과목평균\t%.2f \t%.2f \t%.2f", korAve, engAve, mathAve);
	}
	
	// 과목별 총점을 반환하는 메소드
	public int korSum() {
		int result = 0;
		for(int i = 0; i < scoreArray.length; i++) {
			result += scoreArray[i].getKorean();
		}
		return result;
	}
	
	public int engSum() {
		int result = 0;
		for(int i = 0; i < scoreArray.length; i++) {
			result += scoreArray[i].getEnglish();
		}
		return result;
	}
	
	public int mathSum() {
		int result = 0;
		for(int i = 0; i < scoreArray.length; i++) {
			result += scoreArray[i].getMath();
		}
		return result;
	}
}
