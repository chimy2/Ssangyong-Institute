package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test1.db");
			
			byte a = 10;
			byte b = 20;
			byte c = 30;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush();
			os.close();
			
//			해당 경로에 파일이 생성됨, 단 Temp 폴더가 있어야 함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
