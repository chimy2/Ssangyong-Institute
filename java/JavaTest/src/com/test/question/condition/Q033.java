package com.test.question.condition;

import java.util.Scanner;

public class Q033 {
//	조건문: 윤년 검사
	public static void main(String[] args) {
//		요구사항] 년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.
//			a. 년도를 4로 나눈다.
//				- 떨어지면 b 검사
//				- 떨어지지 않으면 "평년"
//			b. 년도를 100으로 나눈다.
//				- 떨어지면 c 검사
//				- 떨어지지 않으면 "윤년"
//			c. 년도를 400으로 나눈다.
//				- 떨어지면 "윤년"
//				- 떨어지지 않으면 "평년"
		
//		입력1
//		년도 입력: 2019 

//		출력1
//		2019년은 '평년'입니다.
		
//		입력2
//		년도 입력: 2020 

//		출력2
//		2020년은 '윤년'입니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("년도 입력: ");
		int year = scan.nextInt();
		
		String s = "평년";
		
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			s = "윤년";
		}
		
		System.out.printf("%d년은 '%s'입니다", year, s);
	}
}
