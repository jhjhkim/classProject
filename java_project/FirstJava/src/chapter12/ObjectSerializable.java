package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 인스턴스 저장을 위한 스트림
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		// 인스턴스 저장
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));
		out.writeObject(new String("문자열"));
		out.close();
		
		// 저장된 파일을 이용해서 인스턴스 생성 -> 복원
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		// 복원 : 인스턴스 생성하고 반환
		Circle c1 = (Circle) in.readObject();
		Circle c2 = (Circle) in.readObject();
		
		String str = (String) in.readObject();
		in.close();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(str);
		
	}
	
}
