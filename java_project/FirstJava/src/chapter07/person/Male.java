package chapter07.person;

public class Male extends Person {

	String name;
	String idNumber;
	String gender;
	
	public Male(String name, String idNumber) {
		super(name, idNumber);
		this.gender = "남자";
	}

	@Override
	public void hello() {
		super.hello();
		System.out.println(this.gender + "입니다.");
	}
}
