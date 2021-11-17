package exception;

public class NullInputException extends Exception {

	public NullInputException(String message) {
		super(message);
	}
	
	public NullInputException() {
		super("공백은 입력할 수 없습니다.");
	}
	
}
