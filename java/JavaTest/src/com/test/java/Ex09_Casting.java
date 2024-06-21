package com.test.java;

public class Ex09_Casting {
	public static void main(String[] args) {
		/*
		 * 형변환, 자료형변환
		 * - Casting, Promotion
		 * - 하나의 자료형을 다른 자료형으로 변환하는 작업
		 * - 코드 작성을 유연하게 하기 위해서(개발자 편의성?)
		 * - int > double
		 * - long > float
		 * - byte > short
		 * 
		 * 1. 암시적(묵시적) 형변환. 자동 형변환, Promotion
		 * - 큰형 = 작은형
		 * - 100% 안전
		 * 
		 * 2. 명시적 형변환. 강제 형변환, Casting
		 * - 작은형 = 큰형
		 * - 경우에 따라 안전할 수도 있다
		 * 		- 오버플로우 발생 가능~!
		 */
		
		byte b1;	//1byte
		short s1;	//2byte
		
		b1 = 10; // 원본
		
//		LValue 	= RValue
//		공간		= 값
//		🌟🌟🌟절대 규칙 > 
//			- LValue와 RValue의 자료형은 반드시 동일해야 한다. 
//			- 만약 동일하지 않으면 무조건 컴파일 오류
		
//		short = byte
		s1 = b1;
		
//		(자료형) : 형변환 연산자
//		s1 = (short)b1; 컴파일 시 이렇게 바뀜
		
//		검증
		System.out.println(s1);
		
		byte b2;
		short s2;
		
		s2 = 200;

//		Type mismatch: cannot convert from short to byte
//		b2 = s2;
		b2 = (byte)s2;

		System.out.println(b2);
		
		
		int money = 2100000000;
		short money2;
		
//		오버 플로우(Overflow)
//		언더 플로우(Underflow)
		money2 = (short)money;
		
		System.out.println("계좌 이체 결과 잔액: " + money2);
		
	}
}
