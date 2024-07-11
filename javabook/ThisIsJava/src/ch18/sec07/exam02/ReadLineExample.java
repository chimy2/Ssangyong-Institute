package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/ch18/sec07/exam02/ReadLineExample.java"));
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		
		br.close();
		
		/*
		1	package ch18.sec07.exam02;
		2	
		3	import java.io.BufferedReader;
		4	import java.io.FileReader;
		5	
		6	public class ReadLineExample {
		7		public static void main(String[] args) throws Exception {
		8			BufferedReader br = new BufferedReader(new FileReader("src/ch18/sec07/exam02/ReadLineExample.java"));
		9			
		10			int lineNo = 1;
		11			while(true) {
		12				String str = br.readLine();
		13				if(str == null) break;
		14				System.out.println(lineNo + "\t" + str);
		15				lineNo++;
		16			}
		17			
		18			br.close();
		19		}
		20	}

		 */
	}
}
