package ch07.sec05.exam02;

public class SportsCar extends Car {

	@Override
	public void speedUp() {
		speed += 10;
	}
	
//	Car의 stop() 메소드는 final 메소드이기 때문에 오버라이딩 할 수 없다.
	@Override
	public void stop() {
		System.out.println("스포츠카를 멈춤");
		speed = 0;
	}
}
