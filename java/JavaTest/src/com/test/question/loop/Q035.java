package com.test.question.loop;

import java.util.Scanner;

public class Q035 {
//	반복문: 반복 인사
	public static void main(String[] args) {
//		요구사항] 사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.
		
//		입력1
//		이름: 홍길동 
//		횟수: 3 
		
//		출력1
//		홍길동님 안녕하세요~
//		홍길동님 안녕하세요~
//		홍길동님 안녕하세요~
		
//		입력2
//		이름: 아무개 
//		횟수: 5 

//		출력2
//		아무개님 안녕하세요~
//		아무개님 안녕하세요~
//		아무개님 안녕하세요~
//		아무개님 안녕하세요~
//		아무개님 안녕하세요~
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("횟수: ");
		int count = scan.nextInt();
		
//		1)
//		for(int i=0; i<count; i++) {
//			System.out.println(name + "님 안녕하세요~");
//		}
		
//		2)
		while(count > 0) {
			System.out.println(name + "님 안녕하세요~");
			count--;
		}
		
	}
}
