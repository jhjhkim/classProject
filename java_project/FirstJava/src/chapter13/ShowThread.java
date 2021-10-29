package chapter13;

public class ShowThread extends Thread {

	String threadName;
	
	public ShowThread(String name) {
		this.threadName = name;
	}
	
	@Override
	public void run() {
		// 새로운 스레드의 실행 메소드 : 메인 스레드에서 직접 호출하지 않는다!!!
		for(int i = 0; i < 100; i++) {
			System.out.println("안녕하세요. " + this.threadName + "입니다.");		
			
			// 스레드 제어 메소드 : sleep(ms) -> 매개변수 1/1000초 단위 (밀리세컨드)
			// 				매개변수로 전달된 시간만큼 블록 상태가 된다.
			//				조건이 만족하면 (지정된 시간이 지나면) 실행 가능상태로 전환된다.
			
			try {
				sleep(100/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	
}