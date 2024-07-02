package com.test.question.string;

import java.util.Scanner;

public class Q083 {
//	문자열: 확장자
	public static void main(String[] args) {
//		요구사항] 파일명 10개를 입력받아 각 확장자별로 총 개수를 출력하시오.
//			- 확장자는 다음으로 제한한다.
//				- mp3
//				- jpg
//				- java
//				- hwp
//				- doc
		
//		입력
//		파일명: 인기가요.mp3 
//		파일명: cat.jpg 
//		파일명: Ex01.java 
//		파일명: icon.jpg 
//		파일명: 수업_정리.doc 
//		파일명: Scanner.java 
//		파일명: food.jpg 
//		파일명: 공지사항.hwp 
//		파일명: 이력서.hwp 
//		파일명: 출금내역.doc 

//		출력
//		mp3 : 1개
//		jpg : 3개
//		java : 2개
//		hwp : 2개
//		doc : 2개

		Scanner scan = new Scanner(System.in);
		String[] exts = { "mp3", "jpg", "java", "hwp", "doc" };
		int[] count = new int[5];
		
		for(int i=0; i<10; i++) {
			System.out.print("파일명: ");
			String filename = scan.nextLine();
			
			int index = filename.lastIndexOf(".");
			String ext = filename.substring(index + 1);
			
			countExt(exts, count, ext);
		}
		
		for(int i=0; i<exts.length; i++) {
			System.out.println(exts[i] + " : " + count[i] + "개");
		}
	}

	private static void countExt(String[] exts, int[] count, String ext) {
		for(int i=0; i<exts.length; i++) {
			if(exts[i].equals(ext)) {
				count[i]++;
				break;
			}
		}
	}
}
