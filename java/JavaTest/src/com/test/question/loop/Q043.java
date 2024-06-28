package com.test.question.loop;

import java.util.Scanner;

public class Q043 {
//	반복문: 숫자 게임
	public static void main(String[] args) {
//		요구사항] 컴퓨터가 1~10 사이의 숫자 1개를 생각하면 
//			사용자가 맞추는 프로그램을 구현하시오.
//			- 시도 횟수가 10회가 넘어가면 프로그램을 종료하시오.
		/*
		입출력1
		컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.

		숫자: 1 
		틀렸습니다.
		
		숫자: 3 
		틀렸습니다.
		
		숫자: 7 
		틀렸습니다.
		
		숫자: 2 
		틀렸습니다.
		
		숫자: 5 
		맞았습니다.
		
		컴퓨터가 생각한 숫자는 5입니다.
		정답을 맞추는데 시도한 횟수는 5회입니다.
		
		프로그램을 종료합니다.
		
		입출력2
		컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.

		숫자: 1 
		틀렸습니다.
		
		숫자: 3 
		틀렸습니다.
		
		숫자: 7 
		틀렸습니다.
		
		숫자: 2 
		틀렸습니다.
		
		숫자: 3 
		틀렸습니다.
		
		숫자: 7 
		틀렸습니다.
		
		숫자: 2 
		틀렸습니다.
		
		숫자: 3 
		틀렸습니다.
		
		숫자: 7 
		틀렸습니다.
		
		컴퓨터가 생각한 숫자는 5입니다.
		모든 기회를 실패했습니다.
		
		프로그램을 종료합니다.
		 */
		
		
		int goal = (int) (Math.random() * 10) + 1;
		int count = 0;
		boolean check = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("컴퓨터가 1~10사이의 숫자를 1개 생각했습니다.\n");
		
		while(!check && count < 10) {
			System.out.print("숫자: ");
			int answer = scan.nextInt();
			if(answer == goal) {
				System.out.println("맞았습니다.");
				check = true;
			} else {
				System.out.println("틀렸습니다.");
			}
			System.out.println();
			count++;
		}
		
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", goal);
		if(check) {
			System.out.printf("정답을 맞추는데 시도한 횟수는 %d입니다\n", count);
		} else {
			System.out.println("모든 기회를 실패했습니다.");
		}
		System.out.println("\n프로그램을 종료합니다.");
	}
}
