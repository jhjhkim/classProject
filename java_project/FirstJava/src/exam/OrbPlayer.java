package exam;
// 다음조건을 만족하는 클래스를 구성하자. 구슬치기와 딱지치기
// 어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다.
// 놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재한다.
// 두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
// 조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자.
// 어린이 1의 보유자산  구슬 15개
// 어린이 2의 보유자산  구슬 9개
// 인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션하자.
// “1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
// “2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
// 마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료

public class OrbPlayer {
	int numofOrb;	// 소유한 구슬의 개수

	// 기본 생성자
	public OrbPlayer() {}
	
	// number 개의 구슬을 가지고 시작하는 생성자
	public OrbPlayer(int number) {
		numofOrb = number;
	}
	
	// 구슬치기의 과정에서 구슬을 주고받는다.
	// 상대로부터 number 개의 구슬을 얻을 때
	public void win(OrbPlayer player, int number) {
		this.numofOrb += number;
		player.numofOrb -= number;
	}
	
	public static void main(String[] args) {
		OrbPlayer player1 = new OrbPlayer(15);
		OrbPlayer player2 = new OrbPlayer(9);
		
		System.out.println("구슬치기 전");
		System.out.println("어린이1의 보유 구슬: " + player1.numofOrb);
		System.out.println("어린이2의 보유 구슬: " + player2.numofOrb);
		
		System.out.println("----------------------");
				
		System.out.println("1차 게임 : 어린이 1은 어린이 2의 구슬 2개를 획득한다.");
		player1.win(player2, 2);
		System.out.println("어린이1의 보유 구슬: " + player1.numofOrb);
		System.out.println("어린이2의 보유 구슬: " + player2.numofOrb);
		
		System.out.println("----------------------");
		
		System.out.println("2차 게임 : 어린이 2는 어린이 1의 구슬 7개를 획득한다.");
		player2.win(player1, 7);
		System.out.println("어린이1의 보유 구슬: " + player1.numofOrb);
		System.out.println("어린이2의 보유 구슬: " + player2.numofOrb);
	}
}
