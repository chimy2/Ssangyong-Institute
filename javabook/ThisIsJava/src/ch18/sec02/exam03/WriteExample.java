package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test3.db");
			
			byte[] array = { 10, 20, 30, 40, 50 };
			
			os.write(array, 1, 3);
			
			os.flush();
			os.close();
//			test3.db 파일에 1번 인덱스부터 3개까지만 내용을 담아서 파일 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
