package com.test.question.condition;

import java.util.Scanner;

public class Q027 {
//	조건문: 문자 조건
	public static void main(String[] args) {
//		요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오.
//			- f, F → Father
//			- m, M → Mother
//			- s, S → Sister
//			- b, B → Brother
//			- 유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
		
//		입력1
//		문자: f 
		
//		출력1
//		Father
		
//		입력2
//		문자: F 
		
//		출력2
//		Father
		
//		입력3
//		문자: s
		
//		출력3
//		Sister
		
//		입력4
//		문자: a 
		
//		출력4
//		입력한 문자가 올바르지 않습니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자: ");
		char input = scan.nextLine().charAt(0);
		String result = "입력한 문자가 올바르지 않습니다.";
		
		switch(input) {
			case 'f':
			case 'F':
				result = "Father";
				break;
			case 'm':
			case 'M':
				result = "Mother";
				break;
			case 's':
			case 'S':
				result = "Sister";
				break;
			case 'b':
			case 'B':
				result = "Brother";
				break;
		}
		System.out.println(result);
	}
}
