package com.test.question.array;

public class Q078 {
//	배열: 숫자 출력
	private static int x = 0;
	private static int y = 0;
	private static int direction = 0;

	private static final int LEN = 5;
	private static int[][] arr = new int[LEN][LEN];

	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
	
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
			
//		출력
//		1	2	3	4	5
//		16	17	18	19	6
//		15	24	25	20	7
//		14	23	22	21	8
//		13	12	11	10	9

		for(int value=1; value<=LEN * LEN; value++) {
			if(arr[x][y] == 0) {
				arr[x][y] = value;
			}
			
			if(value == LEN * LEN) {
				break;
			}

			if(!isMoveedCorrectDirection()) {
				value--;
			}
		}
		
		printArr(arr);
	}

	private static boolean isMoveedCorrectDirection() {
		boolean check = true;

		if(direction == RIGHT) {
			y++;
			if(y == LEN || arr[x][y] != 0) {
				y--;
				check = false;
			}
		} else if(direction == DOWN) {
			x++;
			if(x == LEN || arr[x][y] != 0) {
				x--;
				check = false;
			}
		} else if(direction == LEFT) {
			y--;
			if(y == -1 || arr[x][y] != 0) {
				y++;
				check = false;
			}
		} else if(direction == UP) {
			x--;
			if(x == -1 || arr[x][y] != 0) {
				x++;
				check = false;
			}
		}
		
		if(!check) {
			direction = (direction + 1) % 4;
		}
		
		return check;
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
