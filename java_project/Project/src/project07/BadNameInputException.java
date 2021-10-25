package project07;

public class BadNameInputException extends Exception {

	public BadNameInputException() {
		super("영문자 또는 한글만 입력할 수 있습니다.");
	}
	
	public BadNameInputException(String message) {
		super(message);
	}
}
