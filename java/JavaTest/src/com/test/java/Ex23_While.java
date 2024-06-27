package com.test.java;

import java.util.Scanner;

public class Ex23_While {
	public static void main(String[] args) {
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
	}

	private static void m5() {
		/*
		 * K&R style(코딩스타일)
		 * while (조건) {
		 * 	문장;
		 * }
		 * 
		 * Allman style
		 * while (조건) 
		 * {
		 * 	문장;
		 * }
		 * 
		 * do {
		 * 	문장;
		 * } while(조건);
		 */
		
		int num = 11;
		
		while (num <= 10) {
			System.out.println(num++);
		}
		System.out.println();
		
		num = 11;
		do {
			System.out.println(num++);
		} while(num <= 10);
	}

	private static void m4() {
//		자판기
//		- (메뉴 출력 > 음료 선택 > 가격 출력) x 루프
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		String sel = "";
		int price = 0;
		
		while(loop) {
			System.out.println("===========");
			System.out.println("  자판기");
			System.out.println("===========");
			System.out.println("1. 콜라");
			System.out.println("2. 사이다");
			System.out.println("3. 박카스");
			System.out.println("4. 종료");
			System.out.println("-----------");
			
			System.out.print("선택: ");
			sel = scan.nextLine();
//			생성된 변수에서 계속 값을 변경해서 사용할 것
//			변수를 계속 생성하고 삭제하는 것은 비효율적이다
			
			if(sel.equals("1")) {
				price = 700;
			} else if(sel.equals("2")) {
				price = 600;
			} else if(sel.equals("3")) {
				price = 500;
			} else {
//				프로그램 종료? > 무한 루프 탈출
//				break;
				loop = false;
			}
			if(loop) {
				System.out.println(price + "원입니다.");
				System.out.println();
				System.out.println("계속하시려면 엔터를 입력하세요.");
				scan.nextLine();
			}
		}//while
		System.out.println("프로그램 종료");
	}//m4

	private static void m3() {
//		1~10 누적
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		int count = 1;
		while(count <= 10) {
			sum += count++;
		}
		System.out.println(sum);
	}

	private static void m2() {
		/*
		 * 반복문
		 * 1. for
		 * 2. while
		 * 3. do while
		 * 4. for
		 * 
		 * while (조건식) {
		 * 	문장;
		 * }
		 */
		
//		요구사항] 1~10 출력
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		int num = 1;	//초기식
		
		while(num <= 10) {	//조건식
			System.out.println(num++/* 증감식 */);
		}
		
	}

	private static void m1() {
		/*
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("이메일: ");
		String email = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(address);
		*/
		/*
		이름: 홍길동
		나이: 20
		이메일: 주소: 서울시 강남구
		홍길동
		20

		서울시 강남구
		*/
		/*
		 * nextLine 메소드를 제외하고 Scanner는 특정 자료형을 읽어올 때
		 * 키보드 입력을 받으면 입력버퍼에 올라간 다음 자바로 전달되는데 
		 * nextLine은 입력버퍼에 있는 문자열을 \r\n전까지 읽어오고
		 * 입력버퍼에 있는 \r\n을 지워주는데 
		 * 다른 메소드는 해당하는 자료형만 받아오고 \r\n을 지우지 않기 때문에
		 * 입력버퍼에 \r\n이 남아서 다음 입력사항에 문제가 생기기 때문에 
		 * 입력버퍼에 있는 \r\n을 지워줘야한다
		 * 남아있는 \r\n 지우기
		1)
		scan.skip("\r\n");
		2)
		빈문자열을 반환하는 것을 알기 때문에 일부러 \r\n을 지우기 위해 실행
		scan.nextLine();
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
//		scan.skip("\r\n");
		scan.nextLine();
		
		System.out.print("이메일: ");
		String email = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(address);
	}
}
