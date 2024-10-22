package com.test.begin.di2;

public class Service {
	
//	의존 주입 도구
//	1. 생성자 > 최근에 주로 많이 쓰이는 추세 
//	2. Setter
	
	private Hong hong;
	
//	내가 필요한 객체를 내가 직접 만드는 게 아니라 남이 만들어서 전달받았다(주입 받았다) 해서 의존(성) 주입이라고 함
	public Service(Hong hong) {
		this.hong = hong;
	}
	
	public void setHong(Hong hong) {
		this.hong = hong;
	}

	public void work() {
//		기존 방식
//		Hong hong = new Hong();
//		hong.coding();
		
//		DI
		hong.coding();
	}

}
