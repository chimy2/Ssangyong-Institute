package com.test.question.condition;

import java.util.Scanner;

public class Q030 {
//	조건문: 대소문자 변환
	public static void main(String[] args) {
//		요구사항] 영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.
//			- 유효성 검사를 하시오.(영문자만 입력 가능)
		
//		입력1
//		문자: a 

//		출력1
//		'a'의 대문자는 'A'입니다.
		
//		입력2
//		문자: F 

//		출력2
//		'F'의 소문자는 'f'입니다.
		
//		입력3
//		문자: 가 

//		출력3
//		영문자만 입력하시오.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자: ");
		String str = scan.nextLine();
		char c = str.charAt(0);
		
		if(str.length() == 1 
				&& ((c >= 'A' && c <= 'Z')|| (c >= 'a' && c  <= 'z'))) { 
			if(Character.isUpperCase(c)) {
				System.out.printf("'%s'의 소문자는 '%s'입니다.",
						c, Character.toLowerCase(c));
			} else {
				System.out.printf("'%s'의 대문자는 '%s'입니다.",
						c, Character.toUpperCase(c));
			}
		} else {
			System.out.println("영문자만 입력하시오.");
		}
	}
}
