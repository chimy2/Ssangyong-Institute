package com.test.question.array;

import java.util.Scanner;

public class Q065 {
//	배열: 최대 최소
	public static void main(String[] args) {
//		요구사항] 난수를 담고 있는 배열을 생성한 뒤 아래와 같이 출력하시오.
//			- 난수를 20개 발생 후 배열에 넣는다.
//			- 난수는 1 ~ 20 사이
//			- 배열을 탐색하여 범위에 만족하는 숫자만 출력한다.
		
//		입력
//		최대 범위: 15
//		최소 범위: 5
	
//		출력
//		원본: 10, 2, 3, 20, 15, 9, 5, 1, 3, 11, 15, 18, 9, 14, 18, 5, 8, 2, 1, 17
//		결과: 10, 15, 9, 5, 11, 15, 9, 14, 5, 8
		
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[20];
		
		System.out.print("최대 범위: ");
		int max = scan.nextInt();
		
		System.out.print("최소 범위: ");
		int min = scan.nextInt();
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random() * 20) + 1;
		}
		
		String output = "";
		
		for(int i=0; i<arr.length; i++) {
			output += arr[i];
			if(i != arr.length - 1) {
				output += ", ";
			}
		}
		System.out.printf("원본: %s", output);
		
		output = "";
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];
			if(num >= min && num <= max) {
				output += arr[i] + ", ";
			}
		}
		System.out.printf("\n결과: %s", output.substring(0, output.length() - 2));
	}
}
