package com.test.question.classproblem;

import java.util.Random;

public class Box {
	private Macaron[] list = new Macaron[10];

	public void cook() {
		int count = 10;
		Random random = new Random();
		
		for(int i=0; i<count; i++) {
			int randomSize = random.nextInt(11) + 5;
			int randomColorIdx = random.nextInt(Macaron.getColorsCount());
			int randomThick = random.nextInt(20) + 1;
			
			Macaron macaron = new Macaron(randomSize, Macaron.getColor(randomColorIdx), randomThick);
			list[i] = macaron;
		}
		
		System.out.println("마카롱을 " + count + "개 만들었습니다.");
		System.out.println();
	}

	public void check() {
		int pass = 0;
		int fail = 0;
		
		for(int i=0; i<list.length; i++) {
			int result = list[i].getCheck();
			
			if(result == Macaron.PASS) {
				pass++;
			} else if(result == Macaron.FAIL) {
				fail++;
			}
		}
		
		System.out.println("[박스 체크 결과]");
		System.out.printf("QC 합격 개수 : %d개\n", pass);
		System.out.printf("QC 불합격 개수 : %d개\n", fail);
		System.out.println();
	}

	public void list() {
		System.out.println("[마카롱 목록]");
		
		for(int i=0; i<list.length; i++) {
			System.out.printf("%d번 마카롱 : %s\n", i + 1, list[i].toString());
		}
		
		System.out.println();
	}
}
