package ch08.sec12;

public class InstanceofExample {
	public static void main(String[] args) {
//		구현 객체 생성
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
//		ride() 메소드 호출 시 구현 객체를 매개값으로 전달
		ride(taxi);
		System.out.println();
		ride(bus);
	}
	
//	인터페이스 매개변수를 갖는 메소드
	public static void ride(Vehicle vehicle) {
//		방법1
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		
//		방법2
		/*
		 * Java 12부터 가능
		 * vehicle에 대입된 객체가 Bus일 경우에만 Bus로 강제 타입 변환을 시킴
		if(vehicle instanceof Bus bus) {
			bus.checkFare();
		}
		*/
		vehicle.run();
	}
}
