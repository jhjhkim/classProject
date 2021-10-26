package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedFileCopy {

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			// 프로그램에서 파일 복사
			// 프로그램이 파일 원본을 읽고 -> 새로운 파일을 생성
			// 원본 파일의 데이터를 읽기 위한 스트림 클래스 생성 : InputStream
			InputStream in = new FileInputStream("test.txt");
			OutputStream out = new FileOutputStream("copy.txt");
		
			// 보조 스트림(필터 스트림) : 필터 스트림을 사용하기 위해서는 기본 스트림이 필요하다.
			
			
			
			
			int copyByte = 0; // 복사한 바이트 계산
			
			int bData;
			
			while(true) {
				// 파일 읽기
				bData = in.read();
						
				if(bData == -1) {
					break;
				}
				
				// 파일 쓰기
				out.write(bData);
				
				copyByte++;
			}
			
			in.close();
			out.close();
			System.out.println("복사된 byte size : " + copyByte);
			
		} catch (FileNotFoundException e) {
			
		} catch (Exception e) {
			
		}
		
	}

}
