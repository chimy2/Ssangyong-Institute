package com.test.question;

import java.util.Scanner;

public class Q007 {
//	연산자: 대소문자 변환
	public static void main(String[] args) {
//		요구사항] 영문 소문자를 1글자 입력받은후 대문자로 변환해서 출력하시오.
//		- 대문자와 소문자의 문자 코드 값의 관계
		
//		입력1
//		문자 입력: a
		
//		출력1
//		소문자 'a'의 대문자는 'A'입니다.
		
//		입력2
//		문자 입력: g
		
//		출력2
//		소문자 'g'의 대문자는 'G'입니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자 입력: ");
		String input = scan.nextLine();
//		1)
		char upper = (char) (input.charAt(0) - ('a' - 'A'));
		System.out.printf("소문자 '%s'의 대문자는'%s'입니다.", input, upper);
//		2)
		String upper2 = input.toUpperCase();
		char upper3 = Character.toUpperCase(input.charAt(0));
		System.out.printf("소문자 '%s'의 대문자는'%s'입니다.\n", input, upper2);
		System.out.printf("소문자 '%s'의 대문자는'%s'입니다.\n", input, upper3);
		
		
	}
}
