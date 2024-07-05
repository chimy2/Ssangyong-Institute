package com.test.java.obj.inheritance;

public class Ex44_Interface {
	public static void main(String[] args) {
		/*
		 * 인터페이스, interface
		 * - 클래스의 일종
		 * 
		 */
		
//		Cannot instantiate the type KeyBoard
//		객체를 생성해서 메서드를 가져와도 사용하지 못하기 때문에 객체 생성 불가
//		KeyBoard k1 = new KeyBoard();
		
		/*
		A100 a = new A100();
		
		a.open();
		a.set("핸드폰");
		a.close();
		a.clean();
		
		B200 b = new B200();
		
		b.open();
		b.set("지갑");
		b.close();
		b.check();
		*/

		/*
//		- 인터페이스는 객체를 생성할 수 없다
//		- 인터페이스는 변수는 만들 수 있다.
//		Bag bag = new Bag();
		
		Bag a;	//인터페이스 참조 변수
		A100 b;	//클래스 참조 변수
		
		b = new A100();
		
//		Bag = A100
//		부모 = 자식
//		업캐스팅(100% 가능)
		a = b;
		*/
		
		Bag a = new A100();
		
		a.open();
		a.set("핸드폰");
		a.close();
//		a.clean();
		
		Bag b = new B200();
		
		b.open();
		b.set("지갑");
		b.close();
//		b.check();
//		실제 메모리상에 B200 객체는 check()가 있지만 Bag 타입이므로 접근 불가
//		객체가 바뀌더라도 똑같은 방법으로 사용 가능 > 유연한 대처 가능
	}
}


//가방 클래스 X 2종류
//- 가방으로서 가져야 할 행동 규칙 > 추상 클래스 or 인터페이스(🌟🌟🌟)

interface Bag {
	void open();
	void close();
	String get(String item);
	void set(String item);
}

class A100 implements Bag {
	public String color;
	public int price;
	
	@Override
	public void open() {
	}
	@Override
	public void close() {
	}
	@Override
	public String get(String item) {
		return item;
	}
	@Override
	public void set(String item) {
	}
	
	public void clean() {
//		자동 세척 기능
	}
}

class B200 implements Bag {
	public int price;
	public String size;
	@Override
	public void open() {
	}
	@Override
	public void close() {
	}
	@Override
	public String get(String item) {
		return item;
	}
	@Override
	public void set(String item) {
	}
	
	public void check() {
//		점검 기능
	}
}


//인터페이스 선언하기
interface KeyBoard {
	
//	인터페이스 멤버 선언하기
//	- 멤버 변수(X)
//	- 멤버 메서드
//		- 구현 메서드(X) > {}(body)를 가진 메서드 불가능
//		- 추상 메서드(O)
//	- 🌟🌟🌟 인터페이스는 추상 메서드(구현되지 않은 멤버)의 집합
//	- 🌟🌟🌟 인터페이스는 구현 멤버(일반 변수)를 가질 수 없다.
	
//	The blank final field a may not have been initialized
//	public int a; > 일반 변수
	
//	Abstract methods do not specify a body
//	> 이클립스가 추상메서드로 간주 
//	public void test() {
//		//구현부
//	}
//	public void test();
	
//	🌟🌟🌟🌟🌟 키보드가 가져야 할 행동 규범(규칙) 정의 > 추상 메서드
//	- 보여야 그 기능을 사용할 수 있기 때문에 무조건 public 이고 따라서 public 생략 가능
//	public void on();
//	public void off();
//	public void keydown();
//	public void keyup();
	void on();
	void off();
	void keydown();
	void keyup();
	
}

//제가 만든 F87 클래스는 Keyboard 인터페이스를 구현했습니다.(상속보단 구현이라고 표현)
class F87 implements KeyBoard {

	@Override
	public void on() {
		System.out.println("전원 On");
	}

	@Override
	public void off() {
		System.out.println("전원 Off");
	}

	@Override
	public void keydown() {
		System.out.println("키다운");
	}

	@Override
	public void keyup() {
		System.out.println("키업");
	}
	
}