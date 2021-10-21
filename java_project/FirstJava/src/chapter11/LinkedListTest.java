package chapter11;

// LinkedList : 다음 요소를 참조를 통해 연결
//	- 저장소 용량 늘리기가 용이하다
//	- 데이터 삭제가 쉽다 (참조 주소만 바꿔주면 됨)
//	- ArrayList보다 데이터 참조가 다소 불편하다.

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		// ArrayList<Integer> list = null;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
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
		
		// 정렬자 Iterator, 순서가 없는 set 등의 컬렉션을 쓸 때
		// 정렬자를 이용한 전체 출력
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
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
