package chapter11;

public class Person implements Comparable<Person> {

	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person p) {
		
		if(this.age > p.age) {
			return 1;	// 양수
		} else if(this.age < p.age) {
			return -1;	// 음수
		} else {
			// 나이가 같으면 이름의 사전순서로 -> 순서 바꾸려면 부호 바꾸기!			
			return this.name.compareTo(p.name);
		}
		
//		return this.age - p.age;	// this의 숫자가 크면 양수가 나옴. 같으면 0이 나옴. 작으면 음수가 나옴.
//		return -(this.age - p.age);	// 부호를 통해 내림차순으로 바꾸어줌
		
	}
	
}
