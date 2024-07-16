package com.test.java;

public class Ex69 {
	public static void main(String[] args) {
//		의존 관계 
		Child c1 = new Child();
		
		M305 m1 = new M305();
		M405 m2 = new M405();
	}
}

class Parent {
	private int a;
	public void aaa() {
		
	}
}

class Child extends Parent {
	private int b;
	public void bbb() {
		
	}
}

interface Mouse {
	void click();
	boolean dblclick();
}

abstract class AbstractMouse implements Mouse {
	private int a;
	public void aaa() {
		
	}
	public abstract void drag();
	public abstract void drop();
}

class M305 implements Mouse {
	@Override
	public void click() {
		// TODO Auto-generated method stub
	}
	@Override
	public boolean dblclick() {
		// TODO Auto-generated method stub
		return false;
	}
}

class M405 extends AbstractMouse {
	@Override
	public void drag() {
		// TODO Auto-generated method stub
	}
	@Override
	public void drop() {
		// TODO Auto-generated method stub
	}
	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean dblclick() {
		// TODO Auto-generated method stub
		return false;
	}
}

/*
	일반 클래스 + 추상 클래스 + 인터페이스 > 상속 관계
	
	- [자식]			[부모]
	- 일반 클래스 > 	일반 클래스 	: O
	- 일반 클래스 > 	인터페이스 	: O
	- 일반 클래스 > 	추상 클래스 	: O(오버라이드)
	- 일반 클래스 > 	인터페이스 	: O(오버라이드)
	- 인터페이스 > 	일반 클래스	: X(구현부 때문에 관계 성립 불가)
	- 추상 클래스 > 	일반 클래스 	: O(비권장)
	- 인터페이스 > 	인터페이스 	: O
	- 추상 클래스 > 	추상 클래스 	: O
	- 추상 클래스 > 	인터페이스 	: O
	- 인터페이스 > 	추상 클래스 	: X(구현부 때문에 관계 성립 불가)
	
	- 일반 클래스 > 일반 클래스 > 일반 클래스 > 추상 클래스 > 추상 클래스 > 인터페이스 > 인터페이스 > 인터페이스
*/

/*
class AAA {
	public int a;
	public void aaa() {}
}

//The type AAA cannot be a superinterface of BBB; a superinterface must be an interface
//interface BBB extends AAA {}

abstract class CCC extends AAA {}

interface DDD {
	void ddd();
}
//implements는 실제 상속받은 것을 구현할 때 쓰는 키워드
//인터페이스끼리는 상속받아도 구현할 수 없기 때문에 extends를 쓴다
interface EEE extends DDD {
	void eee();
}

abstract class FFF {
	private int a;
	public abstract void aaa();
}

abstract class GGG extends FFF {
//	인터페이스에서 상속받은 메서드를 재정의할 수도 있고 
//	추상메서드로 넘겨 줄 수도 있다
	private int b;
	public abstract void bbb();
}

interface HHH {
	void aaa();
}

abstract class III implements HHH {
	abstract void bbb();
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}

class JJJ extends III {
	@Override
	void bbb() {}
//	@Override
//	public void aaa() {}
//	@Override
//	void bbb() {}
}

abstract class KKK {
	public int a;
	public abstract void aaa();
}

interface LLL extends KKK {
	
	
}
*/