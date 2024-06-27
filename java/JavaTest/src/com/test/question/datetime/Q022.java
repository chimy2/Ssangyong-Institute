package com.test.question.datetime;

import java.util.Calendar;
import java.util.Scanner;

public class Q022 {
//	날짜시간: 커플 기념일
	public static void main(String[] args) {
//		요구사항] 남녀 커플의 이름과 만난날을 입력받아 기념일을 출력하시오.
		
//		입력
//		남자 이름: 하하하 
//		여자 이름: 호호호 
//		만난날(년): 2024 
//		만난날(월): 6 
//		만난날(일): 26 
		
//		출력
//		'하하하'과(와) '호호호'의 기념일
//		100일: 2024-10-04
//		200일: 2025-01-12
//		300일: 2025-04-22
//		500일: 2025-11-08
//		1000일: 2027-03-23
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("남자 이름: ");
		String m = scan.nextLine();
		
		System.out.print("여자 이름: ");
		String w = scan.nextLine();
		
		System.out.print("만난날(년): ");
		int year = scan.nextInt();
		
		System.out.print("만난날(월): ");
		int mon = scan.nextInt();
		
		System.out.print("만난날(일): ");
		int day = scan.nextInt();
		
		printAnni(m, w, year, mon, day);
	}

	private static void printAnni(String m, String w, int year, int mon, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, mon - 1, day);

		System.out.printf("\n'%s'과(와) '%s'의 기념일\n", m, w);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("100일: %tF\n", date);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("200일: %tF\n", date);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("300일: %tF\n", date);
		
		date.add(Calendar.DATE, 200);
		System.out.printf("500일: %tF\n", date);
		
		date.add(Calendar.DATE, 500);
		System.out.printf("1000일: %tF\n", date);
	}	
}
