package com.test.question.array;

import java.util.Arrays;
import java.util.Scanner;

public class Q067 {
//	배열: 삽입
	public static void main(String[] args) {
//		요구사항] 배열에 요소를 삽입하시오.
//			- 배열 길이: 10
//			- 마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.
		
//		입력1
//		삽입 위치: 2 
//		값: 100 

//		출력1
//		원본: [5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
//		결과: [5, 6, 100, 1, 3, 2, 0, 0, 0, 0]
				
//		입력2
//		삽입 위치: 5 
//		값: 100 

//		출력2
//		원본: [5, 6, 1, 3, 2, 8, 7, 4, 10, 9]
//		결과: [5, 6, 1, 3, 2, 100, 8, 7, 4, 10]
		
		int[] arr = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삽입위치: ");
		int idx = scan.nextInt();
		
		System.out.print("값: ");
		int value = scan.nextInt();
		
		
		System.out.println("원본: " + Arrays.toString(arr));
		
		for(int i=arr.length - 2; i>=idx; i--) {
			arr[i + 1] = arr[i];
		}
		
		arr[idx] = value;
		
		System.out.println("결과: " + Arrays.toString(arr));
	}
}
