package chapter13;

public class AccessThread extends Thread {

	IHaveTwoNum twoNum;
	
	// 주입
	public AccessThread(IHaveTwoNum twoNum) {
		this.twoNum = twoNum;
	}
	
	@Override
	public void run() {
		twoNum.addOneNum1();
		twoNum.addTwoNum1();
		
		twoNum.addOneNum2();
		twoNum.addTwoNum2();
	}	
	
}
