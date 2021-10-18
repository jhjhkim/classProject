package chapter07;

public class HybridWaterCar extends HybridCar {
	int waterGauge;
	
	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
		super(gasolinegauge, electronicGauge); // 2. 상위 클래스의 생성자 호출
		this.waterGauge = waterGauge; // 6. 변수 초기화
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린: " + gasolinegauge);
		System.out.println("잔여 전기: " + electronicGauge);
		System.out.println("잔여 물: " + waterGauge);
	}
	
	public static void main(String[] args) {
		HybridWaterCar hdCar = new HybridWaterCar(10, 20, 30); // 1. 생성자 호출
		hdCar.showCurrentGauge();
		
		System.out.println("Car.door: " + Car.door);
		System.out.println("HybridCar.door: " + HybridCar.door);
		System.out.println("HybridWaterCar.door: " + HybridWaterCar.door);
	}
}

class HybridCar extends Car {
	int electronicGauge;
	
	// 상속관계에서 상위 클래스에 생성자가 존재하면 생성자를 호출해주어야 한다.
	// 상위 클래스의 변수를 초기화해야 하기 때문에 초기화할 변수 값을 받아서 상위 클래스의 생성자를 호출!
	HybridCar(int gasolinegauge, int electronicGauge){
		super(gasolinegauge); // 3. 상위 클래스의 생성자 호출
		this.electronicGauge = electronicGauge; // 5. 변수의 초기화
	}
}

class Car {
	
	static int door = 5;
	
	int gasolinegauge;
	
	// Car 클래스의 변수를 초기화하는 생성자
	Car(int gasolinegauge){
		this.gasolinegauge = gasolinegauge; // 생성자 실행
	}
}