package com.test.java;

public class Ex03_Variable {
	public static void main(String[] args) {
		/*
		 * Ex03_Variable.java
		 * 
		 * 자료형 + 변수
		 * 
		 * 변수, Variable 
		 * - 데이터를 저장하는 공간 
		 * - 개발자가 명령어를 사용해서 메모리에 할당받은 공간 
		 * - 변할 수 있는 수
		 * 
		 * 1. 변수 선언하기(생성하기) 
		 * - 자료형 변수명;
		 * 
		 * 2. 변수 초기화 
		 * - 변수명 = 값;
		 * 
		 * 3. 변수 접근(호출)
		 */

//		국어 점수
		byte 국어;
		국어 = 90;
		System.out.println(국어);	//90

//		영어 점수
		byte eng;
		eng = 80;	//초기화
		System.out.println(eng);	//80
		
		eng = 70; //치환(덮어쓰기)
		System.out.println(eng);	//70
		
//		변수 <> 상수(=리터럴, Literal)
		System.out.println(100);	//100
		
//		변수명을 만들 때 규칙
//		1. 영문자 + 숫자 + _, $ 을 사용한다. > 관습적 + 물리적
//		2. 숫자로 시작 불가능
//		3. 예약어(키워드) 사용 불가능
//		4. 의미있게(⭐⭐⭐⭐⭐⭐⭐⭐🌟🌟🌟🌟🌟🌟🌟🌟)
		
		byte kor;
		byte kor1;
		byte kor_1;
//		byte kor%1; > error
//		byte 1kor;
		byte _1kor;
		
//		Duplicate local variable kor
//		byte kor;
//		System.out.println(kor);
		
		byte Kor;
		byte kOr;
		byte koR;
		byte KOr;
		byte kOR;
		byte KoR;
		byte KOR;
		
//		변수 생성하는 방법
		int n1;	//선언
		//다른 코드..
		n1 = 100; // 초기화

		int n2 = 200;	//선언 + 초기화
		
		int n3;
		int n4;

		int n5, n6;

		int n7 = 100, n8 = 200;

		int n9, n10 = 100, n11, n12, n13 = 200, n14 = 300;

//		지도 좌표(x, y)
		double x1;	//우리집 x좌표
		double y1;	//우리집 y좌표
		double x2, y2;	//친구집 x좌표, 친구집 y좌표
		double x3,	//마트 x좌표
				y3;	//마트 y좌표
		
		double x4, y4;

//		int f1;
//		int f1;
		
//		float f1;
//		double f1;
//		자료형이 다르더라도 변수명은 겹치면 안됨
		
//		
//		System.out.println(f1);
//		어떤 형의 변수를 불러오는지 모르기 때문에
		
		int num;	//선언 > null 상태
//		The local variable num may not have been initialized
//		System.out.println(num);
		
//		식별자(변수명 + 다른 요소의 이름 포함) 명명법
//		1. 헝가리언 표기법
//		2. 파스칼 표기법
//		3. 캐멀 표기법
//		4. 스네이크 표기법
//		5. 케밥 표기법
		
//		1. 헝가리언 표기법
//		- 식별자를 만들 때 식별자의 접두어로 자료형을 표시하는 방법
//		- 자바 진영에서는 잘 사용 안함
//		- 닷넷 진영에서는 잘 사용 함
//		사용) 인터페이스명
		
		int age;
		int intAge;
		int iAge;
		int iage;
		int i_age;
		
		
//		2. 파스칼 표기법
//		- 식별자의 첫문자를 대문자로 표기 + 나머지 문자를 소문자로 표기
//		- 2개 이상의 합성어 > 각 단어의 첫문자를 대문자로 표기
//		사용) 클래스명
		
		int weight;
		int Weight;
		
		int mathscore;
		int MathScore;
		
		
//		3. 캐멀 표기법
//		- 식별자의 첫문자를 소문자로 표기 + 나머지 문자를 소문자로 표기
//		- 2개 이상의 합성어 > 각 단어의 첫문자를 대문자로 표기
//		사용) 변수명, 메서드명
		
		int KoreanScore;	//파스칼 표기법
		int koreanScore;	//캐멀 표기법
		
		
//		4. 스네이크 표기법
//		- 전부 소문자 표기
//		- 2개 이상의 단어 > '_'로 연결
//		사용) 마음대로
		
		int myheight;
		int my_height;
		
		
//		5. 케밥 표기법
//		- 전부 소문자
//		- 2개 이상의 단어 > '-'로 연결
//		- 자바에서는 불가능한 표기법
//		int my-height; > -(마이너스)로 생각하기 때문에 에러
		
//		데이터 중 일부는 값을 변화시키면 안되는 값들
		double pi = 3.14;	//파이(원주율)

		System.out.println(3.14 * 10);	//31.400000000000002
		System.out.println(pi * 10);	//31.400000000000002

		pi = 5.5;
		System.out.println(pi * 10);	//55.0

//		상수 > 모든 문자를 대문자로 사용
		final double pi2 = 3.14;
//		The final local variable pi2 cannot be assigned. 
//		It must be blank and not using a compound assignment
//		pi2=5.5;
		
		final int HEIGHT = 180;
		
	}
}
