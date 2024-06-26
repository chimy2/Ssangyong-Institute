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
//		m2();
		
//		int a = 10;
//		a = 20;
//		a = 30;
//		
//		System.out.println(a);
//		
//		test(a);
//		
//		System.out.println(a);

//		m3();
//		m4();
		
//		+ > 산술? 문자열?
//		연산 방향?
		
		/*
		System.out.println(10 + 20 + 30);	//60
		System.out.println(10 + 20 + "30");	//3030
		System.out.println(10 + "20" + 30);	//102030
		System.out.println("10" + 20 + 30);	//102030
		
		int a = 10;
		int b = 5;
		
		System.out.println("10 + 5 = 15");
		System.out.println(a + " + " + b + " = " + a + b);	//10 + 5 = 105
		System.out.println(a + " + " + b + " = " + (a + b));//10 + 5 = 15
		*/
		
//		문자열 > 숫자(값형)
//		- "100" > 100
		int a = Integer.parseInt("100");
		
//		숫자 > 문자열
//		- 100 > "100"
		String b = String.valueOf(100);
//		"" > 빈문자열(Empty String)
		String c = 100 + "";
		
		//F3, Ctrl + 클릭 - 메소드/변수 선언부로 이동
//		m5();	
//		m6();
		m7();
	}
	
	private static void m7() {
//		연산
//		시간 + 시간 = 시간
//		시간 - 시간 = 시간
		
//		2시간 + 1시간 = 3시간
		int h1 = 2;
		int h2 = 1;
		
		System.out.println(h1 + h2);
		
//		2시간 30분 + 10분 = 2시간 40분
		int hour = 2;
		int min = 30;
		min += 10;
		System.out.printf("%d시간 %d분\n", hour, min);
		
//		2시간 30분 + 40분 = 2시간 70분 = 3시간 10분
		min = 30;
		min += 40;

//		자리올림
		hour += min / 60;
		min %= 60;
		System.out.printf("%d시간 %d분\n", hour, min);
		
	}

	private static void m6() {
//		연산
//		- 시각 - 시각 = 시간
	
//		내가 태어나서 살아온 시간?
		
//		개강일~종강일 > 며칠?
		
//		올해 크리스마스 며칠 남았는지?
		
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1995, 6, 10);	// 1995년 7월 10일

//		The operator - is undefined for the argument type(s) java.util.Calendar, java.util.Calendar
//		System.out.println(now - birthday);
		
//		2024년 6월 26일
//		-
//		1995년 7월 10일

		System.out.println(now.getTimeInMillis());		//1719368402555
		System.out.println(birthday.getTimeInMillis());	//805342667893
		
		long gap = now.getTimeInMillis() - birthday.getTimeInMillis();
		
		System.out.printf("살아온 시간: %,dms\n", gap);							//살아온 시간: 914,025,599,984ms
		System.out.printf("살아온 시간: %,d시간\n", gap / 1000 / 60 / 60);		//살아온 시간: 253,895시간
		System.out.printf("살아온 시간: %,d일\n", gap / 1000 / 60 / 60 / 24);	//살아온 시간: 10,578일
		
//		수료일까지 며칠 남았는지?
		Calendar end = Calendar.getInstance();
		end.set(2024, 11, 2);
		
		gap = end.getTimeInMillis() - now.getTimeInMillis();
		System.out.printf("남은 수업일 수 : %d일\n", gap / 1000 / 60 / 60 / 24);	//남은 수업일 수 : 159일
		
//		오늘 집에 가려면 몇시간 남았는지?
		Calendar out = Calendar.getInstance();
		out.set(Calendar.HOUR_OF_DAY, 17);
		out.set(Calendar.MINUTE, 50);
		out.set(Calendar.SECOND, 0);
		
		System.out.printf("남은 시간: %.1f시간\n", 
				(out.getTimeInMillis() - now.getTimeInMillis()) / 1000.0 / 60 / 60);	//남은 시간: 6.4시간
		
//		out.getTimeInMillis()
//		- Epoch Time
//		- Tick
	}

	private static void m5() {
//		연산
//		- 시각 + 시간
//		- 시각 - 시간
		
//		오늘 만난 커플 > 100일?
		Calendar now = Calendar.getInstance();
		
//		System.out.printf("1일차 %tF\n", now);
//		
//		now.add(Calendar.DATE, 99);
//		System.out.printf("100일차 %tF\n", now);
		
//		now.add(Calendar.YEAR, 20);
//		now.add(Calendar.MONTH, 3);
//		now.add(Calendar.HOUR, 5);
//		now.add(Calendar.DATE, -7);
		now.add(Calendar.MINUTE, -45);
		System.out.printf("%tF %tT\n", now, now);
	}

	private static void m4() {
		Calendar now = Calendar.getInstance();
		
		System.out.println(now);
		
//		내가 원하는 부분만 추출
//		- int get(int)
//		
		
		System.out.println(now.get(1));							//2024
		System.out.println(now.get(Calendar.YEAR));				//2024	, 년
		System.out.println(now.get(Calendar.MONTH));			//5		, 월(0~11) 
		System.out.println(now.get(Calendar.DATE));				//26	, 일
		System.out.println(now.get(Calendar.HOUR));				//9		, 시(12H)
		System.out.println(now.get(Calendar.HOUR_OF_DAY));		//9		, 시(24H)
		System.out.println(now.get(Calendar.MINUTE));			//49	, 분 
		System.out.println(now.get(Calendar.SECOND));			//5		, 초
		System.out.println(now.get(Calendar.MILLISECOND));		//101	, 밀리초
		System.out.println(now.get(Calendar.AM_PM));			//0		, 오전(0), 오후(1)
		System.out.println(now.get(Calendar.DAY_OF_YEAR));		//178	, 일(년)
		System.out.println(now.get(Calendar.DAY_OF_MONTH));		//26	, 일(월)
		System.out.println(now.get(Calendar.DAY_OF_WEEK));		//4		, 일(주) == 요일, 1(일) ~ 7(토)
		System.out.println(now.get(Calendar.WEEK_OF_YEAR));		//26	, 주(년)
		System.out.println(now.get(Calendar.WEEK_OF_MONTH));	//5		, 주(월)
		
//		요구사항] "오늘은 2024년 6월 26일입니다." 출력
		
		System.out.printf("오늘은 %d년 %d월 %d일입니다.\n", now.get(Calendar.YEAR),
				now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
//		요구사항] "오늘은 2024년 06월 26일입니다." 출력

		System.out.printf("오늘은 %d년 %s월 %d일입니다.\n", now.get(Calendar.YEAR),
				(now.get(Calendar.MONTH) + 1 < 10 ? "0" + (now.get(Calendar.MONTH) + 1) 
						: now.get(Calendar.MONTH) + 1 + ""), now.get(Calendar.DATE));
		
		System.out.printf("오늘은 %d년 %02d월 %02d일입니다.\n", now.get(Calendar.YEAR),
				now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
		
		System.out.printf("오늘은 %d년 %s월 %s일입니다.\n", now.get(Calendar.YEAR),
				addZero(now.get(Calendar.MONTH) + 1), addZero(now.get(Calendar.DATE)));
		
//		printf, String.format
//		- 날짜/시간 형식 문자
		System.out.printf("%tF\n", now);	//2024-06-26
		System.out.printf("%tT\n", now);	//10:40:25
		System.out.printf("%tA\n", now);	//수요일
		
	}

	private static String addZero(int i) {
		String result = i < 10 ? "0" + i : i + "";
		return result;
	}

	private static void m3() {
//		메서드명의 패턴
//		- getXXX(): getter. 읽기
//		ex) getName(), getAge(), getNumber()
		
//		- setXXX(): setter. 쓰기
//		ex) setName("홍길동"), setAge(20)
		
//		- isXXX(): 확인. 반환값(boolean)
//		ex) isNumeric("10")
		
//		Calendar 클래스
//		1. int get(int)
//		2. void set(값)

//		현재 시각
		Calendar now = Calendar.getInstance();
		
//		특정 시각(날짜)를 생성하기
//		- 현재 시각 > 값 수정 > 원하는 시각
		Calendar christmas = Calendar.getInstance();
		
		int year = 1;
		
		christmas.set(year, 2025);
		System.out.println(christmas.getWeekYear());
		
		System.out.println(Calendar.YEAR);	//캘린더 상수
		christmas.set(Calendar.YEAR, 2026);
		System.out.println(christmas.getWeekYear());
		
		christmas.set(Calendar.MONTH, 11);
		christmas.set(Calendar.DATE, 25);
		christmas.set(Calendar.HOUR, 6);
		christmas.set(Calendar.MINUTE, 0);
		christmas.set(Calendar.SECOND, 0);
		System.out.println(christmas);
		
		christmas.set(2024, 11, 25);
		christmas.set(2024, 11, 25, 14, 30);
		christmas.set(2024, 11, 25, 14, 30, 10);
		System.out.println(christmas);
		
	}

//	Ctrl + F11 > 실행
//	F11 > 실행(x), 디버깅(o)
//	- 더블클릭 > breakpoint
//	- F6 > 한줄씩 실행
//	- F8 > 다음 breakpoint로 이동

	private static void test(int a) {
		int b = a + 10;
		b *= 2;
		System.out.println(b);
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
