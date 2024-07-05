package ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
//		Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
		
//		UnBoxing
		int value = obj;
		System.out.println("value: " + value);
		
//		연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
		/*
		value: 100
		value: 100
		result: 200
		*/
	}
}
