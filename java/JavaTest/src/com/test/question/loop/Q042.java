package com.test.question.loop;

import java.util.Calendar;

public class Q042 {
//	반복문: 날짜
	public static void main(String[] args) {
//		요구사항] 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
//			- Calendar 클래스 사용 금지
//			ex. 2024년 6월 28일은 739,065일째 되는 날이고 금요일입니다.
		Calendar date = Calendar.getInstance();
		
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH) + 1;
		int day = date.get(Calendar.DATE);
		int lastYear = year - 1;
		int totalDay = (lastYear * 365) + (lastYear / 4) - (lastYear / 100) 
				+ (lastYear / 400) + day;
		
		if(month > 1) totalDay += 31;
		if(month > 2) {
			if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				totalDay += 29;
			} else {
				totalDay += 28;
			}
		}
		if(month > 3) totalDay += 31;
		if(month > 4) totalDay += 30;
		if(month > 5) totalDay += 31;
		if(month > 6) totalDay += 30;
		if(month > 7) totalDay += 31;
		if(month > 8) totalDay += 31;
		if(month > 9) totalDay += 30;
		if(month > 10) totalDay += 31;
		if(month > 11) totalDay += 30;

		int weekDayNum = totalDay % 7;
		String weekDay = "";
		
		if(weekDayNum == 0) {
			weekDay = "일요일";
		} else if(weekDayNum == 1) {
			weekDay = "월요일";
		} else if(weekDayNum == 2) {
			weekDay = "화요일";
		} else if(weekDayNum == 3) {
			weekDay = "수요일";
		} else if(weekDayNum == 4) {
			weekDay = "목요일";
		} else if(weekDayNum == 5) {
			weekDay = "금요일";
		} else if(weekDayNum == 6) {
			weekDay = "토요일";
		}
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s입니다.",
				year, month, day, totalDay, weekDay);
	}
}
