package com.test.question;

import java.util.Calendar;

public class Q020 {
//	날짜시간: 백일 첫돌
	public static void main(String[] args) {
//		요구사항]  오늘 태어난 아이의 백일과 첫돌을 출력하시오.
		
//		출력
//		백일: 2024-10-04
//		첫돌: 2025-06-26
		
		Calendar birth = Calendar.getInstance();
		int crit = 100;

		birth.add(Calendar.DATE, crit);
		System.out.printf("백일: %tF\n", birth);
		
		birth.add(Calendar.DATE, 365 - crit);
		System.out.printf("첫돌: %tF\n", birth);
	}
}
