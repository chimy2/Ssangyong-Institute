package com.test.question.loop;

public class Q041 {
//	반복문: 숫자 합
	public static void main(String[] args) {
//		요구사항] 아래와 같이 출력하시오.
//			- 누적값이 1000을 넘어가는 순간 루프를 종료하시오.
		
//		출력
//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 
//		+ 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 + 21 + 22
//		+ 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34
//		+ 35 + 36 + 37 + 38 + 39 + 40 + 41 + 42 + 43 + 44 + 45 = 1035
		
		int sum = 0;
		
//		1)
//		for(int i=1; sum<=1000; i++) {
//			sum += i;
//			System.out.print(i + " + ");
//		}
		
//		2)
		int count = 1;
		
		while(sum <= 1000) {
			sum += count;
			System.out.print(count++ + " + ");
		}
			
		System.out.println("\b\b = " + sum);
	}
}
