package ch07.sec06.package2;

import ch07.sec06.package1.A;

//다른 패키지
public class D extends A{
//	생성자 선언
	public D() {
//		A() 생성자 호출
		super();	//o
	}
	
//	메소드 선언
	public void method1() {
//		A 필드값 변경
		this.field = "value";	//o
//		A 메소드 호출
		this.method();	//o
//		protected 생성자, 필드, 메소드이기 때문에 상속을 통해서만 사용 가능
	}
	
//	메소드 선언
	public void method2() {
		A a = new A();		//x
		a.field = "value";	//x
		a.method();			//x
//		직접 객체를 생성해서 사용하는 것은 안된다.
	}
}
