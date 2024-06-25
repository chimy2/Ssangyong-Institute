package com.test.question;

import java.util.Scanner;

public class Q014 {
//	메소드: 지하철
	public static void main(String[] args) {
//		요구사항] 지하철 탑승 소요 시간을 구하시오. 
//			지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 
//			총 걸리는 시간을 반환하는 메소드를 선언하시오.
//			- int getTime(int station, int change, int time)
//			- 각 역간 소요 시간: 2분 소요
//			- 환승 소요 시간: N분 소요
//			- 시간대에 따라 환승 소요 시간이 다르다.
//				- 평상시: 3분
//				- 출근시: 4분
//				- 퇴근시: 5분
		
//		입력1
//		역의 개수: 15
//		환승역의 횟수: 1
//		시간대(1.평상시, 2.출근시, 3.퇴근시): 1
		
//		출력1
//		총 소요시간은 33분입니다.
		
//		입력2
//		역의 개수: 22
//		환승역의 횟수: 2
//		시간대(1.평상시, 2.출근시, 3.퇴근시): 3
		
//		출력2
//		총 소요시간은 54분입니다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("역의 개수: ");
		int station = scan.nextInt();
		
		System.out.print("환승역의 횟수: ");
		int change = scan.nextInt();
		
		System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시): ");
		int time = scan.nextInt();
		
		System.out.printf("총 소요 시간은 %d분입니다.", getTime(station, change, time));
	}
	
	public static int getTime(int station, int change, int time) {
//		1)
		return station * 2 + change * (time +2);
		
//		2)
//		int result = station * 2;
//		if(time == 1) {
//			result += change * 3;
//		} else if (time == 2) {
//			result += change * 4;
//		} else if (time == 3) {
//			result += change * 5;
//		}
//		return result;
		
//		3)
//		int result = station * 2;
//		switch(time) {
//		case 1: result += change * 3;
//			break;
//		case 2: result += change * 4;
//			break;
//		case 3: result += change * 5;
//			break;
//		}
//		return result;
	}
	
}
