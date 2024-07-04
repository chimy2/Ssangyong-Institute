package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex40_Overriding {
	public static void main(String[] args) {
		Time t1 = new Time(2, 30);
		Time t2 = new Time(3, 40);
		
		System.out.println(t1.info());
		System.out.println(t2.info());
		
		System.out.println(t1);
//		객체를 가져오면 객체값을 가져오는게 아니라 컴파일러가 바꾼 코드로 변경됨
		System.out.println(t1.toString());
		
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		System.out.println(now.toString());
		
	}
}

//시간 클래스
class Time {//extends Object
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	public String info() {
		return this.hour + ":" + this.min;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
//	@Override	//어노테이션(일종의주석
//	public String toString() {
//		return this.hour + ":" + this.min;
//	}
	
	
}