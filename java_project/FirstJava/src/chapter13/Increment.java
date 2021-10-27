package chapter13;

public class Increment {
	
	int num;
	
	public synchronized void increment() {
		// synchronized : 동기화 처리 -> 이 메소드가 시작될 때 다음 스레드에서 객체를 사용하지 못하도록
		num++;
	}
	
	public int getNum() {
		return num;
	}

}
