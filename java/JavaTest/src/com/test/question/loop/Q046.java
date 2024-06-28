package com.test.question.loop;

import java.util.Scanner;

public class Q046 {
//	반복문: 한글 숫자
	public static void main(String[] args) {
//		요구사항] 숫자를 10개 입력받아 한글로 변환 후 출력하시오.
//			- 1~9까지만 입력하시오.
		
//		입력
//		숫자: 5 
//		숫자: 7 
//		숫자: 4 
//		숫자: 3 
//		숫자: 5 
//		숫자: 7 
//		숫자: 6 
//		숫자: 2 
//		숫자: 1 
//		숫자: 3 
		
//		출력
//		오칠사삼오칠육이일삼
		
		Scanner scan = new Scanner(System.in);
		String result = "";
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자: ");
			int num = scan.nextInt();
			result += returnKor(num);
		}
		System.out.println(result);
	}
	
	public static String returnKor(int num) {
		String result = "";
		if(num == 1) {
			result = "일";
		} else if(num == 2) {
			result = "이";
		} else if(num == 3) {
			result = "삼";
		} else if(num == 4) {
			result = "사";
		} else if(num == 5) {
			result = "오";
		} else if(num == 6) {
			result = "육";
		} else if(num == 7) {
			result = "칠";
		} else if(num == 8) {
			result = "팔";
		} else if(num == 9) {
			result = "구";
		}
		return result;
	}
}
