package chapter08;

import java.io.Serializable;
// Serializable : 마킹의 효과, 없으면 파일의 형태로 저장되지 않는다 (뒤에서 배울 내용...)

public class PointTwo implements Serializable {

	private int xPos;
	private int yPos;
	
	PointTwo(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	@Override
	public String toString() {
		return "PointTwo [xPos=" + xPos + ", yPos=" + yPos + "]";
	}
	
}
