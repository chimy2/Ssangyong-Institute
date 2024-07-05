package com.test.java.obj.inheritance;

public class Ex45 {
	public static void main(String[] args) {
//		상황] 프린터 대리점 운영
//		1. LG100 모델 x 5대, HP200 모델 x 3대 > 재고 보유
//		2. 하루 1번씩 > 제품 점검 > 🌟🌟🌟 이부분이 point
		
//		추가 상황] 
//		1. 프린터 재고 증가
//			- LG100 > 500대
//			- HP200 > 300대
//		2. 프린터 종류 증가
//			- Dell300
//			- BenQ400
		
//		결론
//		- 보통 형제 클래스 > 부모 배열 > 한번에 관리(업캐스팅)
//		- 가끔씩, 자식 클래스 구현 기능 접근 > 다운 캐스팅 후, 고유 기능 접근(다운캐스팅)
		
//		m1();
	
//		m2();	//전용 배열 사용
		m3();	//공용 배열 사용
//		뭐가 좋은 지 비교해보고 정의해서 사용
		
//		m4();
	}

	private static void m4() {
//		- Printer
//			- LG100
//			- HP200
//			- Dell300
//			- BenQ400
		
		LG100 p1 = new LG100();
		HP200 p2 = new HP200();
		Printer p3 = new LG100();
		Printer p4 = new HP200();
		
		Printer[] list = new Printer[2];
		list[0] = new LG100();	//p3
		list[1] = new HP200();	//p4
	}

	private static void m3() {
//		Case 3.
//		- 배열 사용 + 형변환
		
		Printer[] p = new Printer[1600];
		
		for(int i=0; i<p.length; i++) {
			if(i < 500) {
				p[i] = new LG100();
			} else if(i < 800) {
				p[i] = new HP200();
			} else if(i < 1300) {
				p[i] = new Dell300();
			} else {
				p[i] = new BenQ400();
			}
		}
		
//		점검
		for(int i=0; i<p.length; i++) {
			p[i].print();
//			p[i].check();
//			p[i].call();
			
//			System.out.println(객체 instanceof 클래스);
//			System.out.println(p[i] instanceof LG100);
//			System.out.println(p[i] instanceof HP200);
			
//			다운 캐스팅 > 자식 클래스만의 고유 기능 접근
			if(p[i] instanceof LG100) {
				LG100 lg = (LG100) p[i];
				lg.check();
			} else if(p[i] instanceof HP200) {
				HP200 hp = (HP200) p[i];
				hp.call();
			}
		}
	}

	private static void m2() {
//		Case 2.
//		- 배열 사용
		LG100[] lg = new LG100[500];
		HP200[] hp = new HP200[300];
		Dell300[] dell = new Dell300[500];
		
		for(int i=0; i<lg.length; i++) {
			lg[i] = new LG100();
		}
		
		for(int i=0; i<hp.length; i++) {
			hp[i] = new HP200();
		}
		
		for(int i=0; i<lg.length; i++) {
			lg[i].print();
			lg[i].check();
			
		}
		
		for(int i=0; i<hp.length; i++) {
			hp[i].print();
			hp[i].call();
		}
		
	}

	private static void m1() {
//		Case 1.
//		- 가장 비효율적인 방법
//		- 프린터 1대 > 비용 동일 발생
		LG100 lg1 = new LG100();
		LG100 lg2 = new LG100();
		LG100 lg3 = new LG100();
		LG100 lg4 = new LG100();
		LG100 lg5 = new LG100();
		
		HP200 hp1 = new HP200();
		HP200 hp2 = new HP200();
		HP200 hp3 = new HP200();
		
		lg1.print();
		lg2.print();
		lg3.print();
		lg4.print();
		lg5.print();
		
		hp1.print();
		hp2.print();
		hp3.print();
	}
}
//부모 역할 가능
//1. 클래스
//2. 추상 클래스
//3. 인터페이스

//구현부를 가질 수 있는 부모 > 멤버 변수, 구현된 멤버 메서드 소유
//1. 클래스
//2. 추상 클래스 > 강제력을 가지는 추상 메서드를 가질 수 있음

abstract class Printer {
	private String model;
	private int price;
	
	abstract void print();
}

class LG100 extends Printer {
//	private String model;
//	private int price;
	private String color;
	
	public void print() {
		System.out.println("LG 기술 사용 > 출력");
	}
	
	public void check() {
		System.out.println("자가 점검");
	}
}

class HP200 extends Printer  {
//	private String model;
//	private int price;
	private String type;
	
	public void print() {
		System.out.println("HP 기술 사용 > 출력");
	}
	
	public void call() {
		System.out.println("상담원 연결");
	}
}

class Dell300 extends Printer  {

	public void print() {
		System.out.println("Dell 기술 사용 > 출력");
	}
}

class BenQ400 extends Printer  {
	public void print() {
		System.out.println("BenQ 기술 사용 > 출력");
	}
}