package chapter04;
//	앞에서 만든 Member 클래스에 아래 요구사항에 맞는 메소드를 정의하고, main()메소드에 해당 메소드를 호출해서 결과를 확인해보세요.
//	메소드의 이름도 JAVA의 규칙에 맞게 정의해 봅시다. 

import java.util.Calendar;
import java.util.Scanner;

public class Member {

//	final int BASE_YEAR = 2021;		// 기준연도 (올해)
	final int BASE_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	final int AGE_STANDARD1 = 15;	// 나이기준 1 : 무료예방접종 기준
	final int AGE_STANDARD2 = 20;	// 나이기준 2 : 성인, 무료건강검진 기준
	final int AGE_STANDARD3 = 40;	// 나이기준 3 : 무료암검진 기준
	final int AGE_STANDARD4 = 65;	// 나이기준 4 : 무료예방접종 기준
	
//	① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
//	- 매개변수로 태어난 해(년도)를 전달받습니다.
//	- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
//	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
	public void checkVaccine(int birthYear) {
		// 만 나이 구하기
		int age = BASE_YEAR - birthYear;
		
		if(age < AGE_STANDARD1 || age >= AGE_STANDARD4) {
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
	public void checkCheckUp(int birthYear) {
		int age = BASE_YEAR - birthYear;
		
		if(age >= AGE_STANDARD2) {
			
			if((birthYear % 2) == (BASE_YEAR % 2)) {
				System.out.println("올해 무료 건강검진 대상입니다.");
				
				if(age >= AGE_STANDARD3) {
					System.out.println("무료 암검진이 가능합니다.");
				}
				
			} else {
				System.out.println("올해 무료 검진 대상이 아닙니다.\n내년에 무료 건강검진이 가능합니다.");
			}
			
		} else {
			System.out.println("미성년자입니다.\n무료 건강검진은 성인에게 제공됩니다.");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Member member = new Member();
		
		System.out.println("출생연도를 4자리 정수로 입력해주세요. (예: 1960)");
		System.out.print("> ");
		int birthYear = Integer.parseInt(scanner.nextLine());
		
		member.checkVaccine(birthYear);
		System.out.println("-------------------------------");
		member.checkCheckUp(birthYear);
		
		scanner.close();
	}
	
}
