package chapter11.football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FootballMain {
	
	public static void main(String[] args) {
		
		// FootballPlayer 인스턴스 생성
		FootballPlayer player1 = new FootballPlayer("ADAMS", 1, "England", 20);
		FootballPlayer player2 = new FootballPlayer("BRONKS", 4, "France", 33);
		FootballPlayer player3 = new FootballPlayer("CHARLES", 7, "Germany", 27);
		FootballPlayer player4 = new FootballPlayer("DAVID", 3, "England", 30);
		FootballPlayer player5 = new FootballPlayer("BRONKS", 5, "France", 23);
		
		// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		List<FootballPlayer> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		list.add(player4);
		list.add(player5);

		System.out.println("List<E> 를 이용한 출력");
		for(FootballPlayer p : list) {
			System.out.println(p);
		}
		
		System.out.println("============================");

		// 2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록
		// Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		System.out.println("Set<E> 를 이용한 출력");
		
		Set<FootballPlayer> hashSet = new HashSet<FootballPlayer>();
		hashSet.add(player1);
		hashSet.add(player2);
		hashSet.add(player3);
		hashSet.add(player4);
		hashSet.add(player5);
		
		System.out.println("선수의 수: " + hashSet.size());
		
		// player1과 팀, 이름, 나이가 같은 선수를 추가할 때	
		hashSet.add(new FootballPlayer("ADAMS", 10, "England", 20));
		
		System.out.println("추가 후: " + hashSet.size());
		
		Iterator<FootballPlayer> itr = hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("============================");
		
		System.out.println("TreeSet<E> 를 이용한 출력");
		
		// 3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		Set<FootballPlayer> treeSet = new TreeSet<FootballPlayer>();
		treeSet.add(player1);
		treeSet.add(player2);
		treeSet.add(player3);
		treeSet.add(player4);
		treeSet.add(player5);
		
		itr = treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("============================");
		
		System.out.println("Map<K,V> 를 이용한 출력");
		
		// 4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
		Map<Integer, FootballPlayer> map = new HashMap<Integer, FootballPlayer>();
		
		// player6 : player1과 팀, 이름, 나이가 같을 때 (key값인 번호는 다를 때)
		FootballPlayer player6 = new FootballPlayer("ADAMS", 10, "England", 20);
		// player7 : player1과 팀, 이름, 나이는 다르지만 key값인 번호가 같을 때
		FootballPlayer player7 = new FootballPlayer("JAMES", 1, "Hungary", 21);
		
		map.put(player1.number, player1);
		map.put(player2.number, player2);
		map.put(player3.number, player3);
		map.put(player4.number, player4);
		map.put(player5.number, player5);
		map.put(player6.number, player6);
		map.put(player7.number, player7);
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> itr2 = set.iterator();
		
		while(itr2.hasNext()) {
			System.out.println(map.get(itr2.next()));
		}
		
		System.out.println("----------------------------");
		System.out.println("entrySet() 을 이용한 출력");
		
		// entrySet(): (key, value) 형식 그대로 데이터를 가져오는 메소드
		for(Map.Entry<Integer, FootballPlayer> p : map.entrySet()) {
			System.out.println(p);
		}
	}

}
