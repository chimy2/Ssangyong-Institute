package com.test.java;

import java.util.Scanner;

public class Ex22_For {
	public static void main(String[] args) {
		/*
		 * 반복문
		 * - 코드를 원하는 횟수만큼 반복 실행하는 제어
		 * - 생산성 + 유지보수
		 *  
		 * for 문
		 * 
		 * for (초기식; 조건식; 증감식) {/↓구현부
		 * 	문장;
		 * }
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
//		m9();
//		m10();
//		m11();
//		m12();
		m13();
	}//main

	private static void m13() {
//		난수 만들기
//		- 임의의 수 만들기
//		1. Math 클래스
//		2. Random 클래스
		
//		1, 1, 1, 1, 1, 1, 1, 1, 0, 0
		
//		System.out.println(Math.random());
//		0.5636974111244247

//		Returns a double value with a positive sign, 
//		greaterthan or equal to 0.0 and less than 1.0.
//		0~0.99999999999999999
		for(int i=0; i<10; i++) {
//			System.out.println(Math.random());
			
//			가공
//			0.0 > 0.0 > 0
//			0.1 > 1.0 > 1
//			...
//			0.8 > 8.0 > 8
//			0.9 > 9.0 > 9
			
//			System.out.println((int)(Math.random() * 10));
			
//			주사위(1 ~ 6)
//			0.0 > 0.0 > 0 > 1
//			0.1 > 0.6 
//			0.2 > 1.2
//			0.3	> 1.8
//			0.4 > 2.4
//			0.5 > 3.0
//			0.6 > 3.6
//			0.7 > 4.2
//			0.8 > 4.8
//			0.9 > 5.4 > 5 > 6
			
			System.out.println((int)(Math.random() * 6) + 1);
		}
	}

	private static void m12() {
//		지역 변수의 영역
//		- 자신이 포함된 메서드/제어문 영역
//		> 블록 스코프를 가진다(Block Scope)
		/*
		int a = 10;	//영역(m12)
		
		if(a > 0) {
			System.out.println(a);
			
			int b = a * 2;	//영역(if)
			
		}
//		b cannot be resolved to a variable
		System.out.println(b);
		*/
		/*
		int a = 10;
		int b;
		
		if(a > 0) {
			System.out.println(a);
			b = a * 2;
		}
		System.out.println(b);
		*/
//		컴파일러: 문법 검사만, 코드의 오류가 없는지만 검사, 실제 값 비교x
//			> 조건문이 실행되는지 아닌지 모르기 때문에 모든 경우를 따진다
//		런타임: 한줄씩 실행하여 검사
		
//		초기화
//		- 초깃값? > 업무를 살펴보고 판단
//					1. 필요한 값
//					2. 최대한 피해를 주지 않는 값
		int b = 0;
		double c = 0.0;
		char d = '\0';	//null 문자
		boolean e = false;
		String f = "";

		int a = 10;
		
		if(a > 0) {
			System.out.println(a);
			b = a * 2;
			if(b > 0) {
				int g;
			}
			if(b > 0) {
				int g;
			}
		}
		System.out.println(b);
		
		/*
		for(int i=0; i<10; i++) {
			System.out.println("반복");
		}
		i cannot be resolved to a variable
		System.out.println(i);
		*/
		
		int i = 0;
		for(; i<10; i++) {
			System.out.println("반복");
		}
		System.out.println(i);
	}

	private static void m11() {
		int sum = 0;
		for(int i=1; i<=3; i++) {
			sum += i;
			System.out.print(i + " + ");
		}
		System.out.println("\b\b= " + sum);
//		이클립스 콘솔: 1 + 2 + 3 + = 6
//		터미널 콘솔: 1 + 2 + 3 = 6

	}

	private static void m10() {
//		1 + 2 + 3 = 6
		int sum = 0;
		for(int i=1; i<=3; i++) {
			sum += i;
			System.out.print(i);
			if(i != 3) {
				System.out.print(" + ");
			} else {
				System.out.print(" = ");
			}
		}
		System.out.println(sum);
	}

	private static void m9() {
//		분기문 > 단독으로 사용 불가. 조건문 or 반복문과 같이 사용
//		- break > 자신이 포함된 제어문을 탈출
//		- continue
		
		for(int i=1; i<=10; i++) {
			break;
//			Unreachable code
//			System.out.println(i);
		}
		
//		for(int i=1; i<=10; i++) {
//			if(i == 5) {
//				break;
//			}
//			System.out.println(i);
//		}
		
		for(int i=1; i<=10; i++) {
			continue;
//			Unreachable code
//			System.out.println(i);
		}
		
//		for(int i=1; i<=10; i++) {
//			if(i == 5) {
//				continue;
//			}
//			System.out.println(i);
//		}
		
//		사용자 숫자 입력 > 홀수의 합?
//		- 숫자를 몇개 입력? > 사용자 맘대로~ > 회전수? > 무한 루프
//		- 0을 입력하면 프로그램 종료
		
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		
		for(;;) {
			System.out.print("숫자 입력 :");
			int num = scan.nextInt();
			if(num == 0) {
				break;
			}
			if(num % 2 == 1){
				sum += num;
			} else {
				System.out.println("짝수를 입력 > 프로그램 종료");
				break;
			}
		}
		System.out.println(sum);
	}
	
	private static void m8() {
//		무한 루프, Infinite Loop
		
//		언더플로우가 발생하기 때문에 실질적으로 무한 루프는 아니나 21억회 이상 반복된다
//		for(int i=0; i<10; i--) {
//			System.out.println(i);
//		}
		
//		무한루프 직접 생성하기
//		for(int i=0; ; i++) {
//			System.out.println(i);
//		}
		
		for(;;) {
			System.out.println("실행문");
		}
	}

	private static void m7() {
//		구구단 출력
		/*
		 * 5 x 1 = 5
		 * 5 x 2 = 10
		 * ...
		 * 5 x 9 = 45
		 */
		int dan = 5;
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		
		dan = scan.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
	}

	private static void m6() {
//		요구사항] 사용자가 입력한 숫자들의 합 > 10개 입력
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자 입력: ");
			sum += scan.nextInt();
		}
		
		System.out.println(sum);
	}

	private static void m5() {
//		요구사항] 1~사용자가 입력한 숫자까지의 합
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력: ");
		int num = scan.nextInt();
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.printf("1 ~ %d = %d\n", num, sum);
	}

	private static void m4() {
//		요구사항] 1~10까지의 합 > 누적 연산
		
//		*** 누적값 구하기
		
//		sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
		
//		1. 누적 변수
		int sum = 0;
		
//		2. 원하는 수열 만들기
		for(int i=1; i<=10; i++) {
			sum += i;
//			i(1) : 1 = 0 + 1
//			i(2) : 3 = (0 + 1) + 2
//			i(3) : 6 = (0 + 1 + 2) + 3
//			i(4) : 10 = (0 + 1 + 2 + 3) + 4
//			..
//			i(10) : 55 = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) + 10
		}
		
		System.out.println(sum);
	}

	private static void m3() {
//		반복문 목적!!
//		1. 회전수 제어
//		2. 루프 변수(반복 제어 변수) 제어(🌟🌟🌟🌟🌟)
		
//		*** 업무 구현 > 특정한 숫자의 패턴 사용 > 반복문의 루프 변수 활용
		
//		요구사항] 숫자 1~10까지 출력
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);
		System.out.println(10);
		
		int num = 1;
		
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		
		num = 1;
		
		for(int i=0; i<10; i++) {
			System.out.println(num++);
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(i + 1);
		}
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		for(int i=1; i<=10; i+=2) {
			System.out.println(i);
		}
		
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);
		}
		
//		1~100사이의 7의 배수 출력
		for(int i=7; i<=100; i+=7) {
			System.out.println(i);
		}
	}

	private static void m2() {
//		반복문 목적!!
//		1. 회전수 제어
//		2. 루프 변수(반복 제어 변수) 제어
		
		for(int i=0; i<5; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for(int i=1; i<=5; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for(int i=123; i<128; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for(int i=5; i>0; i--) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for(int i=1; i<=41; i += 10) {
			System.out.println("실행문");
		}
		System.out.println();
		
//		가장 보편적인 방법
//		- 루프 변수 > 0부터
		for(int i=0; i<5; i++) {
			System.out.println("실행문");
		}
		System.out.println();
	}

	private static void m1() {
//		요구사항] "안녕하세요." x 5 출력
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		
		hello();
		hello();
		hello();
		hello();
		hello();
		
//		순서
//		1. int i=0; > 초기식
//		2. i<5; > 조건식
//		3. 구현부 실행
//		4. i++; > 증감식
//		5. i<5; > 조건식
//		6. 구현부 실행
//		7. i++ > 증감식
		
		for(int i=0; i<5; i++) {
			System.out.println("Hello~");
		}
	}

	private static void hello() {
		System.out.println("반갑습니다.");
	}
}
