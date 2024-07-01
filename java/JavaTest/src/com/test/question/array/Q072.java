package com.test.question.array;

public class Q072 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
		
//		출력
//		1	6	11	16	21
//		2	7	12	17	22
//		3	8	13	18	23
//		4	9	14	19	24
//		5	10	15	20	25

		int[][] arr = new int[5][5];
		
		setArr(arr);
		printArr(arr);
	}

	private static void setArr(int[][] arr) {
		int num = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0;j<5; j++) {
				arr[j][i] = num++;
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
