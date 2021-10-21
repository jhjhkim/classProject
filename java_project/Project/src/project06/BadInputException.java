package project06;

public class BadInputException extends Exception {

	public BadInputException() {
		super("유효하지 않은 입력입니다.");
	}
	
	public BadInputException(String message) {
		super(message + "은 유효하지 않은 입력입니다.");
	}
	
}
