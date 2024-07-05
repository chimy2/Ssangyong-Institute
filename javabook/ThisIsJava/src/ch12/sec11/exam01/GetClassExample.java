package ch12.sec11.exam01;

public class GetClassExample {
	public static void main(String[] args) throws Exception {
//		how1
		Class clazz1 = Car.class;
		
//		how2
		Class clazz2 = Class.forName("ch12.sec11.exam01.Car");
		
//		how3
		Car car = new Car();
		Class clazz3 = car.getClass();
		
		System.out.println("패키지: " + clazz1.getPackage().getName());
		System.out.println("패키지: " + clazz2.getPackage().getName());
		System.out.println("패키지: " + clazz3.getPackage().getName());
		
		System.out.println("클래스 간단 이름: " + clazz1.getSimpleName());
		System.out.println("클래스 간단 이름: " + clazz2.getSimpleName());
		System.out.println("클래스 간단 이름: " + clazz3.getSimpleName());
		
		System.out.println("클래스 전체 이름: " + clazz1.getName());
		System.out.println("클래스 전체 이름: " + clazz2.getName());
		System.out.println("클래스 전체 이름: " + clazz3.getName());
		/*
		패키지: ch12.sec11.exam01
		패키지: ch12.sec11.exam01
		패키지: ch12.sec11.exam01
		클래스 간단 이름: Car
		클래스 간단 이름: Car
		클래스 간단 이름: Car
		클래스 전체 이름: ch12.sec11.exam01.Car
		클래스 전체 이름: ch12.sec11.exam01.Car
		클래스 전체 이름: ch12.sec11.exam01.Car
		*/
	}
}
