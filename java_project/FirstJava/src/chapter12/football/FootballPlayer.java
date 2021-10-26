package chapter12.football;

import java.io.Serializable;

public class FootballPlayer implements Comparable<FootballPlayer>, Serializable {
	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return this.age % 10;
	}

	// 팀, 이름, 나이가 같으면 같은 선수로 판단하도록 equals() 오버라이드
	@Override
	public boolean equals(Object o) {
		boolean result = false;

		FootballPlayer p = (FootballPlayer) o;
		if (this.team.equals(p.team) && this.name.contentEquals(p.name) && this.age == p.age) {
			result = true;
		}
		return result;
	}

	// 팀 이름순 -> 선수 이름순 -> 번호순 정렬
	@Override
	public int compareTo(FootballPlayer p) {
		int result = 0;

		result = this.team.compareTo(p.team); // 팀 이름 비교

		if (result == 0) {
			result = this.name.compareTo(p.name); // 선수 이름 비교

			if (result == 0) {
				result = this.number - p.number; // 번호 비교
			}
		}
		return result;
	}

	// 선수의 정보를 출력하는 toString()
	@Override
	public String toString() {
		return "[" + this.team + "] " + this.name + " (" + this.number + "번, " + this.age + "세)";
	}

}
