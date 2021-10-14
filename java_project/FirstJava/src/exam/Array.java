package exam;

import java.util.Scanner;

// 문제 1.
	// int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
	// 그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
	// public static int miniValue(int[] arr) { . . . . } // 최소값 반환
	// public static int maxValue(int[] arr) { . . . . } // 최대값 반환
	// 위의 두 메소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
	// 두 메소드 실행을 확인인하기 위한 main 메소드 정의.
	// int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정

public class Array {
	
	static final int ARRAY_SIZE = 5;	// 배열의 길이를 정하는 상수
	
	public static int miniValue(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {

			int temp;	// 임시로 값을 저장할 변수
			
			// 오름차순으로 저장된 값을 배열
			if(arr[i] > arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				
				i = -1;
			}
		}
		
		return arr[0];	// 가장 작은 값인 0번 인덱스를 리턴
	}
	
	public static int maxValue(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {

			int temp;	// 임시로 값을 저장할 변수
			
			// 내림차순으로 저장된 값을 배열
			if(arr[i] < arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				
				i = -1;
			}
		}
		
		return arr[0];		// 가장 큰 값인 0번 인덱스를 리턴
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// 사용자 입력을 위한 스캐너 변수
		
		int[] arr = new int[ARRAY_SIZE];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println((i+1) + "번째 정수를 입력해주세요.");
			System.out.print("> ");
			arr[i] = Integer.parseInt(scanner.nextLine());
		}
		
		int min = miniValue(arr);
		int max = maxValue(arr);
		
		System.out.println("배열에 저장된 최소값: " + min);
		System.out.println("배열에 저장된 최대값: " + max);
		
		scanner.close();
	}
	
}
