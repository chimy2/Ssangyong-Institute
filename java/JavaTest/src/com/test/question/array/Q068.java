package com.test.question.array;

import java.util.Arrays;
import java.util.Scanner;

public class Q068 {
//	배열: 삭제
	public static void main(String[] args) {
//		요구사항] 배열의 요소를 삭제하시오.
//			- 배열 길이: 10
//			- 마지막 요소는 0으로 채우시오.
		
//		입력1
//		삭제 위치: 2 

//		출력1
//		원본: [5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
//		결과: [5, 6, 3, 2, 0, 0, 0, 0, 0, 0]
				
//		입력2
//		삭제 위치: 5 

//		출력2
//		원본: [5, 6, 1, 3, 2, 8, 7, 4, 10, 9]
//		결과: [5, 6, 1, 3, 2, 7, 4, 10, 9, 0]
		
		int[] arr = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제 위치: ");
		int idx = scan.nextInt();
		
		System.out.println("원본: " + Arrays.toString(arr));
		
		for(int i=idx; i<arr.length-1; i++) {
			arr[i] = arr[i + 1];
		}
		
		arr[arr.length - 1] = 0;
		
		System.out.println("결과: " + Arrays.toString(arr));
	}
}
