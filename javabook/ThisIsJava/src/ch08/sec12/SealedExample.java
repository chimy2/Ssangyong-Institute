package ch08.sec12;

public class SealedExample {
	public static void main(String[] args) {
		ImplClass impl = new ImplClass();
		
		InterfaceA ia = impl;
		ia.methodA();
		
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodA();
		ib.methodB();
		
		System.out.println();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		/*
		methodA() 실행

		methodA() 실행
		methodB() 실행

		methodA() 실행
		methodB() 실행
		methodC() 실행
		*/
	}
}
