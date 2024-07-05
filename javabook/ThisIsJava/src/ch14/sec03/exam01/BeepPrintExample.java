package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
//			비프음을 발생
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		for(int i=0; i<5; i++) {
//			출력문
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
//		따로 쓰레드를 생성하지 않았기 떄문에 순서대로 실행됨
//		쓰레드를 생성해서 동시에 실행시키고 싶음
	}
}
