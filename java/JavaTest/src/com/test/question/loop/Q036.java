package com.test.question.loop;

import java.util.Scanner;

public class Q036 {
//	반복문: 숫자 범위
	public static void main(String[] args) {
//		요구사항] 시작 숫자, 종료 숫자, 증감치를 입력받아 
//			숫자를 순차적으로 출력하시오.
		
//		입력1
//		시작 숫자: 5 
//		종료 숫자: 12 
//		증감치: 1 
		
//		출력1
//		5
//		6
//		7
//		8
//		9
//		10
//		11
//		12
		
//		입력2
//		시작 숫자: 3 
//		종료 숫자: 30 
//		증감치: 3 
		
//		출력2
//		3
//		6
//		9
//		12
//		15
//		18
//		21
//		24
//		27
//		30
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("시작 숫자: ");
		int start = scan.nextInt();
		
		System.out.print("종료 숫자: ");
		int end = scan.nextInt();
		
		System.out.print("증감치: ");
		int change = scan.nextInt();
		
//		1)
		if(start <= end) {
			for(int i=start; i<=end; i+=change) {
				System.out.println(i);
			}
		} else {
			for(int i=start; i>=end; i+=change) {
				System.out.println(i);
			}
		}
		
//		2)
		if(start <= end) {
			while(start <= end) {
				System.out.println(start);
				start += change;
			}
		} else {
			while(start >= end) {
				System.out.println(start);
				start += change;
			}
		}
	}
}
