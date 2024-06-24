package com.test.java;

import java.util.Scanner;

public class Ex11_Operator {

	public static void main(String[] args) {
		/*
		 * 비교 연산자
		 * - >, >=, <, <=, ==(equals), !=(not equals)
		 * - 2항 연산자
		 * - 피연산자들의 우위(동등) 비교
		 * - 피연산자는 숫자형이다.
		 * - 연산의 결과가 boolean이다.(true, false)
		 * 
		 */
		
		int a = 10;
		int b = 3;
		System.out.println(a > b);	//초과 true
		System.out.println(a >= b);	//이상 true
		System.out.println(a < b);	//미만 false
		System.out.println(a <= b);	//이하 false
		System.out.println(a == b);	//같다 false
		System.out.println(a != b);	//다르다 true
		
//		sysout, main > template
//		window > preference > java > template > new
//		새 단축키 만들기
		
//		흐름의 조건으로 사용
//		요구사항] 사용자로부터 나이를 입력 > 성인이면 통과! 미성년이면 거절!
		/*
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이 입력:");
		
		int age = scan.nextInt();
		boolean result = age >= 18;
		
		System.out.println(result);
		System.out.println(result ? "통과!" : "거절!");
		 * */
		
//		비교 연산자 주의
//		- 문자열(참조형) 비교
		
		int n1 = 100;
		int n2 = 100;
		int n3 = 50;
		n3 = n1 + n2;
		int n4 = 200;
		
		System.out.println(n1 == n2);	//true
		System.out.println(n1 == n3);	//false
		System.out.println(n3 == n4);	//true
		
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = "홍";
		s3 = s3 + "길동";
		
		System.out.println(s1 == s2);	//true
		System.out.println(s3);	//홍길동
		System.out.println(s1 == s3);	//false
//		↑ 틀린 비교들
		System.out.println(s1.equals(s2));	//true
		System.out.println(s1.equals(s3));	//true
//		↑ 올바른 비교들
		
//		*** 문자열을 비교할 때는 절대로 연산자(==, !=)를 사용하면 안된다.
//		*** 문자열 비교는 equals() 메서드를 사용
		
		/*
		 * 논리 연산자
		 * - &&(and), ||(or), !(not, 부정 연산자)
		 * - 2항 연산자($$, ||)
		 * - 1항 연산자(!)
		 * - 피연산자의 자료형은 boolean이다.
		 * - 연산의 결과는 boolean이다.
		 * - 정해진 규칙에 따른 결과를 반환
		 * 
		 * A && B = ?
		 * 논리곱(x)
		 * 
		 * T && T = T
		 * T && F = F
		 * F && T = F
		 * F && F = F
		 * 
		 * A || B = ?
		 * 논리합(+)
		 * 
		 * T || T = T
		 * T || F = T
		 * F || T = T
		 * F || F = F
		 * 
		 * 소개팅 > 남자 소개 
		 * 1. 키 180cm 이상
		 * 2. 잘생김
		 * 
		 * !A = ?
		 * 
		 * !T = F
		 * !F = T
		 * 
		 * 베타적 논리합(xor, exclusive or)
		 * 
		 * A ^ B = ? 
		 * 
		 * T ^ T = F
		 * T ^ F = T
		 * F ^ T = T
		 * F ^ F = F
		 * 
		 */
		
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println(b1 && b2);	//false
		System.out.println(b1 || b2);	//true
		System.out.println(!b1);		//false
		System.out.println(b1 ^ b2);	//true
		
//		나이 입력 > 18세 이상 + 60세 미만
//					18 <= age < 60
		/*
		Scanner scan = new Scanner(System.in);
		System.out.print("나이 입력:");
		int age = scan.nextInt();
//		The operator < is undefined for the argument type(s) boolean, int
//		두 연산을 한꺼번에 못하고 순서대로 하기 때문에 error
//		System.out.println(18 <= age < 60);
//		System.out.println(true < 60);
		System.out.println(age >= 18 ? age < 60 ? "청년" : "장년" : "청소년");
		System.out.println(18 <= age && age < 60);	
		*/
//		비교 연산자보다 논리 연산자의 우선순위가 높다 
		
		/*
		 * 대입(할당) 연산자
		 * - =
		 * - +=, -=, *=, /=, %= (복합 대입 연산자)
		 * - 2항 연산자
		 * - LValue(변수) = RValue(상수, 변수)
		 * - LValue와 RValue의 자료형이 반드시 동일해야 한다. > 형변환 사용
		 * 
		 * - 대입 연산자의 연산자 우선 순위가 가장 낮다.
		 * 
		 * 연산자 우선 순위
		 * - 산술 연산자 > 비교 연산자 > 논리 연산자 > 대입 연산자
		 * 
		 */
		
		int sum = 1 + 2 * 3;
		System.out.println(sum);	//7
		
		int m1 = 100;
		int m2;
		int m3;

		m2 = m1;
		m3 = m1;
		
//		연산자의 연산 방향
//		- 하나의 문장 > 동일한 우선 순위를 갖는 연산자가 여러개 > 어느 방향?
//		- 대부분은 좌측에서 우측이지만 대입연산자는 우측에서 좌측이다
		
		m3 = m2 = m1;
		
//		복합 대입 연산자
		int n = 10;
		
//		n에 1을 더하시오. > 누적
		n = n + 1;
		System.out.println(n);	//11

		n += 1;
		System.out.println(n);	//12
		
		n += 5;	//n = n + 5;
		System.out.println(n);	//17
		
		n = n - 2;
		System.out.println(n);	//15
		
		n -= 3;
		System.out.println(n);	//12
		
		n = n * 2;
		System.out.println(n);	//24
		
		n *= 3;
		System.out.println(n);	//72
		
		n = n / 3;
		System.out.println(n);	//24
		
		n /= 2;
		System.out.println(n);	//12
		
		n = n % 7;
		System.out.println(n);	//5
		
		n %= 3;
		System.out.println(n);	//2
		
		n = n + 10;
		n += 10;
		
		n = n -10;
		n -= 10;
		
		n = 10 + n;
		n += 10;
		
		n = 10 - n;
		n -= 10;	//조심;;;
				
		/*
		 * 증감 연산자
		 * - ++(증가), --(감소)
		 * - 1항 연산자
		 * - 피연산자는 숫자형이다.
		 * - 누적 연산
		 * - 기존의 값에 1을 더하거나 1을 뺀다.
		 * - 피연산자의 위치를 바꿀 수 있다.(🌟🌟🌟🌟🌟)
		 * 	- 연산자의 위치에 따라 연산자 우선 순위가 바뀐다.
		 * 		- ++n : 전위 연산자 > 연산자 우선 순위 최상
		 * 		- n++ : 후위 연산자 > 연산자 우선 순위 최하
		 */
		
		n = 10;
		
		n = n + 1;
		n += 1;
		++n;
		
		System.out.println(n);	//13
		
		n = n - 1;
		n -= 1;
		--n;
		
		System.out.println(n);	//10
		
		++n;
		n++;
		
		System.out.println(n);	//12
		
		--n;
		n--;
		
		System.out.println(n);	//10
		
		int result = 0;

		n = 10;
//		result = 10 + ++n;
		++n;
		result = 10 + n;
		System.out.printf("n=%d, result=%d\n", n, result); //21

		n = 10;
//		result = 10 + n++;
		n++;
		result = 10 +n;
		System.out.printf("n=%d, result=%d\n", n, result); //20
		
//		*** 하나의 문장에 증감 연산자와 다른 연산자를 동시에 사용하지 말것!! 
//			> 가독성 저하
		
		int o = 10;

		System.out.println(--o - o--);	//0
		
		/*
		 * 조건 연산자
		 * - ?: 
		 * - 3항 연산자
		 * - A ? B : C
		 * - A: boolean > 조건으로 사용
		 * - B, C: 상수, 변수 > 연산의 결과로 사용
		 * - A가 참이면 B반환, A가 거짓이면 C반환
		 * 
		 */
		
		System.out.println(1 + 2);	//3
		System.out.println(true ? 10 : 20);	//10
		System.out.println(false ? 10 : 20);	//20
		
		int age = 20;
		System.out.println(age >= 18);	//true
		System.out.println(age >= 18 ? "성인" : "미성년자");	//성인

		age = 10;	
		System.out.println(age >= 18 ? "성인" : "미성년자");	//미성년자
		
//		18세 이상 ~ 60 미만
		System.out.println(age >= 18 && age < 60);	//false
		System.out.println(age >= 18 && age < 60 ? "통과" : "거절");	//거절
		
//		age = 10;
//		System.out.println(age >= 18 ? "성인" : 100);
//		절대로 리턴값의 자료형이 다르게 반환되지 않도록 한다
//		자료형은 항상 같도록 맞춰주기 🌟🌟🌟🌟🌟
		
//		제어문 > 조건문 > if문
		
//		비트 연산자
//		- bit갑을 대상으로 연산
//		- &(and), |(or)
		a = 10;
		b = 5;
		
		System.out.println(a & b);	//0
		System.out.println(a | b);	//15
		
//		부호 연산자
		System.out.println(+10);
		System.out.println(-10);
		
//		정수 / 정수
//		나누는 수를 0이 될 수 없음
//		java.lang.ArithmeticException: / by zero
//		System.out.println(5 / 0);
		
//		실수 / 실수
		System.out.println(5 / 0.0);	//Infinity
		System.out.println(5 % 0.0);	//NaN > Not a Number
		
//		Shift 연산자(비트 이동 연산자)
//		- <<, >>
		
		
	}
}
