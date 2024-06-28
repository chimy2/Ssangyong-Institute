package com.test.question.condition;

import java.util.Scanner;

public class Q032 {
//	조건문: 주차 요금
	public static void main(String[] args) {
//		요구사항] 주차 요금을 계산하시오.
//			- 무료 주차: 30분
//			- 초과 10분당: 2,000원
		
//		입력
//		[들어온 시간]
//		시: 13 
//		분: 30 
//
//		[나간 시간]
//		시: 14 
//		분: 20 
		
//		출력
//		주차 요금은 4,000원입니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[들어온 시간]");
		System.out.print("시: ");
		int inHour = scan.nextInt();
		
		System.out.print("분: ");
		int inMin = scan.nextInt();
		
		System.out.println("[나간 시간]");
		System.out.print("시: ");
		int outHour = scan.nextInt();
		
		System.out.print("분: ");
		int outMin = scan.nextInt();
		
		int inTime = inHour * 60 + inMin;
		int outTime = ((inHour > outHour ? 24 : 0) + outHour) * 60 + outMin; 
		int gap = outTime - inTime;
		int result = gap > 30 ? (gap - 30) / 10 * 2000 : 0;
		
		System.out.printf("주차 요금은 %,d원입니다.", result);
	}
}
