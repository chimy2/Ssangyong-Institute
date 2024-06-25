package com.test.question;

import java.util.Scanner;

public class Q012 {
//	메소드: 짝수 홀수
	public static void main(String[] args) {
//		요구사항] 숫자를 전달하면 '짝수' 혹은 '홀수' 라는 단어를 반환하는 메소드를 선언하시오.
//			- String getNumber(int)
		
//		호출
//		result = getNumber(n);
//		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
		
//		입력1
//		숫자: 5
		
//		출력2
//		입력하신 숫자 '5'는(은) '홀수'입니다.
		
//		입력2
//		숫자: 2
		
//		출력2
//		입력하신 숫자 '2'는(은) '짝수'입니다.
		
		Scanner scan = new Scanner(System.in);

		System.out.print("숫자: ");
		int n = scan.nextInt();

		String result = getNumber(n);
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
	}

	public static String getNumber(int n) {
		return n % 2 == 0 ? "짝수" : "홀수";
	}
}
