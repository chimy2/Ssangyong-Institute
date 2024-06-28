package com.test.question.condition;

import java.util.Calendar;
import java.util.Scanner;

public class Q034 {
//	조건문: 날짜 계산
	public static void main(String[] args) {
//		요구사항] 날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.
//			- 입력받은 날짜가 평일이면 해당 주의 토요일을 알아낸다.
//			- 입력받은 날짜가 토/일요일이면 아무것도 안한다.
		
//		입력1
//		년: 2022 
//		월: 3 
//		일: 14 
		
//		출력1
//		입력하신 날짜는 '평일'입니다.
//		해당 주의 토요일로 이동합니다.
//		이동한 날짜는 '2022-03-19' 입니다.
		
//		입력2
//		년: 2022 
//		월: 3 
//		일: 6 
		
//		출력2
//		입력하신 날짜는 '휴일(토/일)'입니다.
//		결과가 없습니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("년: ");
		int year = scan.nextInt();
		
		System.out.print("월: ");
		int mon = scan.nextInt();
		
		System.out.print("일: ");
		int day = scan.nextInt();
		
		Calendar date = Calendar.getInstance();
		
		date.set(year, mon - 1, day);
		
		int dayWeek = date.get(Calendar.DAY_OF_WEEK);
		
		if(dayWeek == 1 || dayWeek == 7) {
			System.out.printf("입력하신 날짜는 '휴일(토/일)'입니다.");
			System.out.println("결과가 없습니다.");
		} else {
			date.set(Calendar.DAY_OF_WEEK, 7);
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당주의 토요일로 이동합니다.");
			System.out.printf("이동한 날짜는 '%tF' 입니다.", date);
		}
	}
}
