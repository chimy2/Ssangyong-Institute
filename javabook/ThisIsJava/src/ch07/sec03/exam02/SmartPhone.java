package ch07.sec03.exam02;

public class SmartPhone extends Phone {
//	자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(model, color);
//		부모 클래스에 기본 생성자가 없고 매개변수를 갖는 생성자만 있으므로
//		생략이 불가능하다 > 반드시 작성해야 함
		System.out.println("smartPhone(String model, String color) 생성자 실행됨");
	}
}
