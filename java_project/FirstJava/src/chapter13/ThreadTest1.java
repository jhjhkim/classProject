package chapter13;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		// 스레드 인스턴스 생성
		ShowThread t1 = new ShowThread("멋진 스레드");
		ShowThread t2 = new ShowThread("         예쁜 스레드");
		
		// 스레드 실행 : run() 직접 호출하는 경우에는 스레드 환경(새로운 작업)이 생성되지 않는다!!! 주의할 것
		t1.start();
		t2.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("----------------메인 스레드");
			try {
				Thread.sleep(100/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
