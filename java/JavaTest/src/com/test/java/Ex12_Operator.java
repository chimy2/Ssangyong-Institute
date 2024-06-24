package com.test.java;

import java.util.Scanner;

public class Ex12_Operator {
	public static void main(String[] args) {
//		요구사항] 사용자로부터 문자 1개 입력 > 영어 소문자인지?
		
//		흐름] > 흐름/시나리오를 생각하는 것이 공부🌟🌟
//		1. Scanner 생성
//		2. 안내 메시지 출력(label)
//		3. 문자 입력
//		4. 유효성 검사
//		5. 결과 처리 + 출력
		
		/*
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자를 1개 입력하시오.");
		String input = scan.nextLine();
		char c = input.charAt(0);
		System.out.println(c >= 'a' && c <= 'z' ? "소문자입니다" : "소문자가 아닙니다");
		*/
		
		/*
//		1. Scanner 생성
		Scanner scan = new Scanner(System.in);
		
//		2. 안내 메시지 출력(label)
		System.out.print("문자 입력: ");
		
//		3. 문자 입력
		String input = scan.nextLine();
		
//		4. 유효성 검사(핵심!)
		char c = input.charAt(0);
		int code = (int)c;
//		a(97) ~ z(122)
//		A(65) ~ Z(90)
//		0(48) ~ 9(57)
//		가(44032) ~ 힣(?)
		String result = code >= 97 && code <= 122 ? "올바른 소문자" : "올바르지 않은 소문자";
		String result2 = code >= 65 && code <= 90 ? "올바른 대문자" : "올바르지 않은 대문자";
		String result3 = code >= 48 && code <= 57 ? "올바른 숫자" : "올바르지 않은 숫자";
		String result4 = code >= '가' && code <= '힣' ? "올바른 한글" : "올바르지 않은 한글";

//		5. 결과 처리 + 출력
		System.out.printf("입력한 문자 '%s'는 %s입니다.\n", input, result);
		System.out.printf("입력한 문자 '%s'는 %s입니다.\n", input, result2);
		System.out.printf("입력한 문자 '%s'는 %s입니다.\n", input, result3);
		System.out.printf("입력한 문자 '%s'는 %s입니다.\n", input, result4);
		
		c = 'G';
		
		System.out.println((int)c >= 65 && (int)c <= 90);
		System.out.println((int)c >= (int)'A' && (int)c <= (int)'Z');
		
//		비교 연산자는 char 비교 가능 > 숫자로서 비교
		System.out.println(c >= 'A' && c <= 'Z');
		*/
		
//		요구사항] 사용자로부터 문자 1개 입력 > 영문자 혹은 숫자인지?
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 입력:");
		char c = scan.nextLine().charAt(0);
		String result = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') 
				|| (c >= '0' && c <= '9') ? "올바른 영문자" : "올바르지 않은 영문자";
		System.out.printf("입력한 문자 '%s'는 %s입니다", c, result);
	}
}
