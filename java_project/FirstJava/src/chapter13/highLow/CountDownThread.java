package chapter13.highLow;

public class CountDownThread extends Thread {

	@Override
	public void run() {
		
		for(int i = 30; i >= 0; i--) {
			if(HighLowGame.inputSwitch) {
				System.out.println("정답을 맞히셨습니다. 카운트다운을 중단합니다.");
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("미션 실패! 30초 안에 맞히지 못했습니다. 프로그램을 종료합니다.");
		
	}
	
}
