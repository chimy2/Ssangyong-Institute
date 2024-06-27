package com.test.question.loop;
import java.util.Scanner;

public class Q038 {
//	반복문: 짝수 홀수 합
	public static void main(String[] args) {
//		요구사항] 입력 횟수(N)와 숫자 N개를 입력받아 
//			짝수의 합과 홀수의 합을 각각 출력하시오.
		
//		입력1
//		입력 횟수: 10 
//		숫자: 5 
//		숫자: 2 
//		숫자: 12 
//		숫자: 3 
//		숫자: 11 
//		숫자: 8 
//		숫자: 1 
//		숫자: 7 
//		숫자: 23 
//		숫자: 10 
		
//		출력1
//		짝수 4개의 합: 32
//		홀수 6개의 합: 50
		
//		입력2
//		입력 횟수: 3 
//		숫자: 1 
//		숫자: 2 
//		숫자: 3 
		
//		출력2
//		짝수 1개의 합: 2
//		홀수 2개의 합: 4
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 횟수: ");
		int count = scan.nextInt();
		int odd = 0;
		int even = 0;
		int sumOdd = 0;
		int sumEven = 0;
		int temp = 0;
		
//		1)
//		for(int i=0; i<count; i++) {
//			System.out.print("숫자: ");
//			temp = scan.nextInt();
//			if(temp % 2 == 0) {
//				even++;
//				sumEven += temp;
//			} else {
//				odd++;
//				sumOdd += temp;
//			}
//		}
		
//		2)
		while(count-- > 0) {
			System.out.print("숫자: ");
			temp = scan.nextInt();
			if(temp % 2 == 0) {
				even++;
				sumEven += temp;
			} else {
				odd++;
				sumOdd += temp;
			}
		}
		System.out.printf("짝수 %d개의 합: %d\n홀수 %d개의 합: %d",
				even, sumEven, odd, sumOdd);
	}
}
