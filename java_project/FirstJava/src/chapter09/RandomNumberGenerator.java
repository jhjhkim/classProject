package chapter09;

import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		
		// (int)(Math.random()*10)+1 -> 1~10
		Random r1 = new Random();
		
		for(int i = 0; i < 10; i++) {
			// 1~10
			int num1 = r1.nextInt(10) + 1;
			System.out.print(num1 + " ");
		}
		
		System.out.println("\n=====================");
		
		Random r2 = new Random(1);
		
		for(int i = 0; i < 10; i++) {
			// 1~10
			int num1 = r2.nextInt(10) + 1;
			System.out.print(num1 + " ");
		}
		
		System.out.println("\n=====================");
		
		Random r3 = new Random(1);
		
		for(int i = 0; i < 10; i++) {
			
			// long num = System.currentTimeMillis();
			long num = System.nanoTime();
			
			r3.setSeed(num);
			
			// 1~10
			int num1 = r3.nextInt(10) + 1;
			System.out.print(num1 + " ");
		}
				
	}
}
