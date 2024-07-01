package ch08.sec05;

public class RemoteControlExample {
	public static void main(String[] args) {
//		인터페이스 변수 선언
		RemoteControl rc;
		
//		Television 객체를 생성하고 인터페이스 변수에 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		
//		디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println();
		
//		Audio 객체를 생성하고 인터페이스 변수에  대입
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		
//		디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		/*
		TV를 켭니다.
		현재 TV 볼륨: 5
		무음 처리합니다.
		현재 TV 볼륨: 0
		무음 해제합니다.

		Audio를 켭니다.
		현재 Audio 볼륨: 5
		무음 처리합니다.
		현재 Audio 볼륨: 0
		무음 해제합니다.
		현재 Audio 볼륨: 5
		*/
	}
}
