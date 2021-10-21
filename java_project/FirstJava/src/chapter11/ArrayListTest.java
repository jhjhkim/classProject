package chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = null;
		
		// list = new ArrayList<Integer>();
		list = new ArrayList<>();
		
		// 상위 타입으로 생성 가능하다 (다형성)
		List<Integer> list2 = new ArrayList<Integer>();
		
		// 데이터(인스턴스) 저장 : add(E e)
		list.add(new Integer("1"));
		list.add(10);
		list.add(13);
		list.add(5);
		list.add(1);
		
		// 리스트의 요소의 개수
		int size = list.size();
		System.out.println("요소의 개수: " + size);
		
		// for 이용 일괄 참조
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-----------------------");

		// for each
		for(Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-----------------------");
		
		// 반복자 Iterator, 순서가 없는 set 등의 컬렉션을 쓸 때
		// 반복자를 이용한 전체 출력
		Iterator<Integer> itr = list.iterator();
		
		// boolean hasNext() : 다음번 요소가 존재하면 true 반환
		while(itr.hasNext()) {
			
			// E next() : 다음번 요소 반환
			Integer i = itr.next();
			System.out.println(i);
		}
		
		System.out.println("-----------------------");
		
		// 요소 삭제
		list.remove(2);
		
		System.out.println("2번지 요소 삭제");
		System.out.println("-----------------------");
		
		for(Integer i : list) {
			System.out.println(i);
		}
		
		
		
	}

}
