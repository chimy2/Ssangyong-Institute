package com.test.question.array;

public class Q079 {
//	배열: 숫자 출력
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
			
//		출력	> 마방진
//		2	7	6
//		9	5	1
//		4	3	8
		
		int len = 3;
		int[][] arr = new int[len][len];
		int[][] direction = { { -1, 1 }, { 0, -1 } };
		int x = (len / 2) - 1;
		int y = 0;
		
		for(int value=0; value<=len * len; value++) {
			int nextX = (x + len + direction[0][0]) % len;
			int nextY = (y + len + direction[0][1]) % len;
			boolean check = true;
			
			if(arr[nextX][nextY] != 0 ) {
				check = false;
			}
			x = (x + len + direction[check ? 0 : 1][0]) % len;
			y = (y + len + direction[check ? 0 : 1][1]) % len;
			arr[x][y] = value;
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
