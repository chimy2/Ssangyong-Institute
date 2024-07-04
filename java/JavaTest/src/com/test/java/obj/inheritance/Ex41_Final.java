package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex41_Final {
	public static void main(String[] args) {
		/*
		 * final 키워드
		 * - 한번 결정하면 바꿀 수 없다
		 * - 안정성이 높아진다.
		 * 
		 * 1. 변수 적용(지역 변수, 멤버 변수)
		 *  - 초기화 이후에 값을 변경할 수 없다.
		 *  - (이름이 있는)상수(리터럴)
		 *  - 대문자
		 *  
		 * 2. 메서드 적용
		 * 	- 상속 시 오버라이딩 방지
		 * 
		 * 3. 클래스 적용
		 * 	- 상속 방지
		 */
		
		int a = 10;
		final int b = 20;
		
		a = 100;
//		b = 200;
//		The final local variable b cannot be assigned. 
//		It must be blank and not using a compound assignment
		
		System.out.println(Calendar.YEAR);	//상수 > final
		
//		성별
//		Gender gender = new Gender();
//		System.out.println(gender.male);
//		System.out.println(gender.female);
		
//		System.out.println(Gender.male);
		
//		Gender.male = 3;
		
		System.out.println(Gender.MALE);
	}
}

class Gender {
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
}

final class FinalParent {
	final public boolean check() {
		return true;
	}
}

class FinalChild /* extends FinalParent */ {
//	The type FinalChild cannot subclass the final class FinalParent
	
//	@Override
//	public boolean check() {
//		return false;
//	}
//	Cannot override the final method from FinalParent
}