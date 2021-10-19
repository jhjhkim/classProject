package exam;

public class PersonMain {
	
	public static void main(String[] args) {
		Person p1 = new Male("홍길동", "990101-1234567");
		Person p2 = new Female("허초희", "011231-4567890");
		Male m1 = new Male("김철수", "030505-3456789");
		Female f1 = new Female("김영희", "881010-2345678");
		
		p1.hello();
		p2.hello();
		m1.hello();
		f1.hello();
	}
}
