package com.test.java.obj.inheritance;

public class Ex39_Overriding {
	public static void main(String[] args) {
		/*
		 * 🌟🌟🌟🌟🌟
		 * 메서드 오버로딩, Method Overloading
		 * - 메서드 이름 동일 X N 생성
		 * 
		 * 메서드 오버라이딩, Method Overriding
		 * - 메서드 재정의 > 상속받은 메서드를 수정하는 기술
		 * - 클래스 상속에서 발생
		 * 
		 */
		
		OverridingParent hong = new OverridingParent();
		
		hong.name = "홍길동";
		hong.hello();
		
		OverridingChild jhong = new OverridingChild();
		
		jhong.name = "홍철수";
		jhong.hello();
//		jhong.hi();
	}
}
//같은 패키지에서는 같은 이름의 클래스를 못 만든다
//업무 > 동네 사람
class OverridingParent {
	
	public String name;
	
	public void hello() {
		System.out.printf("안녕하세요. 좋은 아침입니다. 저는 %s입니다.\n", name);
	}
}

class OverridingChild extends OverridingParent {
	
//	public void hi() {
//		System.out.printf("하이~ 난 %s야!!\n", this.name);
//	}

//	부모가 가진 똑같은 이름의 메서드도 갖고 있음 
//		> 실제로는 재정의나 수정이 아님 
//		> 그러나 사용자 입장에서는 재정의 한 것처럼 보인다
//	일종의 덮어쓰기 > Override
	@Override
	public void hello() {
		System.out.printf("하이~ 난 %s야!!\n", this.name);
	}
}