package com.test.question.string;

import java.util.Scanner;

public class Q086 {
//	문자열: 자릿수
	public static void main(String[] args) {
//		요구사항] 숫자를 입력받아 3자리마다 , 를 붙이시오.
//			- %,d 사용 금지
		
//		입력1
//		숫자: 1234 

//		출력1
//		결과: 1,234
		
//		입력2
//		숫자: 1234567 

//		출력2
//		결과: 1,234,567
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		String num = scan.nextLine();
		
		int len = num.length();
		
//		1)
//		for(int i=(len - 1) / 3 - 1; i>=0; i--) {
//			int remainder = len % 3;
//			int crit = i * 3 + (remainder == 0 ? 3 : remainder);
//			num = num.substring(0, crit)+ "," + num.substring(crit);
//		}
//		System.out.println("결과: " + num);
		
//		2)
		StringBuilder sb = new StringBuilder(num);
		
		for(int i=(len - 1) / 3 - 1; i>=0; i--) {
			int remainder = len % 3;
			int crit = i * 3 + (remainder == 0 ? 3 : remainder);
			sb.insert(crit, ",");
		}
		
		System.out.println("결과: " + sb.toString());
	}
}
