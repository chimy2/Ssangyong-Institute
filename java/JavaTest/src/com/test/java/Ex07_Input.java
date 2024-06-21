package com.test.java;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
//어떤 패키지에서 가져온 Date인지 모르기 때문에 Error
import java.util.Scanner;

//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.*;

public class Ex07_Input {
	public static void main(String[] args) {
		/*
		 * 콘솔 입력
		 * ↓ 시간 순서대로 나옴
		 * 1. System.in.read();
		 * 	  System.out.print();
		 * 2. BufferedReader 클래스
		 * 3. Scanner 클래스
		 * - 문자열 입력 > 🌟🌟🌟
		 * - 숫자 입력
		 * 	- 정수 입력 > 🌟🌟🌟
		 * 	- 실수 입력 > 🌟🌟
		 * - 논리 입력
		 * 
		 */
		
		/*
//		요구사항] 사용자로부터 문자를 1개 입력 > 그대로 화면에 출력

//		java.lang 패키지
//		- 기본 패키지
//		- import가 필요없음
		String txt = "문자열";
		java.lang.String txt2;
		
//		전체 import 단축키: Ctrl + Shift + O 
//		java.util 패키지
		java.util.Scanner testScan;
		ArrayList list;
		Date now = new Date();		
		java.sql.Date now2;
		
		Scanner scan = new Scanner(System.in);
//		사용자로부터 키보드 입력을 받는다.
		System.out.println("프로그램 시작");
		
		String input = scan.next();	//메서드
		
		System.out.println("입력: " + input);
		
		System.out.println("프로그램 종료");
		
		*/
		
//		자료형 별로 키보드 입력 받기
		Scanner scan = new Scanner(System.in);
		/*
		System.out.print("문자열 입력: ");
//		- next() > 토큰(Token) 입력 > "자바 프로그램" 입력 > "자바"
//		🌟토큰(Token): 공백을 구분자로 하는 각 요소(단어)
//		- nextLint() > 문장 입력 > "자바 프로그램" 입력 > "자바 프로그램"
		String input = scan.nextLine();
		System.out.println(input);
		*/
		
		/*
//		요구사항] 사용자로부터 숫자를 1개 입력받아서 x2 출력
		System.out.print("숫자 입력: ");
		int input = scan.nextInt();
		System.out.println(input * 2);
		*/
		
		/*
		System.out.print("실수 입력:");
		double input = scan.nextDouble();
		System.out.println(input);
		*/
		
//		숫자 2개를 입력 > 그 합을 구하시오.
//		[초간단 계산기]
//		사용자명: ~
//		숫자1: 10
//		숫자2: 5
//		~님이 입력한 결과: 10 + 5 = 15
		System.out.println("[초간단 계산기]");
		
		System.out.print("사용자명: ");
		String name = scan.nextLine();
		
		System.out.print("숫자1:");
		int num1 = scan.nextInt();
		
		System.out.print("숫자2:");
		int num2 = scan.nextInt();
		
//		자동 줄바꿈: Alt + Shift + y
		System.out.println(name + "님이 입력한 결과: " + num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.printf("%s님이 입력한 결과: %d + %d = %d", 
				name, num1, num2, (num1 + num2));
		
	}
}
