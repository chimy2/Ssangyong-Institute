package com.test.java.array;

import java.util.Scanner;

public class Ex27_String {
	public static void main(String[] args) {
//		문자열, String
//		- String 클래스에서 문자열 조작에 관련된 기능을 제공
		
//		키압 낮다 30~50g
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
		m8();
	}

	private static void m8() {
//		문자열 패턴 검색
//		- boolean startsWith(String word)
//		- boolean endsWith(String word)
		
		String name = "홍길동";
		
//		'홍'씨? > boolean
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf('홍') == 0);
		System.out.println(name.startsWith("홍"));
		
//		'동'으로 끝나? > boolean
		System.out.println(name.charAt(name.length() - 1) == '동');
		System.out.println(name.indexOf('동') == name.length() - 1);
		System.out.println(name.endsWith("동"));
		System.out.println();
		
//		자원 경로
		String path = "c:\\class\\code\\java\\Hello.java";
		
//		위의 자원이 자바 소스 파일인가? > 확장자 검사!
		
		System.out.println(path.endsWith(".java"));
	}

	private static void m7() {
//		문자열 대소문자 변경
//		- String toUpperCase()
//		- String toLowerCase()
		
		String txt = "오늘은 Java를 공부하는 시간입니다.";
		String word = "java";
		
//		System.out.println(txt.toUpperCase());
//		System.out.println(txt.toLowerCase());
		
//		대소문자 구분(Case sensitive)
//		- 정확도 높음
//		- 검색율 낮음
		if(txt.indexOf(word) > -1) {
			System.out.println("검색 결과 O");
		} else {
			System.out.println("검색 결과 X");
		}
		
//		메서드 체인
//		- 메서드().메서드().메서드()
//		- txt.toLowerCase().indexOf()
		
		
//		대소문자 구분X(Case insensitive)
		if(txt.toLowerCase().indexOf(word.toLowerCase()) > -1) {
			System.out.println("검색 결과 O");
		} else {
			System.out.println("검색 결과 X");
		}
		
	}

	private static void m6() {
//		게시판 글쓰기 > 금지어!!
		String stop = "바보";	//금지어
		String content = "안녕하세요. 저는 홍길동입니다.";
		
		if(content.indexOf(stop) >= 0) {
			System.out.println("금지어 금지!!");
		} else {
			System.out.println("글쓰기 처리~");
		}
		
		content = "안녕하세요. 저는 바보 홍길동입니다.";
		
		String[] stops = { "바보", "멍청이", "메롱", "ㅂㅏㅂㅗ" };
		
		for(int i=0; i<stops.length; i++) {
			if(content.indexOf(stops[i]) >= 0) {
				System.out.println("금지어!!");
				break;
			}
		}
		
		System.out.println("종료");
	}

	private static void m5() {
//		문자열 검색(🌟🌟🌟🌟🌟)
//		- 문자열내에서 원하는 문자(열)을 검색 > 발견된 위치(index) 반환
//		- int indexOf(char c)
//		- int indexOf(String s);
//		- int indexOf(char c, int beginIndex)
//		- int indexOf(String s, int beginIndex);
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.indexOf('홍'));		//7
		System.out.println(txt.indexOf("홍길동"));	//7
		
		System.out.println(txt.indexOf('김'));		//-1
		System.out.println();
		
		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 안녕히가세요. 홍길동입니다.";
		
		System.out.println(txt.indexOf("홍길동"));	//7
		System.out.println(txt.indexOf("홍길동", 10));	//22
		System.out.println(txt.indexOf("홍길동", 25));	//38
		
		int index = -1;
		index = txt.indexOf("홍길동");	//7
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + 3);	//22
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + 3);	//38
		index = txt.indexOf("홍길동", index + 3);	//38
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + 3);	//45
		System.out.println(index);
		
		
		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 안녕히가세요. 홍길동입니다.";
		
//		- int lastIndexOf(char c)
//		- int lastIndexOf(String s);
//		- int lastIndexOf(char c, int beginIndex)
//		- int lastIndexOf(String s, int beginIndex);
		
		System.out.println(txt.lastIndexOf("홍길동"));
		System.out.println(txt.lastIndexOf("홍길동", 37));
		System.out.println(txt.lastIndexOf("홍길동", 21));
	}

	private static void m4() {
//		문자열 공백 제거
//		- String trim();
//		- 문자열의 시작과 끝에 있는 공백 문자(Whitespace > space, tab, \r\n(개행문자))를 제거한다.
		
		String txt = "     하나     둘     셋     ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
		System.out.println("자바".equals("자바"));
		System.out.println(" 자바 ".equals("자바"));
	}

	private static void m3() {
//		주민등록번호 입력
//		ex) 950701-1234567
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("주민번호('-'필수):");
		String jumin = scan.nextLine();
		
		if(jumin.charAt(6) == '-') {
			System.out.println("올바른 주민번호");
		} else {
			System.out.println("잘못된 주민번호");
		}
	}

	private static void m2() {
//		문자열 추출
//		- char charAt(int index)
//		- 원하는 위치의 문자를 추출
//		- zero-based index
		
		String txt = "안녕하세요. 홍길동님.";
		
		char c = txt.charAt(txt.length() - 1);
		System.out.println(c);
	}

	private static void m1() {
//		문자열 생성하기
//		1. 리터럴
//		2. 객체생성
		
//		String str1 = "홍길동";
		String str2 = new String("홍길동");
//		참조형임에도 불구하고 값형처럼 쓰임
		
//		문자열 == 문자의 집합
//		String == char[]
		
//		문자열 길이
//		- int length()
//		- 문자의 개수
		String txt = "홍길동";
		System.out.println(txt.length());	//nums.length
		System.out.println("자바".length());
		System.out.println("한글ABC123!@#".length());
		
		
		Scanner scan = new Scanner(System.in);
		/*
//		요구사항] 사용자 입력 > 문자수?
		
		System.out.print("문장 입력: ");
		String statement = scan.nextLine();
		
		System.out.printf("%s > %d문자\n", statement, statement.length());
		*/

//		요구사항] 이름 입력
//		- 2자 ~ 5자 이내
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		if(name.length() >= 2 && name.length() <= 5) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("이름을 2자~5자 이내로 입력하세요.");
		}
	}
}
