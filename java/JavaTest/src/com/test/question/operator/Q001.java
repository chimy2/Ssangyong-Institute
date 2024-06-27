package com.test.question.operator;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Q001 {
//	연산자: 나이
	public static void main(String[] args) {
//		요구사항] 태어난 년도를 입력받아 나이를 출력하시오.
		
//		입력
//		태어난 년도: 1999
		
//		출력
//		나이: 25세
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("태어난 년도: ");
		int year = scan.nextInt();

		System.out.printf("나이: %d세", 2024 - year);
	}
}
