package com.test.java;

public class Ex09_Casting {
	public static void main(String[] args) {
		/*
		 * 형변환, 자료형변환
		 * - Casting, Promotion
		 * - 하나의 자료형을 다른 자료형으로 변환하는 작업
		 * - 코드 작성을 유연하게 하기 위해서(개발자 편의성?)
		 * - int > double
		 * - long > float
		 * - byte > short
		 * 
		 * 1. 암시적(묵시적) 형변환. 자동 형변환, Promotion
		 * - 큰형 = 작은형
		 * - 100% 안전
		 * 
		 * 2. 명시적 형변환. 강제 형변환, Casting
		 * - 작은형 = 큰형
		 * - 경우에 따라 안전할 수도 위험할 수도 있다
		 * 		- 오버플로우 발생 가능~!
		 */
		
		byte b1;	//1byte
		short s1;	//2byte
		
		b1 = 10; // 원본
		
//		LValue 	= RValue
//		공간		= 값
//		🌟🌟🌟절대 규칙 > 
//			- LValue와 RValue의 자료형은 반드시 동일해야 한다. 
//			- 만약 동일하지 않으면 무조건 컴파일 오류
		
//		short = byte
		s1 = b1;
		
//		(자료형) : 형변환 연산자
//		s1 = (short)b1; 컴파일 시 이렇게 바뀜
		
//		검증
		System.out.println(s1);
//		10
		
		byte b2;
		short s2;
		
		s2 = 200;

//		Type mismatch: cannot convert from short to byte
//		b2 = s2;
		b2 = (byte)s2;

		System.out.println(b2);
//		-56
		
		
		int money = 2100000000;
		short money2;
		
//		오버 플로우(Overflow)
//		언더 플로우(Underflow)
		money2 = (short)money;
		
		System.out.println("계좌 이체 결과 잔액: " + money2);
//		계좌 이체 결과 잔액: 29952
		

//		(값형끼리의) 형변환
//		-값형과 참조형간에는 형변환 불가능하다.
//		byte, short, int, long
//		float, double
//		char
//		boolean(x)
//		String(x) - 참조형
		
		float f1;	//4
		double d1;	//8
		
		f1 = 3.14F;
		
//		8 = 4
		d1 = f1;
		System.out.println(d1);
//		3.140000104904175
		
		d1 = 3.14;
		
//		4 = 8
		f1 = (float)d1;
		System.out.println(f1);
//		3.14
		
		d1 = 3.123456789012345689;

		f1 = (float) d1;
		System.out.println(d1);	//원본
		System.out.println(f1);	//복사본
//		3.1234567890123457
//		3.1234567
		
//		정수 > 정수
//		실수 > 실수
//		정수 > 실수
//		실수 > 정수
		int n1 = 100;	//원본(4)
		float n2;		//복사본(4)
		
//		4 = 4
		n2 = n1;
		System.out.println(n2);
//		100.0
		
		n1 = Integer.MAX_VALUE;
		n2 = n1;
		
		System.out.println(n1);
		System.out.println(n2);
//		2147483647
//		2.14748365E9
		
		int n3;			//복사본
		float n4 = 100;	//원본
		
//		Type mismatch: cannot convert from float to int
//		n3 = n4;
//		같은 바이트, 숫자형 자료형임에도 불구하고 에러가 난다는 뜻은
//		암시적으로 형변환을 할 수 없고 명시적으로 해야한다는 것
//		같은 공간을 차지하더라도 float가 저장할 수 있는 숫자의 범위가 훨씬 크기 때문
//		실수형이 정수형의 값을 넘어갔을때 overflow가 발생하지 않는다
		n3 = (int)n4;
		System.out.println(n3);
//		100
		
//		숫자형 크기 비교
//		byte(1) < short(2) < int(4) < long(8) <<< float(4) < double(8) 
		
//		char 형변환
//		- 문자 코드값 <- (형변환) -> 숫자
//		- 일종의 정수형변환이다.
		
		System.out.println(65);			//65
		System.out.println((char)65);	//A
		System.out.println('a');		//a
		System.out.println((int)'a');	//97

		System.out.println("A");		//String
//		참조형과 값형간의 형변환 불가능
//		Cannot cast from String to int
//		System.out.println((int)"A");
		
		char c1;	//정수(2byte)
		short t1; 	//정수(2byte)
		
//		short는 양수와 음수 char는 양수 범위이기 때문에 
//		같은 공간을 차지하더라도 표현할 수 있는 숫자의 범위가 다르기 때문에
//		둘간의 형변환은 명시적으로만 가능
		c1 = 'A';
		t1 = (short)c1;
		System.out.println(t1);	//65
		
		char c2;
		short t2;
		
		t2 = 97;
		c2 = (char)t2;
		System.out.println(c2);	//a
		
//		*** 문자를 정수로 형변환할 떄는 반드시 int로 변환한다(short 사용금지)
		c1 = '가';
		t1 = (short)c1;
		System.out.println(t1);	//-21504
//		short는 한글을 커버하기에 너무 작은 범위라서 short로 형변환하기에는 무리다
		
		
//		"100" -> 100
		String txt = "100";
		int result;
		
//		참조형 = 값형(x)
//		Type mismatch: cannot convert from String to int
//		result = txt;
		result = Integer.parseInt(txt);
		System.out.println(result);	//100
		
		txt = "3.14";
		
		double result2 = Double.parseDouble(txt);
		System.out.println(result2);	//3.14
		
//		Wrapper별로 문자열을 자신의 자료형으로 바꿔주는 메서드가 존재한다.
//		- Byte.parseByte("100")
//		- Short.parseShort("100")
//		- Float.parseFloat("3.14")
		
	}
}
