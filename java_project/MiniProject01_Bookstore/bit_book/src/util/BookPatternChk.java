package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookPatternChk {
	Pattern p;
	Matcher m;

	String rexBookName = "^[!-~가-힣]{1,20}$";	// 책 이름 : 최대 20글자
	String rexWriter = "^[A-Za-z.,가-힣]{1,12}$";	// 저자 이름 : 최대 12글자
	String rexPublisher = "^[A-Za-z0-9&가-힣]{1,10}$";	// 출판사 이름 : 최대 10글자
	
	public boolean bookNameForm(String bookName) {
		boolean result = false;

		p = Pattern.compile(rexBookName);
		m = p.matcher(deleteBlank(bookName));
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean writerForm(String writer) {
		boolean result = false;

		p = Pattern.compile(rexWriter);
		m = p.matcher(deleteBlank(writer));
		if (m.matches()) {
			result = true;
		}

		return result;
	}
	
	public boolean publisherForm(String publisher) {
		boolean result = false;

		p = Pattern.compile(rexPublisher);
		m = p.matcher(deleteBlank(publisher));
		if (m.matches()) {
			result = true;
		}

		return result;
	}
	
	// 공백 제거
		public String deleteBlank(String a) {
			return a.replace(" ", "");
		}
	
}
