package chapter08.calculator;

//2. Calculator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
//3.다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시다.
public class CalculatorClass extends AbstractCalculator implements Calculator {

	long n1;
	long n2;
	
	public CalculatorClass(long n1, long n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1 / n2;
	}
	
	@Override
	public void showResult() {
		System.out.println(n1 + " + " + n2 + " = " + add(n1, n2));
		System.out.println(n1 + " - " + n2 + " = " + substract(n1, n2));
		System.out.println(n1 + " * " + n2 + " = " + multiply(n1, n2));
		System.out.println(n1 + " / " + n2 + " = " + divide(n1, n2));
	}
	
}
