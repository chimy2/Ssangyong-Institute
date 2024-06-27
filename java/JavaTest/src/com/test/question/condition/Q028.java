package com.test.question.condition;

import java.util.Scanner;

public class Q028 {
//	조건문: 개발자 경력
	public static void main(String[] args) {
//		요구사항] 근무 년수를 입력받아 아래와 같이 출력하시오.
//			- 1 ~ 4년차: 초급 개발자
//			- 5 ~ 9년차: 중급 개발자
//			- 10년차 이상: 고급 개발자
//			- 유효성 검사를 하시오.(1 미만 입력 예외 처리)
		
//		입력1
//		근무 년수: 2

//		출력1
//		2년차 초급 개발자입니다.
//		앞으로 3년 더 근무를 하면 중급 개발자가 됩니다. 
		
//		입력2
//		근무 년수: 5 

//		출력2
//		5년차 중급 개발자입니다.
//		당신은 1년전까지 초급 개발자였습니다.
//		앞으로 5년 더 근무를 하면 고급 개발자가 됩니다.
		
//		입력3
//		근무 년수: 11 

//		출력3
//		11년차 고급 개발자입니다.
//		당신은 2년전까지 중급 개발자였습니다.
		
//		입력4
//		근무 년수: -5 

//		출력4
//		입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("근무 년수: ");
		int year = scan.nextInt();
		
		if(year < 1) {
			System.out.println("입력한 값이 올바르지 않습니다.");
		} else {
			if(year < 5) {
				System.out.printf("%d년차 초급 개발자입니다.\n앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.",
						year, 5 - year);
			} else if(year < 10) {
				System.out.printf("%d년차 중급 개발자입니다.\n당신은 %d년전까지 초급개발자였습니다.\n"
						+ "앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.", 
						year, year - 4, 10 - year);
			} else {
				System.out.printf("%d년차 고급개발자입니다.\n당신은 %d년전까지 중급개발자였습니다.",
						year, year - 9);
			}
		}
	}
}
