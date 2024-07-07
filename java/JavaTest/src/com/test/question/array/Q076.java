package com.test.question.array;

import java.util.Scanner;

public class Q076 {
//	배열: 성적 그래프
	public static void main(String[] args) {
//		요구사항] 성적을 입력받아 아래와 같이 출력하시오.
//			- String[][] score = new String[10][3];
			
//		입력
//		국어 점수: 80 
//		영어 점수: 50 
//		수학 점수: 70 

//		출력
//		 	 	 
//		 	 	 
//		■		
//		■		■
//		■		■
//		■	■	■
//		■	■	■
//		■	■	■
//		■	■	■
//		■	■	■
//		국어	영어 	수학
		String[][] score = new String[10][3];
		String[] subjects = { "국어", "영어", "수학" };
		Scanner scan = new Scanner(System.in);
		int startPoint = score.length - 1;
		
		for(int i=0; i<score[0].length; i++) {
			System.out.print(subjects[i] + " 점수: ");
			int input = scan.nextInt() / 10;
			
			for(int j=0; j<score.length; j++) {
				if(j < input) {
					score[startPoint - j][i] = "■";
				} else {
					score[startPoint - j][i] = "";
				}
			}
		}
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("%2s\t", score[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------");
		System.out.println("국어\t영어\t수학");
	}
}
