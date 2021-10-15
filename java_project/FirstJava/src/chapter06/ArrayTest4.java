package chapter06;
// 1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고,
// 평균 점수를 출력하는 프로그램을 작성해봅시다.
// 2차원 배열을 만들고 Math.random() 을 이용하여 50~100점 사이의 랜덤한 점수를 넣습니다.

public class ArrayTest4 {
	public static void main(String[] args) {
		
		// 배열 생성
		int[][] score = new int[10][3];
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				// 0.0 <= Math.random() < 1.0
				// 0.0 <= Math.random() * 100 < 100.0
				// 0.0 <= Math.random() * 100 % 50 < 50.0
				// 50.0 <= Math.random() * 100 % 50 + 50 < 100.0
				double num = Math.random() * 100 % 50 + 50;
				score[i][j] = (int)num;
			}
		}
		
		// 배열 출력
		System.out.println("\t국어\t영어\t수학");
		System.out.println("-----------------------------");
		for(int i = 0; i < score.length; i++) {
			System.out.print("\t");
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------");
		
		// 각 과목의 총점 구하기
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		
		for(int i = 0; i < score.length; i++) {
			totalKor += score[i][0];
		}
		
		for(int i = 0; i < score.length; i++) {
			totalEng += score[i][1];
		}
		
		for(int i = 0; i < score.length; i++) {
			totalMath += score[i][2];
		}
		
		// 총점 출력하기
		System.out.println("총점\t" + totalKor + "\t" + totalEng + "\t" + totalMath);
		
		System.out.println("-----------------------------");
		
		// 각 과목의 평균점수 구하기
		double aveKor = (double) totalKor / score.length;
		double aveEng = (double) totalEng / score.length;
		double aveMath = (double) totalMath / score.length;
		
		// 평균점수 출력하기
		System.out.println("평균\t" + aveKor + "\t" + aveEng + "\t" + aveMath);
	}
}
