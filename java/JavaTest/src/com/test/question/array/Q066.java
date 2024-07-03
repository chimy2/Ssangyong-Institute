package com.test.question.array;

import java.util.Arrays;

public class Q066 {
//	배열: 로또
	public static void main(String[] args) {
//		요구사항] 중복되지 않는 임의의 숫자 6개를 만드시오.(로또)
//			- 숫자의 범위: 1 ~ 45
//			- 오름차순 정렬
		
//		출력
//		[1, 5, 23, 36, 37, 41]
		
		int[] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			int num = getRandom();
			boolean check = false;
			
			for(int j=0; j<i; j++) {
				if(num == lotto[j]) {
					check = true;
					break;
				}
			}
			
			if(check) {
				i--;
			} else {
				lotto[i] = num;
			}
		}
		
		System.out.println(Arrays.toString(lotto));
	}

	private static int getRandom() {
		return (int) (Math.random() * 45) + 1;
	}	
}
