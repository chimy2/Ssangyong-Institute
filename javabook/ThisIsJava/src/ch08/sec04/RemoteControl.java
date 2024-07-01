package ch08.sec04;

public interface RemoteControl {
//	상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
//	추상 메소드 > 리턴 타입, 메소드명, 매개변수만 기술, {}를 붙이지 않는 메소드
//	인터페이스는 구현 클래스가 재정의 해야하는 추상 메소드를 멤버로 가질 수 있다.
//	public abstract를 생략하더라도 컴파일 과정에서 자동으로 추가됨
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
