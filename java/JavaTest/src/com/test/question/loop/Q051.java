package com.test.question.loop;

import java.util.Scanner;

public class Q051 {
//	반복문: 별찍기
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
//			- 행의 갯수를 입력받으시오.
		
//		입력1
//		행: 5 
		
//		출력1
//		    *
//		   ***
//		  *****
//		 *******
//		*********
		
//		입력2
//		행: 7
		
//		출력2
//		      *
//		     ***
//		    *****
//		   *******
//		  *********
//		 ***********
//		*************
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("행: ");
		int count = scan.nextInt();
		char star = '*';
		char empty = ' ';
		
		for(int i=0; i<count; i++) {
			int crit = count - 1;
			for(int j=0; j<(count - 1) * 2 + 1; j++) {
				if(Math.abs(j - crit) <= i) {
					System.out.print(star);
				} else {
					System.out.print(empty);
				}
			}
			System.out.println();
		}
	}
}
