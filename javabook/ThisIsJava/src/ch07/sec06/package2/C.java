package ch07.sec06.package2;

import ch07.sec06.package1.A;

//다른 패키지
public class C {
//	메소드 선언
	public void method() {
		A a = new A();		//x
		a.field = "value";	//x
		a.method();			//x
	}
}
