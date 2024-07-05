package com.lesson.java;

import java.util.Scanner;

public class Ex20_If {
	
	public static void main(String[] args) {
		
		//Ex20_If.java
		/*
		
			제어문
			- 수많은 명령어의 집합 > 명령어이 실행되는 순서: 위 > 아래
			- 제어의 흐름을 통제하는 도구
			- 조건 제어, 반복 제어, 분기 제어
			
			1. 조건문
				- 개발자가 조건을 제시한 후 결과에 따라 흐름을 제어
				a. if
				b. switch
			
			2. 반복문
				- 특정 코드를 원하는 횟수만큼 반복 제어
				a. for
				b. while
				c. do while
				d. for
			
			3. 분기문
				- 코드의 흐름을 원하는 곳으로 이동
				a. break
				b. continue
				c. goto(JDK 1.5 폐기)
		
		*/

		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		
		
	}//main

	private static void m6() {
		
		if (true) {
			System.out.println("참");
		}
		
		
		boolean flag = true;
		
		flag = false;
		
		if (flag) {
			System.out.println("참");
		}
		
//		if (비교 연산자 or 논리 연산자) {
//			
//		}


		//C언어
		//- boolean 없음
		//- 숫자(0이 아닌 값) > true
		//      (0) > false
		//- 문자열("홍길동") > true
		//        ("") > false
		
//		int n = 0;
//		
//		if (n) {
//			
//		}
		
//		if (100) {
//			
//		}
//		
//		if ('A') {
//			
//		}
//		
//		if ("홍길동") {
//			
//		}
		
		
		int n = 10;
		
		if (n > 0) 
			System.out.println("양수");
		else 
			System.out.println("양수 아님");
		
		if (n > 0) {
			System.out.println("양수");
			System.out.println("합격");
		} else 
			System.out.println("양수 아님");
		
		if (n > 0) System.out.println("양수");
		else System.out.println("양수 아님");
		
		
		if (n > 0) {
			System.out.println("양수");
		} else {
			System.out.println("양수 아님");
		}
		
		
	}

	private static void m5() {
		
		//성적 처리
		//- 1과목 > 합격/불합격
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수: ");
		int score = scan.nextInt();
		
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		
		//0 ~ 100
		if (score >= 60 && score <= 100) {
			System.out.println("합격");
		} else if (score < 60 && score >= 0) {
			System.out.println("불합격");
		} else {
			System.out.println("점수는 0~100점 이내로 입력하세요.");
		}
		
		
		//중첩된 if문
		
		if (score >= 0 && score <= 100) {
			
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
			
		} else {
			System.out.println("점수는 0~100점 이내로 입력하세요.");
		}
		
		
	}

	private static void m4() {
		
		//설문 조사
		int score = 0; //누적 변수(누적 변수는 0으로 초기화한다.)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 어떤 개발툴을 선호합니까?");
		System.out.println("a. 메모장");		//+1
		System.out.println("b. 이클립스");		//+3
		System.out.println("c. 인텔리제이");	//+5
		
		System.out.print("선택: ");
		
		String input = scan.nextLine();
		
		if (input.equals("a")) {
			score = 1;
		} else if (input.equals("b")) {
			score = 3;
		} else if (input.equals("c")) {
			score = 5;
		}
		
		
		
		System.out.println("2. 어떤 프로그래밍 언어를 선호합니까?");
		System.out.println("a. C/C++");		//+1
		System.out.println("b. Java");		//+3
		System.out.println("c. Kotlin");	//+5
		
		System.out.print("선택: ");
		
		input = scan.nextLine();
		
		if (input.equals("a")) {
			score += 1;
		} else if (input.equals("b")) {
			score += 3;
		} else if (input.equals("c")) {
			score += 5;
		}
		
		
		
		
		System.out.println("3. 하루에 코딩을 몇시간이나 합니까?");
		System.out.println("a. 1시간 미만");			//+1
		System.out.println("b. 1시간 ~ 3시간 미만");	//+3
		System.out.println("c. 3시간 이상");			//+5
		
		System.out.print("선택: ");
		
		input = scan.nextLine();
		
		if (input.equals("a")) {
			score += 1;
		} else if (input.equals("b")) {
			score += 3;
		} else if (input.equals("c")) {
			score += 5;
		}
		
		System.out.println("설문이 완료되었습니다.");
		
		System.out.println("[결과]");
		
		if (score >= 10) {
			System.out.println("당신은 개발자 자질이 있습니다.");
		} else if (score >= 5) { // score >= 5 && score < 10
			System.out.println("개발자가 되기 위해 노력하세요.");
		} else {
			System.out.println("다른거 하세요~");
		}
		
	}

	private static void m3() {
		
		//기상? > 출근
		Scanner scan = new Scanner(System.in);
		
		System.out.print("기상 시간(시): ");
		int hour = scan.nextInt();
		
		if (hour < 6) {
			System.out.println("지하철을 타고 출근한다.");
		} else if (hour >= 6 && hour < 7) {
			System.out.println("버스를 타고 출근한다.");
		} else if (hour >= 7 && hour < 8) {
			System.out.println("택시를 타고 출근한다.");
		} else {
			System.out.println("병가를 낸다.");
		}
		
		
		
		if (hour < 6) {
			System.out.println("지하철을 타고 출근한다.");
		} else if (hour < 7) {
			System.out.println("버스를 타고 출근한다.");
		} else if (hour < 8) {
			System.out.println("택시를 타고 출근한다.");
		} else {
			System.out.println("병가를 낸다.");
		}
		
	}

	private static void m2() {
		
		//나이 입력 > 판단?
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.println(age >= 18 ? "성인" : "미성년자");
		
		if (age >= 18) {
			System.out.println("성인");
		} else {
			System.out.println("미성년자");
		}
		
	}

	private static void m1() {
		
		/*
		
			if 문
			- 개발자가 조건을 제시한 후 결과에 따라 흐름을 제어
			- 조건식 > boolean값을 가진다.
			
			if (조건식) {
				문장;
			}
			
			
			if (조건식) {
				문장;
			} else {
				문장;
			}
			
			
			다중 조건문
			
			if (조건식) {
				문장;
			} else if (조건식) {
				문장;
			}
			
			if (조건식) {
				문장;
			} else if (조건식) {
				문장;
			} else if (조건식) {
				문장;
			} else if (조건식) {
				문장;
			}
			
			
			if (조건식) {
				문장;
			} [else if (조건식) {
				문장;
			}] x N
			
			
			
			if (조건식) {
				문장;
			} [else if (조건식) {
				문장;
			}] x N
			[else {
				문장;
			}]
			

		*/
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = scan.nextInt();
		
		if (num > 0) {
			//조건을 만족했을 때 실행하는 블럭 > 참 블럭
			System.out.printf("입력한 %d는 양수입니다.\n", num);
		}
		
		if (num > 0) {
			//참 블럭
			System.out.printf("입력한 %d는 양수입니다.\n", num);
		} else {
			//거짓 블럭
			System.out.printf("입력한 %d는 양수가 아닙니다.\n", num);
		}
		
		
		if (num > 0) {
			System.out.printf("입력한 %d는 양수입니다.\n", num);
		} else if (num < 0) {
			System.out.printf("입력한 %d는 음수입니다.\n", num);
		} else {
			System.out.println("입력한 수는 0입니다.");
		}		
		
		System.out.println("프로그램 종료");		
		
	}

}












