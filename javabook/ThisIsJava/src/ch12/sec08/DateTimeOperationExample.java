package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재 시간: " + now.format(dtf));
		
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈: " + result1.format(dtf));
		
		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺼셈: " + result2.format(dtf));
		
		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈: " + result3.format(dtf));
		/*
		현재 시간: 2024.07.05 오전 11:51:55
		1년 덧셈: 2025.07.05 오전 11:51:55
		2월 뺼셈: 2024.05.05 오전 11:51:55
		7일 덧셈: 2024.07.12 오전 11:51:55
		*/
	}
}