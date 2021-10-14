package chapter06;

public class Lotto {

	public static void main(String[] args) {
		
		// 1~45 까지의 숫자를 저장할 수 있는 배열 생성
		int[] ball = new int[45];
		
		// 각 배열의 요소에 1~45 의 숫자 저장
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		
		// 제대로 저장되었는지 출력하여 확인
		for(int i = 0; i< ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		// 0번 인덱스의 값을 저장할 임시변수
		int temp = 0;
		
		for(int i = 0; i < 10000; i++) {
			// 랜덤한 index - > 1~44
			int index = (int)(Math.random()*44) + 1; // 0.0 <= r < 44.0
			
			temp = ball[0];
			ball[0] = ball[index];
			ball[index] = temp;
		}
		
		System.out.println("=====숫자 섞은 후=====");
		for(int i = 0; i< ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		System.out.println("========결과========");
		// 배열 ball의 0~5번 인덱스 요소를 출력한다.
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + " ");
		}
	}

}
