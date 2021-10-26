package chapter12.notepad;
//콘솔기반으로 메모장 기능을 만들어 봅시다.
//①File 클래스를 이용해서 저장 폴더 생성
//②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
//③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
//④메모리스트와 파일 읽기 기능을 구현해봅시다.

import java.util.Calendar;

public class Note {

	Calendar writtenDate;
	String title;
	String content;
	
	public Note(String title, String content) {
		this.writtenDate = Calendar.getInstance();
		this.title = title;
		this.content = content;
	}
	
	public Note() {
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof Note) {
			Note n = (Note) obj;
			if(this.writtenDate.equals(n.writtenDate)) {
				result = true;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		
		
		
		return "Note [writtenDate=" + writtenDate + ", title=" + title + "]";
	}

	
	
}
