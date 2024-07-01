package com.test.question.array;

public class Q064 {
//	배열: 최대 최소
	public static void main(String[] args) {
//		요구사항] 1~20 사이의 난수를 담고 있는 배열을 생성하고 최댓값과 최솟값을 출력하시오.
//			- 난수를 20개 발생 후 배열에 넣는다.
//			- 난수는 1 ~ 20 사이
		
//		출력
//		원본: 10, 9, 3, 18, 15, 9, 5, 4, 3, 11, 15, 18, 9, 14, 18, 5, 8, 7, 9, 17,
//		최댓값: 18
//		최솟값: 3
		
		int[] randoms = new int[20];
		
		for(int i=0; i<randoms.length; i++) {
			randoms[i] = (int)(Math.random() * 20) + 1;
		}

		int max = 0;
		int min = 20;
		
		System.out.print("원본: ");
		
		for(int i=0; i<randoms.length; i++) {
			int num = randoms[i];
			max = Math.max(max, num);
			min = Math.min(min, num);
			
			System.out.print(num);
			if(i != randoms.length - 1) {
				System.out.print(", ");
			}
			
		}
		
		System.out.printf("\n최댓값: %d\n", max);
		System.out.printf("최솟값: %d", min);
	}
}
