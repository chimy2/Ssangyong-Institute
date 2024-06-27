package com.test.question.method;

public class Q010 {
//	메소드: 자릿수
	public static void main(String[] args) {
//		요구사항] 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.
//			- void digit(int num)
//			- 3항 연산자 사용(조건문 사용 금지)
//			- 입력한 숫자가 4자리 이상이면 그대로 출력한다.
		
//		호출
//		digit(1);
//		digit(12);
//		digit(321);
//		digit(5678);
//		digit(98765);
		
//		출력
//		1 → 0001
//		12 → 0012
//		321 → 0321
//		5678 → 5678
//		98765 → 98765
		
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
	}
	
	public static void digit(int num) {
		System.out.printf("%d → %04d\n", num, num);
	}
}
