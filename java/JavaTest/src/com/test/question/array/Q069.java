package com.test.question.array;

import java.util.Arrays;
import java.util.Scanner;

public class Q069 {
//	배열: 요소 더하기
	public static void main(String[] args) {
//		요구사항] 배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.
//			- 원본 배열 길이: 사용자 입력
//			- 원본 배열 요소: 난수(1~9)
//			- 결과 배열 길이: 사용자 입력 / 2
		
//		입력1
//		배열 길이: 10 
		
//		출력1
//		원본: [ 1, 5, 3, 6, 2, 7, 8, 2, 2, 9 ]
//		결과: [ 6, 9, 9, 10, 11 ]
		
//		입력2
//		배열 길이: 4 
		
//		출력2
//		원본: [ 5, 3, 9, 1 ]
//		결과: [ 8, 10 ]
		
//		입력3
//		배열 길이: 5 
		
//		출력3
//		원본: [ 1, 5, 3, 2, 7 ]
//		결과: [ 6, 5, 7 ]
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("배열 길이: ");
		int len = scan.nextInt();

		int[] originArr = new int[len];
		int[] sumArr = new int[(int) Math.round(len / 2.0)];
		
		for(int i=0; i<len; i++) {
			originArr[i] = (int) (Math.random() * 9) + 1;
		}
		
		for(int i=0; i<sumArr.length; i++) {
			if(len > i * 2 + 1) {
				sumArr[i] = originArr[i * 2] + originArr[i * 2 + 1];
			} else {
				sumArr[i] = originArr[i * 2];
			}
		}
		
		System.out.printf("원본: %s\n", Arrays.toString(originArr));
		System.out.printf("결과: %s", Arrays.toString(sumArr));
	}
}
