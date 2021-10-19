package project03;

public class SmartPhone {

	Contact[] array;
	int numOfContact;
	final static int ARRAY_SIZE = 10; // 기본 배열 길이
	
	// 배열의 길이를 파라미터로 갖는 생성자
	public SmartPhone(int size) {
		array = new Contact[size];
		numOfContact = 0;
	}
		
	// 기본 생성자
	public SmartPhone() {
		this(ARRAY_SIZE);
	}

	// 연락처 등록 메소드
	public void add(Contact c) {
		array[numOfContact++] = c;
	}
	
	// 목록 보기
	public void showList() {
		System.out.println("-----------------------");
		for(int i = 0; i < numOfContact; i++) {
			array[i].showBasicInfo();
			System.out.println("-----------------------");
		}
	}
	
	// 검색
	
	// 삭제
	
	// 수정
	
	
}
