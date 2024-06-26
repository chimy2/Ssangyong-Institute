package com.test.question;

import java.util.Scanner;

public class Q011 {
//	메소드: 연산식
	public static void main(String[] args) {
//		요구사항] 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오.
//			- String add(int, int)
//			- String subtract(int, int)
//			- String multiply(int, int)
//			- String divide(int, int)
//			- String mod(int, int)
		
//		입력
//		첫번째 숫자: 5
//		두번째 숫자: 3
		
//		호출
//		result = add(n1, n2);
//		System.out.println(result);
//		
//		result = subtract(n1, n2);
//		System.out.println(result);
//		
//		result = multiply(n1, n2);
//		System.out.println(result);
//		
//		result = divide(n1, n2);
//		System.out.println(result);
//		
//		result = mod(n1, n2);
//		System.out.println(result);
		
//		출력
//		5 + 3 = 8
//		5 - 3 = 2
//		5 * 3 = 15
//		5 / 3 = 1.7
//		5 % 3 = 2
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		int n1 = scan.nextInt();
		System.out.print("두번째 숫자: ");
		int n2 = scan.nextInt();
		
		String result;
		 
		result = add(n1, n2);
		System.out.println(result);
		
		result = subtract(n1, n2);
		System.out.println(result);
		
		result = multiply(n1, n2);
		System.out.println(result);
		
		result = divide(n1, n2);
		System.out.println(result);
		
		result = mod(n1, n2);
		System.out.println(result);
	}
	
	public static String add(int n1, int n2) {
		return n1 + " + " + n2 + " = " + (n1 + n2);
	}
	
	public static String subtract(int n1, int n2) {
		return n1 + " - " + n2 + " = " + (n1 - n2);
	}
	
	public static String multiply(int n1, int n2) {
		return n1 + " * " + n2 + " = " + (n1 * n2);
	}
	
	public static String divide(int n1, int n2) {
//		1)
		return n1 + " / " + n2 + " = " + Math.round((double)n1 / n2 * 10) / 10;
//		2)
//		return n1 + " / " + n2 + " = " + String.format("%.1f",(double)n1 / n2);
	}
	
	public static String mod(int n1, int n2) {
		return n1 + " % " + n2 + " = " + (n1 % n2);
	}
}
