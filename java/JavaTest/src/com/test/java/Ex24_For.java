package com.test.java;

public class Ex24_For {
	public static void main(String[] args) {
		/*
		 * 중첩된 반복문
		 * - 단일 for문
		 * - 2중 for문
		 * - 3중 for문
		 * 
		 * for () {
		 * 	문장;
		 * }
		 * 
		 * for () {
		 * 	for () {
		 * 		문장;
		 * 	}
		 * }
		 * 
		 * for () {
		 * 	for () {
		 * 		for () {
		 * 			문장;
		 * 		}
		 * 	}
		 * }
		 */
		
//		m1();
//		m2();
//		m3();
		m4();
	}

	private static void m4() {
//		별찍기(제어문)
//		5 x 5
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		1 + 2 + 3 + 4 + 5
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		5 + 4 + 3 + 2 + 1
		for(int i=0; i<5; i++) {
			for(int j=i; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		벽에 붙여서 1 + 2 + 3 + 4 + 5
		for(int i=0; i<5; i++) {
			for(int j=4; j>=0; j--) {
				System.out.print(i >= j ? "*" : " ");
			}
			System.out.println();
		}
//		벽에 붙여서 5 + 4 + 3 + 2 + 1
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(i > j  ? " " : "*");
			}
			System.out.println();
		}
	}

	private static void m3() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(i == 5) {
					break;
				}
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
		
	}

	private static void m2() {
//		구구단
//		2단 ~ 9단
		for (int i=2; i<=9; i++) {
			System.out.println("==========");
			System.out.printf("   %d단\n", i);
			System.out.println("==========");
			for (int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i * j);
			}
		}
	}

	private static void m1() {
//		단일 for문
		for(int i=0; i<10; i++) {
			System.out.println("i: " + i);
		}
		System.out.println();
		
//		2중 for문
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
//				System.out.println("안녕하세요.");
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
		System.out.println();
		
//		3중 for문
		for (int i=0; i<24; i++) {
			for (int j=0; j<60; j++) {
				for (int k=0; k<60; k++) {
//					System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
					System.out.printf("%d시 %d분 %d초\n", i, j, k);
				}
			}
		}
		
//		학교
//		for (학년) {
//			for (반) {
//				for (번호) {
//					
//				}
//			}
//		}
		
//		아파트
//		for (단지) {
//			for (동) {
//				for (층) {
//					for (호) {
//						
//					}
//				}
//			}
//		}
	}
}
