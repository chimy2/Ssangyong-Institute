package com.test.java;

public class Ex04_Variable {
	public static void main(String[] args) {
//		모든 자료형 > 변수 생성하기
		
//		정수형
		byte b1;
		b1 = 10;	// 10 > 상수(데이터) 정수형 상수 > 정수형 리터럴
		System.out.println(b1);
		
		b1=127;
		System.out.println(b1);

		b1=-128;
		System.out.println(b1);

//		Type mismatch: cannot convert from int to byte
//		b1 = 128;
//		Type mismatch: cannot convert from double to byte
//		b1 = 3.14;
		
//		자료형	>	래퍼(Wrapper) 클래스 / 유틸 클래스 
//		byte	>	Byte
//		short	> 	Short
//		int 	> 	Integer
//		long	>	Long
//		float	>	Float
//		double	> 	Double
//		boolean	>	Boolean
//		char	> 	Character
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

//		short
		short s1;
		s1 = 10000;
		System.out.println(s1);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);

//		int
		int n1;
		n1 = 1000000000;
		System.out.println(n1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

//		long
		long l1;
		l1 = 1000;
		l1 = 1000000000;
		System.out.println(l1);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
//		Shift + 방향키 > 글자단위
//		Shift + Ctrl + 방향키 > 단어단위
//		Shift + Home(End)
//		Shift + Alt + 방향키(위, 아래)		
//		Alt + 방향키(위, 아래)

//		The literal 10000000000 of type int is out of range 
//		9223372036854775807
//		l1 = 10000000000;
		l1 = 10000000000L;
		l1 = 10000000000l;
//		정수 리터럴은 int형 자료형을 가지기 때문에 
//		int형 범위를 넘어가서 에러가 나고 
//		long형의 범위에 맞게 받아오도록 뒤에 L을 붙여준다
		
//		b1의 자료형?	byte
//		n1의 자료형?	int
//		지금 보이는 모든 100은 int이다
//		- 자바에서 모든 정수형 상수(리터럴)은 int형 자료형을 가진다
		
		b1 = 100;
		s1 = 100;
		n1 = 100;
		l1 = 100;
		System.out.println(100);
		
		float f1;
//		Type mismatch: cannot convert from double to float
//		f1=3.14;
		f1 = 3.14F;
		f1 = 3.14f;
		System.out.println(f1);

		double d1;
		d1 = 5.28;
		d1 = 5.28D;
		System.out.println(d1);
		
//		float > 단정도형
//		double > 배정도형
		f1 = 1000000000000000000000000000000000.0F;
		d1 = 1000000000000000000000000000000000.0D;
		
		System.out.println(f1);
		System.out.println(d1);

		
		f1 = 1234567890123456789012345678901234.0F;
		d1 = 1234567890123456789012345678901234.0D;
		
		System.out.println(f1);
		System.out.println(d1);
		
		double d2 = 0.2;
		double d3 = 0.1;
		System.out.println(d2 + d3);
//		0.30000000000000004
		
//		0.2 * 10 = 2
//		0.1 * 10 = 1
//		2 + 1 = 3
//		3 / 10 = 0.3
		
//		문자형
		char c1;
		// 문자 cannot be resolved to a variable
//		c1 = 문자;
		c1 = 'A';	//문자형 리터럴
		System.out.println(c1);

		c1 = '가';
		System.out.println(c1);
		
		c1 = '&';
		System.out.println(c1);
		
		c1 = '5';	// 문자형 5
		System.out.println(c1);
		
//		Invalid character constant
//		c1 = 'ABC';
		System.out.println(c1);
		
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
//		String > 문자열
		String name = "홍길동";	//"홍길동" > 문자열 리터럴
		
		System.out.println(name);
		
//		논리형
		boolean flag;

		flag = true;	//true > 논리형 리터럴
		System.out.println(flag);
		
		flag = false;
		System.out.println(flag);
		
//		각 자료형 별(9가지) > 변수 1개 생성 > 값을 대입 > 출력
//		x 10번씩
		
//		샘플
//		1. 데이터 선정
//		- 몸무게
		
//		2. 1의 데이터를 저장될 자료형 선택?
//		- 몸무게 데이터 > 형태 + 범위
//		- 1kg ~ 200kg > 실수 = float/double > float
		
//		3. 변수 생성 + 초기화(리터럴)
//		float 변수명;	//의미있는 변수명
		float weight;
		weight = 72.5f;
		
//		4. 마무리 > 출력(문장)
		System.out.println("제 몸무게는 " + weight + "kg 입니다.");
		
		byte candy = 32,
				milk = 1,
				water = 8;

		System.out.println("사탕이 " + candy + "개 남아있습니다");
		System.out.println("우유가 " + milk + "병 남아있습니다");
		System.out.println("물이 " + water + "병 남아있습니다");

//		short
		
		
		int priceBanana = 5740;
		int priceApple = 3380;
		int priceStrawberry = 25060;
		int priceRice = 44430;
		int priceEgg = 3950;
		int priceBeefSirloin = 11170;
		int priceBeefBrisket = 8770;
		int priceForkBelly= 3260;
		int priceForkPicnicShoulder= 1640;
		
		System.out.println("서울 바나나의 가격은 한 송이에 "+priceBanana+"원입니다.\n"
							+ "서울 사과의 가격은 개당 "+priceApple+"원입니다.\n"
							+ "서울 딸기의 가격은 1kg 당 "+priceStrawberry+"원입니다.\n"
							+ "서울 백미의 가격은 포 당 "+priceRice+"원입니다.\n"
							+ "서울 계란의 가격은 10개입 당 "+priceEgg+"원입니다.\n"
							+ "서울 한우 등심의 가격은 100g 당 "+priceBeefSirloin+"원입니다.\n"
							+ "서울 한우 양지의 가격은 100g 당 "+priceBeefBrisket+"원입니다.\n"
							+ "서울 돼지고기 삼겹살의 가격은 100g 당 "+priceForkBelly+"원입니다.\n"
							+ "서울 돼지고기 앞다리살의 가격은 100g 당"+priceForkPicnicShoulder+"원입니다.");
//		long
		
		float avgTemperature2019 = 13.5f,
				avgTemperature2020 = 13.2f,
				avgTemperature2021 = 13.7f,
				avgTemperature2022 = 13.2f;

		System.out.println("2019년 서울 평균 기온은 " + avgTemperature2019 + "도입니다.\n" 
							+ "2020년 서울 평균 기온은 " + avgTemperature2020 + "도입니다.\n" 
							+ "2021년 서울 평균 기온은 " + avgTemperature2021 + "도입니다.\n" 
							+ "2022년 서울 평균 기온은 " + avgTemperature2022+"도입니다.");

		double avgRevenue1 = 52134214324.35, 
				avgRevenue2 = 212354324.9, 
				avgRevenue3 = 8653324.45,
				avgRevenue4 = 523114324.6;
		
		System.out.println("1분기 평균 매출액은 " + avgRevenue1 + "입니다");
		System.out.println("2분기 평균 매출액은 " + avgRevenue2 + "입니다");
		System.out.println("3분기 평균 매출액은 " + avgRevenue3 + "입니다");
		System.out.println("4분기 평균 매출액은 " + avgRevenue4 + "입니다");

		char kor = 'A', math = 'B', eng = 'C';

		System.out.println("나의 국어 등급은 " + kor + "입니다");
		System.out.println("나의 수학 등급은 " + math + "입니다");
		System.out.println("나의 영어 등급은 " + eng + "입니다");

		boolean isRain240624 = false, isRain240625 = true, isRain240626 = false, isRain240627 = false,
				isRain240628 = false, isRain240629 = false, isRain240630 = false;

		System.out.println("24년 6월 24일에는 비가 옵니까? " + isRain240624);
		System.out.println("24년 6월 25일에는 비가 옵니까? " + isRain240625);
		System.out.println("24년 6월 26일에는 비가 옵니까? " + isRain240626);
		System.out.println("24년 6월 27일에는 비가 옵니까? " + isRain240627);
		System.out.println("24년 6월 28일에는 비가 옵니까? " + isRain240628);
		System.out.println("24년 6월 29일에는 비가 옵니까? " + isRain240629);
		System.out.println("24년 6월 30일에는 비가 옵니까? "+isRain240630);
		
		String rankMovie1 = "인사이드 아웃2",
				rankMovie2 = "핸섬가이즈",
				rankMovie3 = "퓨리오사: 매드맥스 사가",
				rankMovie4 = "원더랜드",
				rankMovie5 = "북극백화점의 안내원",
				rankMovie6 = "그녀가 죽었다",
				rankMovie7 = "프렌치 수프",
				rankMovie8 = "존 오브 인터레스트",
				rankMovie9 = "1초 앞, 1초 뒤",
				rankMovie10 = "범죄도시4";
		

		System.out.println("현재 영화 순위 1위는 "+rankMovie1+"입니다.\n"
							+ "현재 영화 순위 2위는 "+rankMovie2+"입니다.\n"
							+ "현재 영화 순위 3위는 "+rankMovie3+"입니다.\n"
							+ "현재 영화 순위 4위는 "+rankMovie4+"입니다.\n"
							+ "현재 영화 순위 5위는 "+rankMovie5+"입니다.\n"
							+ "현재 영화 순위 6위는 "+rankMovie6+"입니다.\n"
							+ "현재 영화 순위 7위는 "+rankMovie7+"입니다.\n"
							+ "현재 영화 순위 8위는 "+rankMovie8+"입니다.\n"
							+ "현재 영화 순위 9위는 "+rankMovie9+"입니다.\n"
							+ "현재 영화 순위 10위는 "+rankMovie10+"입니다.");
		
		
		
		
	}
}
