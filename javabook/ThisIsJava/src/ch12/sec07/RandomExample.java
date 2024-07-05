package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
//		선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3);
//		Random 생성자
//		1. Random()
//		2. Random(long seed)
//			- 주어진 종자값을 사용해서 난수를 얻음
//				> 종자값이 같으면 항상 같은 패턴에 난수를 생성
		
		System.out.println("선택번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
//		당첨번호
		int[] winningNumber = new int[6];
		random = new Random(5);
		System.out.println("당첨번호: ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
//		당첨여부
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.println("당첨여부: ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
		/*
		선택번호: 
		15 21 16 17 34 28 
		당첨번호: 
		18 38 45 15 22 36 
		당첨여부: 
		당첨되지 않았습니다.
		*/
	}
}
