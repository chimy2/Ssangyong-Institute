package com.test.question.string;

import java.util.Scanner;

public class Q080 {
//	문자열: 역순 출력
	public static void main(String[] args) {
//		요구사항] 문장을 입력받아 역순으로 출력하시오.
		
//		입력1
//		문장 입력 : 가나다 

//		출력1
//		역순 결과 : "다나가"
			
//		입력2
//		문장 입력 : 안녕하세요. 홍길동입니다. 

//		출력2
//		역순 결과 : ".다니입동길홍 .요세하녕안"
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문장 입력 : ");
		String origin = scan.nextLine();
		
//		1)
//		System.out.print("역순 결과 : ");
//		
//		for(int i=origin.length() - 1; i>=0; i--) {
//			System.out.print(origin.charAt(i));
//		}
		
//		2)
		StringBuilder sb = new StringBuilder();
			
		for(int i=0; i<origin.length(); i++) {
			sb.insert(0, origin.charAt(i));
		}
		
		System.out.println("문장 입력 : " + sb.toString());
	}
}
