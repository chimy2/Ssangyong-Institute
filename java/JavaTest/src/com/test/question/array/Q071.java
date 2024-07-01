package com.test.question.array;

public class Q071 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
		
//		출력
//		25	24	23	22	21
//		20	19	18	17	16
//		15	14	13	12	11
//		10	9	8	7	6
//		5	4	3	2	1

		int[][] arr = new int[5][5];
		
		setArr(arr);
		printArr(arr);
	}

	private static void setArr(int[][] arr) {
		int num = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0;j<5; j++) {
				arr[4 - i][4 - j] = num++;
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
