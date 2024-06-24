package com.test.question;

import java.util.Scanner;

public class Q007 {
//	연산자: 대소문자 변환
	public static void main(String[] args) {
//		요구사항] 영문 소문자를 1글자 입력받은후 대문자로 변환해서 출력하시오.
//		- 대문자와 소문자의 문자 코드 값의 관계
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자 입력: ");
		String input = scan.nextLine();
//		1)
		String upper = input.toUpperCase();
		System.out.printf("소문자 '%s'의 대문자는'%s'입니다.\n", input, upper);
		
//		2)
		char upper2 = (char) (input.charAt(0) - ('a' - 'A'));
		System.out.printf("소문자 '%s'의 대문자는'%s'입니다.", input, upper2);
		
	}
}
