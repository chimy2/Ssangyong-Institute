package com.test.question.condition;

import java.util.Scanner;

public class Q026 {
//	조건문: 성적처리
	public static void main(String[] args) {
//		요구사항] 학생의 국어 점수를 입력받아 성적을 출력하시오.
//			- 90 ~ 100: A
//			- 80 ~  89: B
//			- 70 ~  79: C
//			- 60 ~  69: D
//			- 0 ~   59: F
//			- 유효성 검사를 하시오.(점수: 0 ~ 100점 이내)
		
//		입력1
//		점수: 85 
		
//		출력1
//		입력한 85점은 성적 B입니다.
		
//		입력2
//		점수: 55 
		
//		출력2
//		입력한 55점은 성적 F입니다.
		
//		입력3
//		점수: 123 
		
//		출력3
//		점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수: ");
		int score = scan.nextInt();
		
		if(score > 100 || score < 0) {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		} else {
			String grade = "F";
			if(score >= 90) {
				grade = "A";
			} else if(score >= 80) {
				grade = "B";
			} else if(score >= 70) {
				grade = "C";
			} else if(score >= 60) {
				grade = "D";
			}
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, grade);
		}
	}
}
