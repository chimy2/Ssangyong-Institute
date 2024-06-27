package com.test.question.method;

import java.util.Scanner;

public class Q013 {
//	메소드: 성적처리
	public static void main(String[] args) {
//		요구사항] 국어, 영어, 수학 점수를 전달하면 
//			'합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.
//			- String test(int kor, int eng, int math)
//			- 평균 점수 60점 이상은 '합격'이다.
//			- 평균 점수 60점 미만은 '불합격'이다.
//			- 과락: 한과목 이상 40점 미만이면 불합격이다.
		
//		입력1
//		국어: 80
//		영어: 75
//		수학: 60
		
//		출력1
//		합격입니다.
		
//		입력2
//		국어: 55
//		영어: 35
//		수학: 60
		
//		출력2
//		불합격입니다.

		Scanner scan = new Scanner(System.in);

		System.out.print("국어: ");
		int kor = scan.nextInt();

		System.out.print("영어: ");
		int eng = scan.nextInt();

		System.out.print("수학: ");
		int math = scan.nextInt();

		System.out.println(test(kor, eng, math) + "입니다.");
	}

	public static String test(int kor, int eng, int math) {
		int avg = (kor + eng + math) / 3;
		return (kor < 40 || eng < 40 || math < 40 || avg < 60) ? "불합격" : "합격";
	}
}
