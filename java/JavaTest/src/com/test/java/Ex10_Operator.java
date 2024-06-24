package com.test.java;

public class Ex10_Operator {
	public static void main(String[] args) {
		/*
		 * 연산자, Operator
		 * - 수학 연산자 > 프로그래밍 연산자
		 * - 피연산자를 대상으로 미리 정해진 연산(행동)을 한 후에,
		 * 연산(행동)의 결과를 반환하는 요소
		 * - 주로 기호를 사용 + 단어도 사용
		 * 
		 * 1. 문장,Statement
		 * 2. 표현식, Expression
		 * 3. 연산자, Operator
		 * 4. 피연산자, Operand
		 * 5. 연산자 우선 순위
		 * 6. 연산자 연산 방향
		 * 
		 * 1. 문장,Statement
		 * - 1개 이상의 표현식이 모여서 문장이 된다.
		 * ex) int n1 = 10;
		 * ex) int n2 = 10 + 20;
		 * ex) int n3 = scan.nextInt();
		 * 
		 * 2. 표현식, Expression
		 * - 문장을 구성하는 최소 단위
		 * ex) int n1 = 10; -> 10, int n1, n1 = 10
		 * 
		 * 3. 연산자, Operator
		 * ex) int n2 = 10 + 20; -> =, +
		 * 
		 * 4. 피연산자, Operand
		 * ex) int n2 = 10 + 20; -> 10, 20, 10 + 20, n2
		 * 
		 * 5. 연산자 우선 순위
		 * - 하나의 문장에 속해있는 연산자들 중 누구를 먼저 실행할지 정해져 있는 순위
		 * - 1 + 2 x 3 = ?
		 * 
		 * 6. 연산자 연산 방향
		 * - 하나의 문장에 속해있는연산자들 중 우선 순위가 동일한 연산자들 중 
		 * 누구를 먼저 실행할지 정해져 있는 순위
		 * - 1 + 2 + 3
		 * 
		 * 연산자 종류
		 * 1. 행동(목적)
		 * 	a. 산술 연산자
		 * 	b. 비교 연산자
		 * 	c. 논리 연산자
		 * 	d. 대입 연산자
		 * 	e. 증감 연산자
		 * 	f. 조건 연산자
		 * 	g. 비트 연산자
		 * 
		 * 2. 형태(생김새, 피연산자의 개수)
		 * 	a. 1항 연산자
		 * 	b. 2항 연산자
		 * 	c. 3항 연산자
		 * 
		 */
		
//		산술 연산자
//		- +, -, *, /, %(mod, 나머지)
//		- 2항 연산자
//		- 피연산자는 숫자형을 가진다.(정수, 실수)
		
		int a = 10;
		int b = 3;
		
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %d\n", a, b, a / b);	//몫
//		Exception in thread "main" java.util.IllegalFormatFlagsException: Flags = ' '
//		System.out.printf("%d % %d = %d\n", a, b, a % b);
		System.out.printf("%d %% %d = %d\n", a, b, a % b);	//나머지
		
		double c = 10;
		double d = 3;
		System.out.printf("%.0f / %.0f = %f\n", c, d, c/d);

//		*** 모든 산술 연산자의 결과값 자료형
//		- 두 피연산자의 자료형 중에서 더 크기가 큰 자료형으로 반환된다. 
//			> 데이터 손실을 최소화하기 위해서
		
//		- 정수 / 정수 = 정수
//		- 실수 / 실수 = 실수
//		- 정수 / 실수 = 실수
//		- 실수 / 정수 = 실수
		
		System.out.println(10 / 3);
		System.out.println(10.0 / 3.0);
		System.out.println(10 / 3.0);
		System.out.println(10.0 / 3);
		
		int e = 10;
		byte f = 10;
		
		System.out.println(e + f);	//20
		
		e = 10000;
		System.out.println(e + f);	//10010
		
		int g = 100;
		int h = 100;
		
		System.out.println(g + h);	//200
		
		
//		- +, -, * > 오버플로우 조심~
		
		g = 2_000_000_000;
		h = 2_000_000_000;
		
		System.out.println(g + h);	//-294967296
		System.out.println(g + (long)h);	//4000000000
		
//		정수값 > int a;
//		실수값 > double b;
		
		byte j = 10;
		byte k = 20;
		
		System.out.println(j + k);
		
//		int 미만의 모든 자료형의 산술 연산 결과는 항상 int이다.
//		- CPU가 한번에 처리하는 데이터의 크기 > int
//		- byte + byte = int 
//		- short + short = int
//		- byte + short = int / short + byte = int
		
//		Type mismatch: cannot convert from int to byte
//		byte l = j + k;
		byte l = (byte)(j + k);

//		연산 시에는 기본적으로 받아오는 데이터 타입과 다르기 때문에 재연산이 필요하다
//		코드의 생산성을 높이기 위해서 메모리 공간을 버리고 
//		정수 리터럴과 실수 리터럴을 기본적으로 받아오는 int, double 타입을 주로 사용한다
		
//		float > double 도 마찬가지로 범위가 같은 자료형의 연산이 아니라면 
//		범위가 큰 double로 변환되어 연산한다.
		
//		주로 쓰는 자료형
//		- int, long
//		- double
//		- char
//		- boolean
		
	}
}
