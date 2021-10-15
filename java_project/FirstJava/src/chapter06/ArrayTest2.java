package chapter06;
// 2차원 배열
// 1차원 배열을 구성요소로 갖는 1차원 배열
// 사실... 2차원 배열을 만드는 것보다는 class를 만들어서
// 그 클래스 변수를 구성요소로 갖는 1차원 배열을 만드는 것이 더 다루기 편하다.

public class ArrayTest2 {
	public static void main(String[] args) {
		// 2차원 배열의 선언
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13 } };

		System.out.println("2차원 배열 출력");
		addOneDArr(arr, 100);
	}

	public static void addOneDArr(int[][] arr, int add) {

		// 2차원 배열의 출력
		// 행
		for (int i = 0; i < arr.length; i++) {

			// 열
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}

			System.out.println();
		}

		// 매개변수로 전달받은 숫자를 각 요소에 더해준다.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
		
		System.out.println("\n===============각 요소에 숫자를 더함===============");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
