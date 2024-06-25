package com.test.java;

public class Ex14_Method {
	public static void main(String[] args) {
//		public static void hello()
//		- hello: 메서드명 > 캐멀 표기법 + 의미있게
//		- (): 인자리스트(Parameters, Arguments), 매개변수
		
//		요구사항] '홍길동'에게 인사를 하는 메서드를 구현하시오.
		hello();
		
//		요구사항] '아무개'에게 인사를 하는 메서드를 구현하시오.
		hello2();
		
//		요구사항] '테스트'에게 인사를 하는 메서드를 구현하시오.
		hello3();
		
//		요구사항] 우리 강의실의 모든 사람에게 각각 ~ 23명
//		요구사항] 대한민국 모든 국민에게 ~ 4천만개
		
//		Ex14_Method is not applicable for the arguments()
//		helloEveryone();
		
		helloEveryone("홍길동"/* 매개변수 전달*/);
		helloEveryone("아무개");
		helloEveryone("테스트"/* 인자, 실인자, real arguments */);
//		인자값과 매개변수의 자료형이 동일해야 한다.
//		helloEveryone(100);
		
		int age = 20;
		checkAge(age);
//		checkAge("스무살");
		
//		형변환이 가능하면 가능
		byte age2 = 20;
		checkAge(age2);

//		성적 계산
//		- 매개변수의 순서(🌟🌟🌟)
//		- 매개변수의 개수(🌟🌟🌟)
		checkScore(100, 90, 80);
//		checkScore(100, 90);
//		checkScore(100, 90, 80, 70);
	}//main
	
	public static void hello() {
//		구현부
		System.out.println("홍길동님 안녕하세요.");
	}
	
	public static void hello2() {
		System.out.println("아무개님 안녕하세요.");
	}
	
	public static void hello3() {
		System.out.println("테스트님 안녕하세요.");
	}
	
	public static void helloEveryone(String name/* 매개변수, 가인자, 형식인자, formal argument */) {
//		String name = "테스트";
		System.out.println(name + "님 안녕하세요.");
	}
	
	public static void checkAge(int age) {
		String result = age >= 18 ? "통과" : "거절";
		System.out.printf("입력한 나이 %d세는 %s입니다\n", age, result);
	}
	
	/**
	 * 성적을 계산합니다.
	 * @param kor 국어
	 * @param eng 영어
	 * @param math 수학
	 */
	public static void checkScore(int kor, int eng, int math) {
		int total = kor + eng + math;
		double avg = (double)total / 3;
//		double avg = total / 3.0;
		String result = avg >= 60 ? "합격" : "불합격";
		
		System.out.printf("평균 점수 %.1f점은 %s입니다.\n", avg, result);
		
	}
}
