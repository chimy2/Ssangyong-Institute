package com.test.java.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Ex54_File {
	public static void main(String[] args) {
		/*
		 * 1. 파일/디렉토리 조작
		 * 	- 윈도우 탐색기로 하는 행동 > 자바로 구현
		 * 	- 파일/디렉토리 정보 열람
		 * 	- 생성, 수정, 삭제, 이동 등..
		 * 
		 * 2. 파일 입출력
		 * 
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
//		m9();
//		m10();
		m11();
	}

	private static void m11() {
//		폴더 삭제
		String path = "C:\\class\\code\\java\\file\\aaa";
		
		File file = new File(path);
		
//		자식 폴더나 파일이 있으면 삭제가 안됨
		System.out.println(file.delete());
	}

	private static void m10() {
//		폴더명 수정 or 폴더 이동
//		- renameTo
		
		String path = "C:\\class\\code\\java\\file\\member\\";
		String path2 = "C:\\class\\dev\\member\\";
		
		File dir = new File(path);
		File dir2 = new File(path2);
		
		System.out.println(dir.renameTo(dir2));
	}

	private static void m9() {
//		요구사항] 일정관리 > 날짜별 폴더 생성 > 2024-01-01 ~ 2024-12-31
//		- 폴더 366개 생성
		
		Calendar c = Calendar.getInstance();
		c.set(2024, 0, 1);
//		System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for(int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			String path = String.format("C:\\class\\code\\java\\file\\일정\\%tF", c);
			File file = new File(path);
			file.mkdirs();
			System.out.printf("%tF\n", c);
			c.add(Calendar.DATE, 1);
		}
	}

	private static void m8() {
//		요구사항] 회원 정보 > 회원명으로 개인 폴더 생성
		String[] member = { "홍길동", "아무개", "강아지", "고양이", "병아리" };
		
		for(int i=0; i<member.length; i++) {
			String path = "C:\\class\\code\\java\\file\\회원\\"+member[i];
			File dir = new File(path);
			dir.mkdir();
		}
	}

	private static void m7() {
//		폴더 조작
//		String path = "C:\\class\\code\\java\\file\\aaa";
//		File dir = new File(path);
		
//		마지막 폴더만 생성
//		System.out.println(dir.mkdir());
		
		String path = "C:\\class\\code\\java\\file\\bbb\\ccc\\ddd";
		
		File dir = new File(path);
		
//		모든 존재하지 않은 경로까지 생성해줌
		System.out.println(dir.mkdirs());
	}

	private static void m6() {
//		파일 삭제
		String path = "C:\\class\\code\\java\\file\\data.txt";
		
		File file = new File(path);
		
//		보통 삭제: 휴지통 폴더로 이동하기
//		진짜 삭제: 복구 불가능
		System.out.println(file.delete());
	}

	private static void m5() {
//		파일 이동
		String path = "C:\\class\\code\\java\\file\\score.txt";
		String path2 = "C:\\class\\dev\\score.txt";
		
		File file = new File(path);
		File file2 = new File(path2);
		
		System.out.println(file.renameTo(file2));
	}

	private static void m4() {
//		파일명 수정
		String path = "C:\\class\\code\\java\\file\\score.txt";
		String path2 = "C:\\class\\code\\java\\file\\jumsu.txt";
		
		File file = new File(path);
		File file2 = new File(path2);
		
		System.out.println(file.renameTo(file2));
	}

	private static void m3() {
//		파일 조작 > 생성, 복사, 이동, 파일면 수정, 삭제 등..
		
//		생성
		String path = "C:\\class\\code\\java\\file\\score.txt";
		
		File file = new File(path);
		
		try {
//			기존에 동일파일이 있으면 동작 안함
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
//		🌟🌟🌟 폴더는 파일이다.
		
//		C:\class\code\java\file
		
//		폴더 경로
		String path = "C:\\class\\code\\java\\file";
		
//		폴더 참조 객체
		File dir = new File(path);

		System.out.println(dir.getName());			//file
		System.out.println(dir.isFile());			//false
		System.out.println(dir.isDirectory());		//true
		System.out.println(dir.length());			//0 > 무조건 폴더의 크기는 0이다.
		System.out.println(dir.getAbsolutePath());	//C:\class\code\java\file
		System.out.println(dir.lastModified());		//1720506662463
		System.out.println(dir.isHidden());			//false
		System.out.println(dir.canRead());			//true
		System.out.println(dir.canWrite());			//true
		System.out.println(dir.getParent());		//C:\class\code\java
	}

	private static void m1() {
//		C:\class\code\java\file\data.txt
		
//		자바 프로그램 > (접근) > 외부 파일
//		1. 외부 파일을 참조하는 객체를 생성 > 중계인(대리인)
//		2. 참조 객체 조작 > 실제 파일에 적용
		
//		파일 경로
		String path = "C:\\class\\code\\java\\file\\data.txt";
		
//		파일 참조 객체 > java.io.File 클래스
		File file = new File(path);
		
//		System.out.println(file.exists());
		
		if(file.exists()) {
//			파일 정보
			System.out.println(file.getName());			//data.txt
			System.out.println(file.isFile());			//true
			System.out.println(file.isDirectory());		//false
			System.out.println(file.length());			//15 > 파일 크기(바이트)
			System.out.println(file.getAbsolutePath());	//C:\class\code\java\file\data.txt
			System.out.println(file.lastModified());	//1720505943289
			
			Calendar c1 = Calendar.getInstance();
			c1.setTimeInMillis(file.lastModified());
			System.out.println(String.format("%tF %tT", c1, c1));
			
			System.out.println(file.isHidden());		//false
			System.out.println(file.canRead());			//true
			System.out.println(file.canWrite());		//true
			System.out.println(file.getParent());		//C:\class\code\java\file
		} else {
			System.out.println("파일이 없습니다.");
		}
	}
}
