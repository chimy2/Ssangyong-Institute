package com.test.java;

public class Ex67_RegEx {
	public static void main(String[] args) {
		/*
		 * 정규 표현식, Regular Expression
		 * - 정규식
		 * - "특정 패턴"을 가지는 문자열을 검색하는 도구
		 * 
		 * 정규 표현식 요소(문법)
		 * 
		 * 1. x
		 * 	- x는 임의의 문자 1개
		 * 	ex) a > a
		 * 	ex) abc > abc
		 * 	ex) 홍길동 > 홍길동
		 * 
		 * 2. .
		 * 	- 임의의 문자 1개(wildcard)
		 * 	ex) . > 문자 1개
		 * 	ex) .. > 문자 2개
		 * 	ex) a.c > abc, aac, acc, adc, aec, a1c, a홍c..
		 * 	ex) a..c > abbc, a12c, a가나c
		 * 
		 * 3. 출현횟수
		 * 	- 바로 앞의 문자(집합)의 출현 횟수를 표현
		 * 		3.1 생략
		 * 			- 바로 앞의 대상의 출현 횟수가 생략X, 중복X
		 * 			- 출현 횟수: 1
		 * 				ex) abc > abc
		 * 				ex) 홍길동 > 홍길동
		 * 
		 * 		3.2 ?
		 * 			- 바로 앞의 대상의 출현 횟수가 생략O, 중복X
		 * 			- 출현 횟수: 0 ~ 1
		 * 				ex) a?bc > abc, bc
		 * 				ex) 홍?길동 > 안녕~ 길동아~ 네 이름은 홍길동이지? 
		 * 				ex) 홍길?동 > 홍길동, 홍동
		 * 				ex) 홍길동? > 홍길동, 홍길
		 * 				ex) (자바)?코드 > 자바코드가 있습니다. 그런데 코드에 에러가 있어요.
		 * 				ex) a?a?abc > abc, aabc, aaabc
		 * 
		 * 		3.3 +
		 * 			- 바로 앞의 대생의 출현 횟수가 생략X, 중복O
		 * 			- 출현 횟수: 1 ~ 무한대
		 * 				ex) a+bc > abc, aabc, aaaaaaaaaabc, ..
		 * 				ex) 홍+길동 > 홍길동, 홍홍길동, ..
		 * 				ex) (자바)+코드 > 자바코드, 자바자바코드, ..
		 * 
		 * 		3.4 *
		 * 			- 바로 앞의 대생의 출현 횟수가 생략O, 중복O
		 * 			- 출현 횟수: 0 ~ 무한대
		 * 				ex) a*bc > bc, abc, aaaaaaaaaabc, ..
		 * 				ex) 홍*길동 > 길동, 홍길동, 홍홍길동, ..
		 * 				ex) (자바)+코드 > 코드, 자바코드, 자바자바코드, ..
		 * 
		 */
	}
}
