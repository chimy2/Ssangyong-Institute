package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex19_DateTime {
	public static void main(String[] args) {
		/*
		 * 자바의 날짜/시간 자료형
		 * 1. Date 클래스
		 * 2. Calendar 클래스
		 * ---------------------------------
		 * 3. java.time 패키지 > 여러 클래스
		 * 
		 * 시각
		 * ex. 2024년 6월 25일 17시 22분 15초
		 * 시간
		 * ex. 8시간
		 * 
		 * 시각, 시간 > 연산
		 * 
		 * 시각 + 시각 = x
		 * ex. 2024년 6월 25일 17시 22분 15초 + 2024년 7월 10일 10시 10분 20초
		 * 
		 * 시각 - 시각 = 시간
		 * ex. 2024년 7월 10일 10시 10분 20초 - 2024년 6월 25일 17시 22분 15초
		 * 	
		 * 시간 + 시간 = 시간
		 * 시간 - 시간 = 시간
		 * 
		 * 시각 + 시간 = 시각
		 * ex. 2024년 6월 25일 17시 22분 15초 + 10일
		 * 
		 * 시각 + 시간 = 시각
		 * ex. 2024년 6월 25일 17시 22분 15초 - 10일
		 * 
		 * 
		 */
		
//		m1();
		m2();
		
	}

	private static void m2() {
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		/*
		 * java.util.GregorianCalendar[
		 * 	time=1719304837729,areFieldsSet=true,areAllFieldsSet=true,
		 * 	lenient=true,zone=sun.util.calendar.ZoneInfo[id="GMT+09:00",
		 * 	offset=32400000,dstSavings=0,useDaylight=false,transitions=0,
		 * 	lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
		 * 	YEAR=2024,MONTH=5,WEEK_OF_YEAR=26,WEEK_OF_MONTH=5,DAY_OF_MONTH=25,
		 * 	DAY_OF_YEAR=177,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=5,
		 * 	HOUR_OF_DAY=17,MINUTE=40,SECOND=37,MILLISECOND=729,ZONE_OFFSET=32400000,
		 * 	DST_OFFSET=0
		 * ]
		 */

	}

	private static void m1() {
//		현재 시각을 얻어오기
		
//		컴퓨터 메인보드 > 시계 
		Date now = new Date();
		System.out.println(now);
	}
	
	
}
