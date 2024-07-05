package com.lesson.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.*;

public class Ex07_Input {
	
	public static void main(String[] args) {
		
		//Ex07_Input.java
		/*
		 
			콘솔 입력
			1. System.in.read();
			   System.out.print();
			   
			2. BufferedReader 클래스
			
			3. Scanner 클래스
				- 문자열 입력 > ***
				- 숫자 입력
					- 정수 입력 > ***
					- 실수 입력 > **
				- 논리 입력
				
			
		*/
		
		/*
		//요구사항] 사용자로부터 문자를 1개를 입력 > 그대로 화면에 출력
		
		//java.lang 패키지
		//- 기본 패키지
		String txt = "문자열";
		
		//Ctrl + Shift + O
		//java.util 패키지
		Scanner scan = new Scanner(System.in);
		
		System.out.println("프로그램 시작");
		
		
		//사용자로부터 키보드 입력을 받는다.
		String input = scan.next(); //메서드
		
		System.out.println("입력: " + input);
		
		System.out.println("프로그램 종료");
		*/
		
		
		//자료형별로 키보드 입력 받기
		Scanner scan = new Scanner(System.in);
		
		
		/*
		System.out.print("문자열 입력: ");
		
		//- next() > 토큰(Token) 입력 > 공백을 구분자로 하는 각 요소(단어)
		//- nextLine() > 문장 입력
		String input = scan.nextLine();
		
		System.out.println(input);
		*/
		
		
		//요구사항] 사용자로부터 숫자를 1개 입력받아서 x2 출력
		/*
		System.out.print("숫자 입력: ");
		
		int input = scan.nextInt(); //10
		
		System.out.println(input * 2); //문자열 * 숫자
		*/
		
		/*
		System.out.print("실수 입력: ");
		
		double input = scan.nextDouble();
		
		System.out.println(input);
		*/
		
		
		//숫자 2개를 입력 > 그 합을 구하시오.
		
		//[초간단 계산기]
		//숫자1: 10 
		//숫자2: 5
		//결과: 10 + 5 = 15
		
		System.out.println("[초간단 계산기]");
		
		System.out.print("사용자명: ");
		String name = scan.nextLine();
		
		System.out.print("숫자1: ");		
		int num1 = scan.nextInt();
		
		System.out.print("숫자2: ");
		int num2 = scan.nextInt();

		//Alt + Shift + Y
		System.out.printf("%s님이 입력한 결과: %d + %d = %d"
							,name , num1, num2, num1 + num2);
		
		
		
		
		
		
	}

}



















