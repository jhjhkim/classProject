package chapter13;

public class ThreadTest2 {

	public static void main(String[] args) {
		
		// Runnable 타입의 객체를 생성하고 -> 해당 객체를 이용해서 Thread 객체를 생성
		AdderThread adderThread1 = new AdderThread(1, 50);
		AdderThread adderThread2 = new AdderThread(51, 100);
		
		// Thread 인스턴스 생성
		Thread t1 = new Thread(adderThread1);
		Thread t2 = new Thread(adderThread2);
		t1.start();
		t2.start();
		
		// 스레드가 실행될 시간을 주기 위해 join() 메소드를 쓴다.
		// join() : 해당 스레드가 종료될 때까지 이 문장이 끝나지 않는다 . (다음 코드로 진행되지 않는다.)
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100의 합: " + (adderThread1.getNum() + adderThread2.getNum()));
		
	}
	
}
