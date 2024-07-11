package ch18.sec10;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws Exception {
//		File 객체 생성
		File dir = new File("C:/Temp/images");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File("C:/Temp/file3.txt");
		
//		존재하지 않으면 디첵토리 또는 파일 생성
		if(!dir.exists()) dir.mkdirs();
		if(!file1.exists()) file1.mkdirs();
		if(!file2.exists()) file2.mkdirs();
		if(!file3.exists()) file3.mkdirs();
		
//		Temp 폴더의 내용을 출력
		File temp = new File("C:/Temp");
		File[] contents = temp.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for(File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.printf("%-10s%-20s", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName());
			}
			System.out.println();
		}
		/*
		2024-07-11 오후 18:07      <DIR>     file1.txt           
		2024-07-11 오후 18:07      <DIR>     file2.txt           
		2024-07-11 오후 18:07      <DIR>     file3.txt           
		2024-07-11 오후 18:07      <DIR>     images              
		2024-07-11 오후 17:53      201       object.dat          
		2024-07-11 오후 17:38      46        primitive.db        
		2024-07-11 오후 17:52      172       printstream.txt     
		2024-07-11 오후 17:31      664489    targetFile1.jpg     
		2024-07-11 오후 17:31      664489    targetFile2.jpg     
		2024-07-11 오전 09:26      26205     test.jpg            
		2024-07-11 오후 16:55      43        test.txt            
		2024-07-10 오전 09:02      3         test1.db            
		2024-07-10 오전 09:52      3         test2.db            
		2024-07-11 오전 09:33      26205     test2.jpg           
		2024-07-10 오전 09:55      3         test3.db            
		 */
	}
}
