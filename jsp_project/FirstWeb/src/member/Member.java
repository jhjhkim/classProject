package member;

public class Member {

	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getHello() {
		return "안녕하세요! Member 객체의 getHello() 메소드가 호출되었습니다.";
	}
	
}
