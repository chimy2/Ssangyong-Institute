package com.test.question.array;

public class Q075 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
			
//		출력
//		1	2	3	4	10
//		5	6	7	8	26
//		9	10	11	12	42
//		13	14	15	16	58
//		28	32	26	40	136

		int[][] arr = new int[5][5];
		
		setArr(arr);
		printArr(arr);
	}

	private static void setArr(int[][] arr) {
		int num = 1;
		int len = arr.length;
		
		for(int i=0; i<len - 1; i++) {
			for(int j=0; j<len - 1; j++) {
				arr[i][j] = num;
				arr[i][len -1] += num;
				arr[len - 1][j] += num;
				arr[len - 1][len - 1] += num;
				num++;
			}
		}
	}

	private static void printArr(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
