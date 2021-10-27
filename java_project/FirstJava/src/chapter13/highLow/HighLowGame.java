package chapter13.highLow;

import java.util.Random;
import java.util.Scanner;

// 1.10초 안에 맞추는 하이로우 게임을 만들어 봅시다.
// ①1~100 사이의 랜덤 한 숫자를 추출합니다.
// ②사용자에게 숫자를 입력 받고, 랜덤 숫자와 비교하고, 높은 숫자인지 낮은 숫자인지 출력
// ③30초 카운팅은 스레드를 이용해서 처리해봅시다.
// ④30초 이전에 맞추면 미션 성공, 30초가 지나면 프로그램 종료하는 흐름으로 만들어봅시다.

public class HighLowGame {

	static boolean inputSwitch = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CountDownThread thread = new CountDownThread();

		// 1. 1~100 사이의 랜덤한 숫자를 추출
		Random r = new Random();
		int number = r.nextInt(100) + 1;

		thread.start();
		
		// 2. 사용자에게 숫자를 입력 받기
		System.out.println("숫자를 맞혀보세요. >>>");
		
		int userNumber = Integer.parseInt(sc.nextLine());

		while (!inputSwitch) {

			// 3. 추출한 숫자와 사용자의 숫자를 비교하여 출력
			if (userNumber > number) {
				System.out.println("UP! 더 낮은 숫자를 적어보세요. >>>");
			} else if (userNumber < number) {
				System.out.println("DOWN! 더 높은 숫자를 적어보세요. >>>");
			} else if (userNumber == number) {
				System.out.println("정답입니다!");
				inputSwitch = true;
				break;
			}

			userNumber = Integer.parseInt(sc.nextLine());
			
		}
		
		sc.close();
	}

}
