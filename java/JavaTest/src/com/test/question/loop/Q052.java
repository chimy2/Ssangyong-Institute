package com.test.question.loop;

import java.util.Scanner;

public class Q052 {
//	반복문: 영문자
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
//			- 행의 갯수를 입력받으시오.
		
//		입력1
//		행: 5
		
//		출력1
//		    aa
//		   abba
//		  abccba
//		 abcddbca
//		abcdeedcba
		
//		입력2
//		행: 7
		
//		출력2
//		      aa
//		     abba
//		    abccba
//		   abcddbca
//		  abcdeedcba
//		 abcdeffedcba
//		abcdefggfedcba
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("행: ");
		int count = scan.nextInt();
		
		for(int i=0; i<count; i++) {
			for(int j=0; j<count * 2; j++) {
				int num = i - (int) Math.abs(j - (count * 2 - 1) / 2.0);
				if(num >= 0) {
					System.out.print((char)('a' + num));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
