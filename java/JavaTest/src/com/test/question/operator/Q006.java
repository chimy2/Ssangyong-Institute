package com.test.question.operator;

import java.util.Scanner;

public class Q006 {
//	연산자: 세금 계산
	public static void main(String[] args) {
//		요구사항] 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.
//		세금: 수입의 3.3%
		
//		입력
//		한달 수입 금액(원): 1000000
		
//		출력
//		세후 금액(원) 967,000원
//		세금(원) 33,000원
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("한달 수입 금액(원): ");
		int income = scan.nextInt();
		int tax = (int) (income * 0.033);
		
		System.out.printf("세후 금액(원): %,d원\n세금(원): %,d원", income - tax, tax);
	}
}
