package chapter07.person;

import java.util.Calendar;

//1.Person 이라는 클래스를 정의해봅시다.
//①이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//②인사하는 메소드를 정의해봅시다.
//- “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.
public class Person {

	String name;		// 이름
	String idNumber;	// 주민번호: 가운데 -가 있는 14자리 문자열
	
	final static int THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	public Person(String name, String idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}
	
	public int ageCal() {
		
		int birthYear = Integer.parseInt(idNumber.substring(0, 2));	// 주민번호의 첫 두자리(생년)
		int checkCentury = Integer.parseInt(idNumber.substring(7, 8));	// 주민번호의 7번째 자리(1, 2, 3, 4)

		if(checkCentury == 1 || checkCentury == 2) {
			return THIS_YEAR - (1900 + birthYear);		// 7번째 숫자가 1, 2이면 20세기 출생
		} else if(checkCentury == 3 || checkCentury == 4) {
			return THIS_YEAR - (2000 + birthYear);		// 7번째 숫자가 3, 4이면 21세기 출생
		} else {
			return -1;	// 잘못된 주민번호의 경우
		}
	}
	
	public void hello() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + this.ageCal()+ "살 입니다.");
	}
	
}
