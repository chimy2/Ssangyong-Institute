package com.test.question.array;

public class Q074 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
		
//		출력
//		0	0	1	0	0
//		0	2	3	4	0
//		5	6	7	8	9
//		0	10	11	12	0
//		0	0	13	0	0


		int[][] arr = new int[5][5];
		
		setArr(arr);
		printArr(arr);
	}

	private static void setArr(int[][] arr) {
		int num = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=i;j<5; j++) {
				arr[][] = num++;
			}
		}
	}

	private static void printArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
