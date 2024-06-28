package com.test.question.loop;

import java.util.Scanner;

public class Q044 {
//	반복문: 숫자 합
	public static void main(String[] args) {
//		요구사항] 숫자를 N개 입력받아 아래와 같이 출력하시오.
//			- 누적값이 100을 넘어가는 순간 루프를 종료하시오.
//			- 짝수는 더하고 홀수는 빼시오.
		
//		입력
//		숫자: 12 
//		숫자: 28 
//		숫자: 39 
//		숫자: 15 
//		숫자: 38 
//		숫자: 24 
//		숫자: 78 
		
//		출력
//		+ 12 + 28 - 39 - 15 + 38 + 24 + 78 = 126
		
		int result = 0;
		String output = "";
		Scanner scan = new Scanner(System.in);
		
		while(result < 100) {
			System.out.print("숫자: ");
			int num = scan.nextInt();
			if(num % 2 == 0) {
				result += num;
				output += "+ " + num + " ";
			} else {
				result -= num;
				output += "- " + num + " ";
			}
		}
		System.out.println(output + "= " + result);
	}
}
