package chapter06;
// for-each문
// for(배열의 각각의 구성요소 : 반복의 대상이 되는 배열) {
//	}
// 예. for(int e : arr) {
//		System.out.print(e + "\t");
//		}
// 배열의 일부가 아닌 전체를 참조할 필요가 있는 경우,
// 값의 참조를 목적으로 할 때 (값의 변경이 반영되지 않는다!)

public class ForEach {
	public static void main(String[] args) {
		int[] arr = {100, 240, 180, 60, 150, 90, 30, 200};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("=======for-each문======");
		
		for(int num : arr) {
			System.out.println(num);
		}
	}
}
