package com.test.java.obj;

import java.util.Scanner;

public class Ex49_Exception {
	public static void main(String[] args) {
		/*
		 * 예외, Exception
		 * - 런타임 오류
		 * - 컴파일 발견(X) > 실행 중 발견(O)
		 * - 개발자 미리 예측 > 사전 조치
		 * 
		 * 예외 처리, Exception Handling
		 * 1. 제어문 사용
		 * 2. try catch문 사용
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
		try {
			m5();
 		} catch (Exception e) {
			System.out.println("예외 처리");
		}
	}

	private static void m5() throws Exception {
//		예외 미루기
//		예외를 직접 처리하는게 아니라 부른 곳에서 처리
		int n = 0;
		System.out.println(100 / n);
		
	}

	private static void m4() {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		try {
//			비즈니스 코드 영역
			System.out.println(100 / num);
			return;
		} catch(Exception e){
//			예외 처리 코드 영역
			System.out.println("예외 처리");
		} finally {
//			성공 or 실패 > 무조건 실행
//			자원 해제 코드(클리너 코드) 영역
//			try 에 return 문을 넣더라도 무조건 실행하므로 밑에 블록 밖 코드와 차이점이 있음
			System.out.println("finally");
		}
		
		System.out.println("종료");
	}

	private static void m3() {
		try {
			int num = 0;
			System.out.println(100 / num);	//throw new ArithmethicException() 예외에 해당하는 객체를 만들고 던짐
			
			int[] nums = { 10, 20, 30 };
			System.out.println(nums[5]);	//throw new ArrayIndexOutOfBoundsException()
			
			Scanner scan = null;
			scan.nextInt();	//throw NullPointerException()
//		다중 캐치절
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자");
		} catch (NullPointerException e) {
			System.out.println("널 참조");
//		예외 객체 중 최상위 객체
//		하위 예외 객체를 처리해주지 않는다면 업캐스팅이 일어나서 모든 오류를 잡아준다
//			> 예외를 순서대로 잡기 때문에 항상 맨 끝에 예외 처리
		} catch (Exception e) {
			System.out.println("예외 처리");
		}
	}

	private static void m2() {
		try {
			int num = 0;
			System.out.println(100 / num);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누려고 시도");
		}
		try {
			int[] nums = { 10, 20, 30 };
//			System.out.println(nums[정수]); 
//			> 컴파일 시 인덱스 자리에 정수가 들어갔는지만 체크하기 때문에 컴파일 시 오류가 발생하지 않음
			System.out.println(nums[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류");
		}
		try {
			Scanner scan = null;
			scan.nextInt();
//			빈 객체를 선언해서 메소드를 불러내도 컴파일 시 아무 문제를 걸러내지 못함
		} catch (NullPointerException e) {
			System.out.println("널 참조");
		}
	}

	private static void m1() {
//		요구사항] 숫자를 입력 > 업무처리
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
//		🌟🌟🌟 예외 처리
//		예외 조건
		if(num != 0) {
//			비즈니스 코드(업무 코드) > 원래 하려고 했던 일
			System.out.printf("100 / %d = %d\n", num, 100 / num);
		} else {
//			예외 처리 코드
			System.out.println("0을 입력하지 마시오.");
		}
		
//		🌟🌟 try catch문
//		- try문 > 자신의 영역에서 오류가 발생하는지 검사
//		- catch문 > 오류가 발생 > 처리하는 역할
		
		try {
//			비즈니스 코드(업무 코드) > 원래 하려고 했던 일
			System.out.println(111);
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			System.out.println(222);
		} catch (Exception e) {
//			예외 처리 코드
			System.out.println("0을 입력하지 마시오.");
		}
		
		System.out.println("종료");
	}
}
