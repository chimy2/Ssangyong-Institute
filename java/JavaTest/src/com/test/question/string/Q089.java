package com.test.question.string;

import java.util.Scanner;

public class Q089 {
//	문자열: 한글 숫자
	public static void main(String[] args) {
//		요구사항] 입력받은 금액을 한글로 출력하시오.
//			- 입력 범위(원): 0 ~ 99,999,999
		
//		입력1
//		금액(원): 120 

//		출력1
//		일금 일백이십원
		
//		입력2
//		금액(원): 53216 

//		출력2
//		일금 오만삼천이백일십육원
		
//		입력3
//		금액(원): 12345678 

//		출력3
//		일금 일천이백삼십사만오천육백칠십팔원
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("금액(원): ");
		String won = scan.nextLine();
		
		String[] hangle = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		String[] numberUnits = { "천", "백", "십", "만", "천", "백", "십", "원" };
		
		String result = "";
		int len = won.length();
		int crit = numberUnits.length - len;
		
		for(int i=0; i<len; i++) {
			int num = Character.getNumericValue(won.charAt(i));
			if(num != 0 || (crit + i) % 4 == 3) {
				result += hangle[num] + numberUnits[i + crit];
			}
		}
		
		System.out.println("일금 " + result);
	}
}
