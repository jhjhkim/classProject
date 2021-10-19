package chapter08.calculator;

// 1.Calculator 인터페이스를 상속하는 추상 클래스를 정의해봅시다.
public abstract class AbstractCalculator implements Calculator {
	
	public abstract long add(long n1, long n2);
	public abstract long substract(long n1, long n2);
	public abstract long multiply(long n1, long n2);
	public abstract double divide(double n1, double n2);
	
	public abstract void showResult();
	
}
