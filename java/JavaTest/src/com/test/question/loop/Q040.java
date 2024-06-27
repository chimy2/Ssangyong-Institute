package com.test.question.loop;

import java.util.Scanner;

public class Q040 {
//	반복문: 숫자 합
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
		
//		입력1
//		시작 숫자: 1 
//		종료 숫자: 10 

//		출력1
//		1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
		
//		입력2
//		시작 숫자: 3 
//		종료 숫자: 5 

//		출력2
//		3 - 4 + 5 = 4
		
		Scanner scan = new Scanner(System.in);
		int result = 0;
		
		System.out.print("시작 숫자: ");
		int start = scan.nextInt();
		
		System.out.print("종료 숫자: ");
		int end = scan.nextInt();
		
//		1)
//		for(int idx=0, num=start; idx<=end-start; idx++, num++) {
//			if(idx % 2 == 0) {
//				result += num;
//				System.out.print(num + " - ");
//			} else {
//				result -= num;
//				System.out.print(num + " + ");
//			}
//		}
		
//		2)
		int idx = 0;
		
		while(start <= end) {
			if(idx % 2 == 0) {
				result += start;
				System.out.print(start + " - ");
			} else {
				result -= start;
				System.out.print(start + " + ");
			}
			idx++;
			start++;
		}
		
		System.out.println("\b\b= " + result);
	}
}
