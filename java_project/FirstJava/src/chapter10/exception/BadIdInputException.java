package chapter10.exception;

public class BadIdInputException extends Exception {

	public BadIdInputException() {
		super("유효하지 않은 아이디입니다. 영문자와 숫자만 입력할 수 있습니다.");
	}
	
	public BadIdInputException(String username) {
		super(username + "은 유효한 아이디가 아닙니다.");
	}
	
}
