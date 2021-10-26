package chapter12.football;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//앞 Chapter에서 만들어본 축구선수 정보 파일로 저장하는 프로그램을 만들어 봅시다.
//①축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
//②이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
//③저장된 파일을 객체로 만드는 기능을 만들어봅시다.
public class PlayerList {

	ArrayList<FootballPlayer> list;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 인스턴스 저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("footballplayer.ser"));
		
		// list에 인스턴스 저장하기
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();
		
		list.add(new FootballPlayer("ADAMS", 1, "England", 20));
		list.add(new FootballPlayer("BRONKS", 4, "France", 33));
		list.add(new FootballPlayer("CHARLES", 7, "Germany", 27));
		list.add(new FootballPlayer("DAVID", 3, "England", 30));
		list.add(new FootballPlayer("BRONKS", 5, "France", 23));
		
		// 저장된 인스턴스들을 파일로 저장하기
		out.writeObject(list);
		
		out.close();
		
		// 인스턴스 복원을 위한 스트림
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("footballplayer.ser"));
		
		// 저장된 파일을 인스턴스로 복원
		ArrayList<FootballPlayer> list2 = (ArrayList) in.readObject();
		
		in.close();
		
		// 복원된 인스턴스를 출력해보기
		for(FootballPlayer player : list2) {
			System.out.println(player);
		}
		
	}
	
}
