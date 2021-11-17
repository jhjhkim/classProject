package util;

import java.util.Scanner;
import exception.NullInputException;

public class ScannerUtil {

	static Scanner sc = new Scanner(System.in);

	public static String scanString() {
		return sc.nextLine();
	}

	static public int scanInt() {
		int result = 0;
		while(true) {
			try {
				result = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.print("숫자를 입력하셔야 합니다. 다시 한 번 입력해주세요.\n> ");
			}
		}
		return result;
	}

	// 공백 입력을 예외처리하여 다시 입력받는 getString() 메소드
	static public String getString() {
		String result = null;
		while (true) {
			result = sc.nextLine().trim();

			if (result.length() == 0) {
				NullInputException ne = new NullInputException();

				try {
					throw ne;
				} catch (NullInputException e) {
					System.out.print(e.getMessage() + " 다시 한 번 입력해주세요. \n> ");
				}
			} else {
				break;
			}
		}
		return result;
	}

}
