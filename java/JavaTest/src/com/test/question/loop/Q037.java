package com.test.question.loop;

import java.util.Scanner;

public class Q037 {
//	반복문: 범위 합
	public static void main(String[] args) {
//		요구사항] 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.
		
//		입력1
//		숫자: 5
		
//		출력1
//		1 ~ 5 = 15
				
//		입력2
//		숫자: 10 

//		출력2
//		1 ~ 10 = 55
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int last = scan.nextInt();
		int sum = 0;
		
//		1)
//		for(int i=1; i<=last; i++) {
//			sum += i;
//		}
		
//		2)
		int count = 1;
		while(count <= last) {
			sum += count++;
		}
		
		System.out.printf("1 ~ %d = %d", last, sum);
	}
}
