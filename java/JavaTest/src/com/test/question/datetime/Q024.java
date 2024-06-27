package com.test.question.datetime;

import java.util.Calendar;
import java.util.Scanner;

public class Q024 {
//	날짜시간: 배달 전화
	public static void main(String[] args) {
//		요구사항] 여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다. 
//			고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
//			- 전화를 걸면 짜장면은 10분 뒤에 도착합니다.
//			- 전화를 걸면 치킨은 18분 뒤 도착합니다.
//			- 전화를 걸면 피자는 25분 뒤 도착합니다.
//			- 음식을 받기 원하는 시간은 오후 11시 이전에만 가능합니다.(날짜 변경 금지)
		
//		입력
//		음식을 받기 원하는 시각
//		시: 14 
//		분: 42
		
//		출력
//		짜장면: 14시 32분
//		치킨: 14시 24분
//		피자: 14시 17분
		
		Scanner scan = new Scanner(System.in);
		Calendar deli = Calendar.getInstance();
		Calendar order = Calendar.getInstance();
		
		System.out.println("음식을 받기 원하는 시각");
		
		System.out.print("시: ");
		int hour = scan.nextInt();
		deli.set(Calendar.HOUR_OF_DAY, hour);
		
		System.out.print("분: ");
		int minute = scan.nextInt();
		deli.set(Calendar.MINUTE, minute);
		
//		1)
		order.setTimeInMillis(deli.getTimeInMillis());
		order.add(Calendar.MINUTE, -10);
		System.out.printf("짜장면: %d시 %d분\n", order.get(Calendar.HOUR_OF_DAY), order.get(Calendar.MINUTE));
		
		order.setTimeInMillis(deli.getTimeInMillis());
		order.add(Calendar.MINUTE, -18);
		System.out.printf("치킨: %d시 %d분\n", order.get(Calendar.HOUR_OF_DAY), order.get(Calendar.MINUTE));
		
		order.setTimeInMillis(deli.getTimeInMillis());
		order.add(Calendar.MINUTE, -25);
		System.out.printf("피자: %d시 %d분\n", order.get(Calendar.HOUR_OF_DAY), order.get(Calendar.MINUTE));

//		2)
		printOrderTime("짜장면", deli);
		printOrderTime("치킨", deli);
		printOrderTime("피자", deli);
	}

	private static void printOrderTime(String name, Calendar time) {
		Calendar order = Calendar.getInstance();
		int take = 0;
		
		if(name.equals("짜장면")) {
			take = 10;
		} else if(name.equals("치킨")) {
			take = 18;
		} else if(name.equals("피자")) {
			take = 25;
		}
		order.setTimeInMillis(time.getTimeInMillis());
		order.add(Calendar.MINUTE, -take);
		System.out.printf("%s: %d시 %d분\n", name, 
				order.get(Calendar.HOUR_OF_DAY), order.get(Calendar.MINUTE));
	}
}
