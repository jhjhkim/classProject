package chapter07;

public class BaseEnSpeaker extends Speaker {

	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	// 오버라이딩
	// 상위 클래스의 메소드의 선언부를 일치시키고
	// 처리부를 변경하는 것!
	// 상속받은 메소드의 내용을 변경 (change, modify)
	
	// @에노테이션
	// @Override : 상위 클래스의 메소드를 오버라이딩한다!
	// 			      오버라이딩의 규칙에 맞게 정의하는지 체크
	@Override
	public void showCurrentState() {
		super.showCurrentState();
		System.out.println("베이스 크기: " + baseRate);
	}
	
	public static void main(String[] args) {
	
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		bSpeaker.showCurrentState();
		
		System.out.println("===============================");
		
		Speaker speaker = new Speaker();
		speaker.showCurrentState();
		
		// 다형성
		// 상위 타입의 참조변수 = 하위 타입의 인스턴스
		// 참조변수의 타입에 정의된 멤버만 사용이 가능
		Speaker sp = new BaseEnSpeaker();
		sp.showCurrentState();  // new 해야 메모리에 올라가는 것! BaseEnSpeaker 타입의 메소드가 실행된다
		// sp.setBaseRate(100);	// Speaker타입 변수로 쓰겠다고 선언했으므로 BaseEnSpeaker의 멤버에는 접근할 수 없다!
		
	}
		
}
