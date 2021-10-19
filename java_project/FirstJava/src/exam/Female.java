package exam;

public class Female extends Person {

	String name;
	String idNumber;
	String gender;
	
	public Female(String name, String idNumber) {
		super(name, idNumber);
		this.gender = "여자";
	}

	@Override
	public void hello() {
		super.hello();
		System.out.println(this.gender + "입니다.");
	}
}
