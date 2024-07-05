package com.lesson.java;

public class Ex04_Variable {
	
	public static void main(String[] args) {
		
		//Ex04_Variable.java
		//모든 자료형 > 변수 생성하기
		
		//정수형
		byte b1;
		b1 = 10; //10 > 상수(데이터) > 정수형 상수 > 정수형 리터럴
		System.out.println(b1);
		
		b1 = 127; //Type mismatch: cannot convert from int to byte
		System.out.println(b1);
		
		b1 = -128;
		System.out.println(b1);
		
		//b1 = 3.14;
		
		//자료형	> 래퍼(Wrapper) 클래스 / 유틸 클래스
		//byte 		> Byte
		//short		> Short
		//int		> Integer
		//long		> Long
		//float		> Float
		//double	> Double
		//boolean	> Boolean
		//char 		> Character
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		
		//short
		short s1;
		s1 = 10000;
		System.out.println(s1);
		
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		
		//int
		int n1;
		n1 = 1000000000;
		System.out.println(n1);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//long
		long l1;
		l1 = 1000;
		
		//Shift + 방향키 > 글자단위
		//Shift + Ctrl + 방향키 > 단어단위
		//Shift + Home(End)

		//Ctrl + Alt + 방향키(위,아래)
		//Alt + 방향키(위, 아래)
		System.out.println(l1);
				
		//The literal 10000000000 of type int is out of range 
		l1 = 10000000000L;
		System.out.println(l1);
		
		//9223372036854775807
		System.out.println(Long.MAX_VALUE);
		
		
		//b1의 자료형?
		//n1의 자료형?
		//모든 100은 int 이다.
		//- 자바에서 모든 정수형 상수(리터럴)은 int 자료형을 가진다.
		b1 = 100;
		s1 = 100;
		n1 = 100;
		l1 = 100;
		
		System.out.println(100);
		
		
		
		
		int n;
		
		n = 100;
		
		System.out.println(n);
		
		
		
		//실수
		
		float f1;
		f1 = 3.14F;
		System.out.println(f1);
		
		double d1;
		d1 = 5.28D;
		System.out.println(d1);
		
		
		//float > 단정도형
		//double > 배정도형
		f1 = 100000000000000000000000000000000000000.0F;
		d1 = 100000000000000000000000000000000000000.0D;
		
		System.out.println(f1);
		System.out.println(d1);
		
		
		f1 = 123456789012345678901234567890123456789.0F;
		d1 = 123456789012345678901234567890123456789.0D;
		
		System.out.println(f1);
		System.out.println(d1);
		
		double d2 = 0.2;
		double d3 = 0.1;
		System.out.println(d2 + d3);
		
		//0.2 x 10 = 2
		//0.1 x 10 = 1
		//2 + 1 = 3
		//3 / 10 = 0.3
		
		
		
		//문자형
		char c1;
		c1 = 'A'; // 문자형 리터럴  cannot be resolved to a variable
		System.out.println(c1);
		
		c1 = '가';
		System.err.println(c1);
		
		c1 = '&';
		System.out.println(c1);
		
		c1 = '5';
		System.out.println(c1);
		
		//c1 = 'ABC';
		//System.out.println(c1);
		
		//c1 = '홍길동';
		
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
		
		//String > 문자열 
		String name = "홍길동"; //"홍길동" > 문자열 리터럴
		System.out.println(name);
		
		
		//논리형
		boolean flag;
		
		flag = true; //true > 논리형 리터럴
		System.out.println(flag);
		
		flag = false;
		System.out.println(flag);
		
		
		//각 자료형 별(9가지) > 변수 1개 생성 > 값을 대입 > 출력
		// x 10번씩
		
		//샘플
		//1. 데이터 선정
		//- 몸무게
		
		//2. 1의 데이터를 저장될 자료형 선택?
		//- 몸무게 데이터 > 형태 + 범위
		//- 1kg ~ 200kg > 실수 = float/double > float
		
		//3. 변수 생성 + 초기화(리터럴)
		float weight;
		weight = 72.5F;
		
		//4. 마무리 > 출력(문장)
		System.out.println("제 몸무게는 " + weight + "kg입니다.");
		
		
		
		
		//주민등록번호 입력 > 출력
		//ex) 950621
		int jumin = 950621;
		System.out.println("주민등록번호: " + jumin);
				
		jumin = 030731; //12761
		System.out.println("주민등록번호: " + jumin);
		
		//자바의 기수법
		//- 10진수
		//- 8진수
		//- 16진수
		//- 2진수
		System.out.println(10); 	//10진수
		System.out.println(010); 	//8진수
		System.out.println(0x10); 	//16진수
		System.out.println(0b10); 	//2진수
		
				
		//String 클래스 > 모든 클래스의 이름 > 파스칼
		String jumin2 = "030731";
		System.out.println(jumin2);
		
		
		
		//실수 리터럴
		double d4 = 12000000000000.0;
		double d5 = 1.2e+13;
		
		double d6 = 0.012;
		double d7 = 1.2e-2;
		
		System.out.println(d7);
		
		
		
		
	}

}









