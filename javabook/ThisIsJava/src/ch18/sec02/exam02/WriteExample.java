package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/tes2.db");
			
			byte[] array = { 10, 20, 30 };
			
			os.write(array);
			
			os.flush();
			os.close();
//			test2.db에 내용을 담아서 파일 생성			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
