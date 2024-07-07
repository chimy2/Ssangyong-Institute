package com.test.question.array;

public class Q077 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
			
//		출력
//		1	2	4	7	11
//		3	5	8	12	16
//		6	9	13	17	20
//		10	14	18	21	23
//		15	19	22	24	25
		
		int len = 5;
		int[][] arr = new int[len][len];
		
		for(int i=0, value=1; i<len * 2 - 1; i++) {
			int count = len > i ? i + 1: len - (i + 1) % len ;
			
			for(int j=0; j<count; j++, value++) {
				int x = 0;
				int y = 0;
				
				if(len > i) {
					x = j;
					y = i % len - j;
				} else {
					x = i % len + (j + 1);
					y = len - 1 - j;
				}

				arr[x][y] = value;
			}
		}
		
		printArr(arr);
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
