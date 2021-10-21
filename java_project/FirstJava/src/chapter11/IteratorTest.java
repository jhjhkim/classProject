package chapter11;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		Iterator<String> itr = list.iterator();
		
		System.out.println("반복자를 이용한 1차 출력과 Third 삭제");
		System.out.println("-------------------------------");
		
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
			
			if(str.compareTo("Third") == 0) {
				itr.remove();
			}
		}
		
		System.out.println("-------------------------------");
		
		System.out.println("Third 제거 후 리스트");
		
		System.out.println("-------------------------------");
		
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
}
