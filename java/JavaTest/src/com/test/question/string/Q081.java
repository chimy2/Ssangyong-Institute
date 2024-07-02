package com.test.question.string;

import java.util.Scanner;

public class Q081 {
//	문자열: 이메일
	public static void main(String[] args) {
//		요구사항] 이메일 주소를 입력받아 아이디와 도메인을 각각 추출하시오.
		
//		입력
//		이메일: hong@gmail.com 

//		출력
//		아이디: hong
//		도메인: gmail.com
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이메일: ");
		String email = scan.nextLine();
		
//		1)
		int index = email.indexOf("@");
		System.out.println("아이디: " + email.substring(0, index));
		System.out.println("도메인: " + email.substring(index + 1));
		
//		2)
		String[] arr = email.split("@");
		System.out.println("아이디: " + arr[0]);
		System.out.println("도메인: " + arr[1]);
	}
}
