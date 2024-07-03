package ch09.sec04.exam03;

public class A {
//	메소드
	public void method1( int arg) {	//final int arg
//		로컬 변수
		 int var = 1; 	//final int var = 1;
		
//		로컬 클래스
		class B {
//			로컬 변수(생성자, 메소드 의 매개변수, 내부에서 선언된 변수)를
//			로컬 클래스에서 사용할 때 로컬 변수는 final 특성을 갖게 되므로 
//			값을 읽을 수만 있고 수정할 수 없게 된다.
//			Java8 이후 명시적으로 final 키워드를 붙이지 않아도 되지만 
//			로컬 변수에 final 키워드를 추가해 final 변수임을 명확히 할 수도 있다.
//			Java 7 이전에는 final 키워드를 반드시 붙여야 했다.
//			메소드
			void method2() {
//				로컬 변수 읽기
				System.out.println("arg: " + arg);	//o
				System.out.println("var: " + var);	//o
				
//				로컬 변수 수정
//				arg = 2;	//x
//				var = 2;	//x
//				Local variable var defined 
//				in an enclosing scope must be final or effectively final
			}
		}
		
//		로컬 객체 생성
		B b = new B();
//		로컬 객체 메소드 호출
		b.method2();
		
//		로컬 변수 수정
//		arg = 3;
//		var = 3;
	}
}
