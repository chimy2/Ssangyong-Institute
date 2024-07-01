package ch07.sec07.exam02;

public class ChildExample {
	public static void main(String[] args) {
//		자식 객체 생성
		Child child = new Child();
		
//		자동 타입 변환
		Parent parent = child;
		
//		메소드 호출
		parent.method1();
		parent.method2();
//		parent.method3();
//		호출 불가능
		/*
		Parent-method1()
		Child-method2()
		*/
//		부모 객체를 선언했기 때문에 자식 객체가 부모 타입으로 자동 타입 변환되어 
//		자식 메소드가 호출되지만 자식 객체에만 선언된 자식 메소드를 호출할 순 없다
//		다형성 때문에 부모 메소드 떄문에 오버라이딩된 자식 메소드가 호출된다
	}
}
