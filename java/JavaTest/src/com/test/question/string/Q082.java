package com.test.question.string;

import java.util.Scanner;

public class Q082 {
//	문자열: 숫자 합
	public static void main(String[] args) {
//		요구사항] 숫자를 입력받아 각 자릿수의 수의 합을 구하시오.
		
//		입력
//		숫자: 314 

//		출력
//		결과: 3 + 1 + 4 = 8
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		String numbers = scan.nextLine();
		
		int sum = 0;
		
		System.out.print("결과: ");
		
		for(int i=0; i<numbers.length(); i++) {
			int number = Character.getNumericValue(numbers.charAt(i));
			sum += number;
			System.out.print(number);
			if(i != numbers.length() - 1) {
				System.out.print(" + ");
			}
		}
		
		System.out.println(" = " + sum);
	}
}
