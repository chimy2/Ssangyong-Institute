package com.test.question.loop;

import java.util.Scanner;

public class Q045 {
//	반복문: 369
	public static void main(String[] args) {
//		요구사항] 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.
//			- 최대 3자리까지만 입력하시오
		
//		입력
//		최대 숫자: 50
		
//		출력
//		1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 14 15 짝 17 18 짝 20 
//		21 22 짝 24 25 짝 27 28 짝 짝 짝 짝 짝짝 짝 짝 짝짝 짝 짝 짝짝 40 
//		41 42 짝 44 45 짝 47 48 짝 50
		
		Scanner scan = new Scanner(System.in);
		System.out.print("최대 숫자: ");
		int count = scan.nextInt();
		
		for(int i=1; i<=count; i++) {
			if(i != 1 && i % 20 == 1) {
				System.out.println();
			}
			
			String temp = String.valueOf(i);
			int check = 0;
			
			for(int j=0; j<temp.length(); j++) {
				char c = temp.charAt(j);
				if(c == '3' || c == '6' || c == '9') {
					check++;
				}
			}
			
			System.out.print((check > 0 ? "짝".repeat(check) : i) + " ");
		}
	}
}
