package chapter06;

public class ArrayTest {
	
	public static void main(String[] args) {
		int[] arr = {100, 240, 180, 60, 150, 90, 30, 200};
		
		System.out.println("최대값: " + maxValue(arr));
		System.out.println("최소값: " + miniValue(arr));
	}
	
	// 최소값 메소드
	public static int miniValue(int[] arr) { 
		
		int minVal = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			
			if(arr[i] < minVal){
				minVal = arr[i];
			}
		}
		
		return minVal;
	}
	
	// 최대값 메소드
	public static int maxValue(int[] arr) { 
		int maxVal = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}
		
		return maxVal;
	}

}
