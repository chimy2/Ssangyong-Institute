package com.test.question.datetime;

import java.util.Calendar;
import java.util.Scanner;

public class Q023 {
//	날짜시간: 아빠와 딸
	public static void main(String[] args) {
//		요구사항] 아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력하시오.
		
//		입력
//		아빠 생일(년): 1971 
//		아빠 생일(월): 5 
//		아빠 생일(일): 10 
//		딸 생일(년): 1999 
//		딸 생일(월): 7 
//		딸 생일(일): 22 
		
//		출력
//		아빠는 딸보다 총 10,300일을 더 살았습니다.
		
		Scanner scan = new Scanner(System.in);
		Calendar dad = Calendar.getInstance();
		Calendar girl = Calendar.getInstance();
		
		System.out.print("아빠 생일(년): ");
		dad.set(Calendar.YEAR, scan.nextInt());
		
		System.out.print("아빠 생일(월): ");
		dad.set(Calendar.MONTH, scan.nextInt() - 1);
		
		System.out.print("아빠 생일(일): ");
		dad.set(Calendar.DATE, scan.nextInt());

		System.out.print("딸 생일(년): ");
		girl.set(Calendar.YEAR, scan.nextInt());
		
		System.out.print("딸 생일(월): ");
		girl.set(Calendar.MONTH, scan.nextInt() - 1);
		
		System.out.print("딸 생일(일): ");
		girl.set(Calendar.DATE, scan.nextInt());

		long gap = girl.getTimeInMillis() - dad.getTimeInMillis();
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.",
				 gap / 1000 / 60 / 60 / 24);
	}
}
