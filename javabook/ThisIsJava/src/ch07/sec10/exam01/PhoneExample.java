package ch07.sec10.exam01;

public class PhoneExample {
	public static void main(String[] args) {
//		Cannot instantiate the type Phone
//		추상클래스는 객체는 생성할 수 없다.
//		Phone phone = new Phone();
		
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
		/*
		폰 전원을 켭니다.
		인터넷 검색을 합니다.
		폰 전원을 끕니다.
		*/
	}
}
