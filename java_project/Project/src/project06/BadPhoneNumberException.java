package project06;

public class BadPhoneNumberException extends Exception {

	public BadPhoneNumberException() {
		super("올바른 전화번호 양식이 아닙니다. (예. 010-0000-0000)");
	}

	public BadPhoneNumberException(String message) {
		super(message);
	}

	
	
}
