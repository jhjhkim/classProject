package chapter12.notepad;
//콘솔기반으로 메모장 기능을 만들어 봅시다.
//①File 클래스를 이용해서 저장 폴더 생성
//②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
//③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
//④메모리스트와 파일 읽기 기능을 구현해봅시다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class NoteManager {

	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Note> list;	// 파일 저장할 리스트
	File newDir;		// 파일 저장 폴더
	SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd HH:mm:ss");	// 작성일 형식 (예: 21/10/26 09:30:24)
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMdd");				// 파일 이름에 이용할 작성일 (예: 211026)
	
	public NoteManager() {
		list = new ArrayList<Note>();
		newDir = new File("NotePad");	// file 클래스를 이용하여 저장폴더 생성
		
		if(!newDir.exists()) {
			try {
				newDir.mkdir();
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public void addNote(Note n) throws IOException {
		list.add(n);
		writeNote(n);
		
		System.out.println("새로운 메모가 저장되었습니다.");
	}
	
	public void writeNote(Note n) throws IOException {
		String date = sdf2.format(n.writtenDate.getTime());
		String path = "NotePad\\" + date + n.title + ".txt";
		
		Writer noteWriter = new FileWriter(path);
		BufferedWriter out = new BufferedWriter(noteWriter);
		
		out.write("제목: " + n.title + "\n");
		out.write("-----------------------------\n");
		out.write("작성일: " + sdf1.format(n.writtenDate.getTime()) + "\n");
		out.write("-----------------------------\n");
		out.write(n.content);
		
		out.close();
	}
	
	public void insertNote() throws IOException {
		System.out.println("새로운 메모를 작성합니다.");
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("내용: ");
		String content = sc.nextLine();
		
		addNote(new Note(title, content));
	}
	
	public void printList() {
		System.out.println("메모 목록을 출력합니다.");
		System.out.println("-----------------------------");
		
		for(int i = 0; i < list.size(); i++) {
			Note n = list.get(i);
			String date = sdf2.format(n.writtenDate.getTime());
						
			System.out.printf("%d. %s\n", i+1, date + n.title);
		}
	}
	
	public void printOne() throws IOException {
		printList();
		
		System.out.println("-----------------------------");
		
		int select = 0;
		
		while(true) {
			System.out.println("개별보기할 메모의 번호를 입력하세요.");
			select = Integer.parseInt(sc.nextLine());
			
			if(select <= 0 || select > list.size()) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		
		Note temp = list.get(select - 1);
		String date = sdf2.format(temp.writtenDate.getTime());
		String path = "NotePad\\" + date + temp.title + ".txt";
		
		readNote(path);
	}
	
	public void readNote(String path) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		String str;
		
		while(true) {
			
			str = in.readLine();
			
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
		
		in.close();
	}

}
