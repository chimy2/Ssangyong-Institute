package com.test.java.obj.inheritance;

public class Ex43_Abstract {
	public static void main(String[] args) {
		/*
		 * Abstract
		 * - 추상 클래스, Abstract Class
		 * - 추상 메서드, Abstract Method
		 * 
		 * 
		 */
		
//		홍길동
		G305 m1 = new G305();
		
		m1.color = "black";
		m1.weight = 100;
		m1.buttons = 7;
		
		m1.click();
		
		m1.charge();
		
		M410 m2 = new M410();
		
		m2.weight = 150;
		m2.buttons = 5;
		m2.size = "대형";
		
//		m2.mousedown();
		m2.click();
		m2.autoScroll();
		
//		Cannot instantiate the type Mouse
//		추상클래스는 인스턴스화 할 수 없다 > 객체 생성이 안됨
//		추상 클래스가 객체를 만들지 못하는 이유?
//			> 추상 메서드 때문에
//			> 메서드가 구현부를 가지지 못해서 
//			> 호출 했을 때 문제가 생겨서
//		Mouse m3 = new Mouse();
//		m3.click();
	}
}

//추상 클래스
//- 추상 메서드를 가질 수 있다.
//- 객체 생성을 할 수 없다.
//- 일반 클래스의 부모 역할을 한다.(상속) > 추상 메서드 > 행동 정의(규약)

//추상 클래스 선언하기
abstract class Mouse {
	public int weight;
	public int buttons;
	
//	추상 메서드 선언하기 > 구체화 되지 않은 메서드 > 규약(상속받는 class들은 반드시 재정의해야함
//	추상 클래스에서만 추상 메서드를 선언할 수 있다.
//	public void click() {
//		System.out.println("클릭~");
//	}
	public abstract void click();
}

//마우스 생산
class G305 extends Mouse {
	
	public String color;
//	public int weight;
//	public int buttons;
	
	public void click() {
		System.out.println("G305의 기술로 클릭합니다.");
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
	
}

class M410 extends Mouse {
	
//	public int weight;
//	public int buttons;
	public String size;
	
//	public void mousedown() {
//	public void click() {
//		System.out.println("click");
//	}
	
	public void autoScroll() {
		System.out.println("Auto Scroll");
	}

//	추상 메서드를 상속해서 구현하는 것을 표현하는 말
//	1. 추상 메서드를 구현한다.(없던 Body를 추가로 구현했기 때문에)
//	2. 오버라이드를 했다.
	@Override
	public void click() {
		System.out.println("M410 클릭!!");
	}
}