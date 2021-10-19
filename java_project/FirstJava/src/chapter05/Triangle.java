package chapter05;
// 밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
// 끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 
// 삼각형의 넓이를 계산해서 반환하는 메서드도 함께 정의하자.
public class Triangle {
	double base;	// 밑변
	double height;	// 높이
	
	public void updateBase(double newBase) {
		base = newBase;
	}
	
	public void updateHeight(double newHeight) {
		height = newHeight;
	}
	
	public double calculateArea() {
		return (double)base * height / 2;
	}
	
	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		triangle.base = 4.5;
		triangle.height = 6;
		System.out.println("삼각형의 밑변 길이: " + triangle.base);
		System.out.println("삼각형의 높이: " + triangle.height);
		System.out.println("삼각형의 넓이: " + triangle.calculateArea());
		
		System.out.println("---------------------");
		
		triangle.base = 5.5;
		triangle.height = 3;
		System.out.println("삼각형의 밑변 길이: " + triangle.base);
		System.out.println("삼각형의 높이: " + triangle.height);
		System.out.println("삼각형의 넓이: " + triangle.calculateArea());
		
	}
}
