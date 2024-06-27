package com.test.question.loop;
import java.util.Scanner;

public class Q039 {
//	반복문: 숫자 합
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
		
//		입력1
//		시작 숫자: 1 
//		종료 숫자: 10 
		
//		출력1
//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
		
//		입력2
//		시작 숫자: 3 
//		종료 숫자: 5 
		
//		출력2
//		3 + 4 + 5 = 12
		
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("시작 숫자: ");
		int start = scan.nextInt();
		
		System.out.print("종료 숫자: ");
		int end = scan.nextInt();
		
//		1)
//		for(int i=start; i<=end; i++) {
//			sum += i;
//			System.out.print(i + " + ");
//		}
		
//		2)
		while(start <= end) {
			sum += start;
			System.out.print(start++ + " + ");
		}
		
		System.out.println("\b\b= " + sum);
	}
}
