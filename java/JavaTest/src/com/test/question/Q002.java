package com.test.question;

import java.util.Scanner;

public class Q002 {
//	연산자: 연산식
	public static void main(String[] args) {
//		요구사항] 숫자 2개를 입력받아 아래의 연산식을 출력하시오.
//			- 출력 숫자에 천단위 표기 하시오.
//			- 결과값은 소수 이하 1자리까지 표기 하시오.
//		첫번째 숫자: 5
//		두번째 숫자: 3
//		5 + 3 = 8
//		5 - 3 = 2
//		5 * 3 = 15
//		5 / 3 = 1.7
//		5 % 3 = 2
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		int num1 = scan.nextInt();
		System.out.print("두번째 숫자: ");
		int num2 = scan.nextInt();
		
		System.out.printf("%,d + %,d = %,d\n", num1, num2, num1 + num2);
		System.out.printf("%,d - %,d = %,d\n", num1, num2, num1 - num2);
		System.out.printf("%,d * %,d = %,d\n", num1, num2, num1 * num2);
		System.out.printf("%,d / %,d = %,.1f\n", num1, num2, (double)num1 / num2);
		System.out.printf("%,d %% %,d = %,d", num1, num2, num1 % num2);
		
	}
}
