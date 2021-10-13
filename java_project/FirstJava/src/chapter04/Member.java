package chapter04;
//	앞에서 만든 Member 클래스에 아래 요구사항에 맞는 메소드를 정의하고, main()메소드에 해당 메소드를 호출해서 결과를 확인해보세요.
//	메소드의 이름도 JAVA의 규칙에 맞게 정의해 봅시다. 

import java.util.Calendar;
import java.util.Scanner;

public class Member {

//	final int BASE_YEAR = 2021;		// 기준연도 (올해)
	final int BASE_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	final int AGE_VACCINE1 = 15;	// 무료예방접종 기준
	final int AGE_VACCINE2 = 65;	// 무료예방접종 기준
	final int AGE_CHECKUP1 = 20;	// 무료건강검진 기준 (성인)
	final int AGE_CHECKUP2 = 40;	// 무료암검진 기준
	
	String name;
	int birthYear;
	int age;
	
	// shift+alt+s -> Generate Constructor using fields
//	public Member(String name, int birthYear, int age) {
//		this.name = name;
//		this.birthYear = birthYear;
//		this.age = age;
//	}

	// 매개변수 있는 생성자. 이름 데이터를 받아서 초기화
	Member(String name, int birthYear){
		this.name = name;
		this.birthYear = birthYear;
//		age = BASE_YEAR - year;
		age = ageCal(birthYear);
	}
	
	Member(int year){
//		birthYear = year;
//		age = ageCal(year);
		this(null, year);
	}
	
	// 기본 생성자
	Member(){}
	
//	① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
//	- 매개변수로 태어난 해(년도)를 전달받습니다.
//	- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
//	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
	public void checkVaccine() {
		// 만 나이 구하기
		int age = BASE_YEAR - birthYear;
		
		if(age < AGE_VACCINE1 || age >= AGE_VACCINE2) {
			System.out.println("무료 예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}
	
//	② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
//	- 매개변수로 태어난 해(년도)를 전달받습니다.
//	- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
//	- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
//	- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
	public void checkCheckUp() {
		int age = BASE_YEAR - birthYear;
		
		if(age >= AGE_CHECKUP1) {
			
			if((birthYear % 2) == (BASE_YEAR % 2)) {
				System.out.println("올해 무료 건강검진 대상입니다.");
				
				if(age >= AGE_CHECKUP2) {
					System.out.println("무료 암검진이 가능합니다.");
				}
				
			} else {
				System.out.println("올해 무료 검진 대상이 아닙니다.\n내년에 무료 건강검진이 가능합니다.");
			}
			
		} else {
			System.out.println("미성년자입니다.\n무료 건강검진은 성인에게 제공됩니다.");
		}
	}
	
	// 나이 연산하는 메소드
	int ageCal(int year) {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Member member = new Member();
//		int year = 2000;
		member.birthYear = 2000;
		
		member.checkVaccine();
		System.out.println("-------------------------------");
		member.checkCheckUp();
		
		System.out.println("\n================================\n");
		
		member = new Member("손흥민", 1981);
		System.out.println("이름: " + member.name);
		member.checkVaccine();
		member.checkCheckUp();
		
		scanner.close();
	}
	
}
