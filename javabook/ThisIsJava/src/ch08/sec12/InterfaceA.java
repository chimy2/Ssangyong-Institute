package ch08.sec12;

public sealed interface InterfaceA permits InterfaceB {
//	Java 15부터 무분별한 자식 인터페이스 생성을 방지하기 위해 sealed 인터페이스 사용 가능
//	sealed 키워드 사용 시 permits 키워드 뒤에 상속 가능한 자식 인터페이스 지정
//	sealed 인터페이스를 상속하는 인터페이스는 non-sealed나 sealed 키워드를 사용해야 한다
	void methodA();
}
