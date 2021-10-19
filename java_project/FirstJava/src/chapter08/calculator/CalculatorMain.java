package chapter08.calculator;

public class CalculatorMain {

	public static void main(String[] args) {
		
		long n1 = 48;
		long n2 = 37;
		
		Calculator c = new CalculatorClass();
		
		System.out.println(n1 + " + " + n2 + " = " + c.add(n1, n2));
		System.out.println(n1 + " - " + n2 + " = " + c.substract(n1, n2));
		System.out.println(n1 + " * " + n2 + " = " + c.multiply(n1, n2));
		System.out.println(n1 + " / " + n2 + " = " + c.divide(n1, n2));
		
	}
	
}
