package com.lesson.java.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Ex54_File {
	
	private static int fileCount;
	private static int dirCount;
	private static long dirSize; 
	
	public static void main(String[] args) {
		
		//Ex54_File.java
		/*
		
			1. 파일/디렉토리 조작
				- 윈도우 탐색기로 하는 행동 > 자바로 구현
				- 파일/디렉토리 정보 열람
				- 생성, 수정, 삭제, 이동 등..
			
			2. 파일 입출력

		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		
		//m12();
		//m13();
		m14();
		
	}//main

	private static void m13() {
		
		//폴더 크기? > 재귀 구조
		String path = "C:\\class\\code\\java\\file";
		File dir = new File(path);
		
		int count = 0; //파일 개수
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles(); //file 폴더(부모)
			
			for (File file : list) {
				if (file.isFile()) {
					count++;
				}
			}
			
			for (File subdir : list) {
				if (subdir.isDirectory()) {
					
					//자식 폴더 내용
					File[] sublist = subdir.listFiles(); //자식 폴더
					
					for (File subfile : sublist) {
						if (subfile.isFile()) {
							count++;
						}
					}
					
					for (File subsubdir : sublist) {
						if (subsubdir.isDirectory()) {
							
							//자식의 자식 폴더
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubfile : subsublist) {
								if (subsubfile.isFile()) {
									count++;
								}
							}
							
						}
					}
					
				}
			}
			
			
			System.out.printf("파일 개수: %d개\n", count);
			
		}//if
		
		
	}

	private static void m14() {
		
		//폴더 > 크기?
		//1. 크기 > 735MB (771,006,759 바이트)
		//2. 내용 > 파일 11,737, 폴더 2,494
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			count(dir);
			
			System.out.printf("총 파일 개수: %,d개\n", fileCount);
			System.out.printf("총 폴더 개수: %,d개\n", dirCount);
			System.out.printf("폴더 크기: %,dB\n", dirSize);
			
		}
		
	}

	public static void count(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File file : list) {
			if (file.isFile()) {
				fileCount++;
				dirSize += file.length();
			}
		}
		
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				dirCount++;
				count(subdir);
			}
		}
		
	}

	private static void m12() {
		
		//특정 폴더 > 내용물 열람(파일, 자식폴더)
		
		String path = "C:\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			//1. dir.list()
			//2. dir.listFile()
			
			//Returns an array of strings naming the files and directories
//			String[] list = dir.list(); //파일 + 폴더
//			
//			for (String item : list) {
//				
//				//가져온 item이 폴더? 파일?
//				System.out.println(item);
//				
//				File subFile = new File(path + "\\" + item);
//				
//				System.out.println(subFile.isFile() ? "파일" : "폴더");
//				System.out.println();
//				
//			}
			
			
//			String[] list = dir.list(); > 이름 > 가공 > File 
			File[] list = dir.listFiles();
			
//			for (File item : list) {
//				System.out.println(item.getName());
//				System.out.println(item.isFile());
//			}
			
			
			for (File item : list) {
				if (item.isDirectory()) {
					System.out.printf("📁%s\n", item.getName());
				}
			}
			
			for (File item : list) {
				if (item.isFile()) {
					System.out.printf("📄%s\n", item.getName());
				}
			}
			
		} else {
			System.out.println("폴더가 없습니다.");
		}
		
	}

	private static void m11() {
		
		//폴더 삭제
		String path  = "C:\\class\\code\\java\\file\\일정";
		File dir = new File(path);
		
		System.out.println(dir.delete());
		
	}

	private static void m10() {
		
		//폴더명 수정 or 폴더 이동
		//- renameTo
		String path  = "C:\\class\\code\\java\\file\\member";
		String path2 = "C:\\class\\dev\\member";
		
		File dir = new File(path);
		File dir2 = new File(path2);
		
		System.out.println(dir.renameTo(dir2));
		
	}

	private static void m9() {
		
		//요구사항] 일정관리 > 날짜별 폴더 생성 > 2024-01-01 ~ 2024-12-31
		//- 폴더 366개 생성
		
		Calendar c = Calendar.getInstance();
		c.set(2024, 0, 1);
		
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for (int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			String path 
				= String.format("C:\\class\\code\\java\\file\\일정\\%tF", c);
			File dir = new File(path);
			dir.mkdirs();
			
			System.out.printf("%tF\n", c);
			c.add(Calendar.DATE, 1);
			
		}
		
	}

	private static void m8() {
		
		//요구사항] 회원 정보 > 회원명으로 개인 폴더 생성
		String[] member = { "홍길동", "아무개", "강아지", "고양이", "병아리" };
		
		for (int i=0; i<member.length; i++) {
			
			String path = "C:\\class\\code\\java\\file\\회원\\" + member[i];
			
			File dir = new File(path);
			
			System.out.println(dir.mkdir());
			
		}
		
	}

	private static void m7() {
		
		//폴더 조작
//		String path =  "C:\\class\\code\\java\\file\\aaa";
//		File dir = new File(path);
//		
//		System.out.println(dir.mkdir());
		
		
		String path =  "C:\\class\\code\\java\\file\\bbb\\ccc\\ddd";
		File dir = new File(path);
		
		System.out.println(dir.mkdirs());
		
	}

	private static void m6() {
		
		//파일 삭제
		String path =  "C:\\class\\code\\java\\file\\data.txt";
		File file = new File(path);
		
		//보통 삭제: 휴지통 폴더로 이동하기
		//진짜 삭제: 복구 불가능
		System.out.println(file.delete());
		
	}

	private static void m5() {
		
		//파일 이동
		String path =  "C:\\class\\code\\java\\file\\score.txt";
		String path2 = "C:\\class\\dev\\score.txt";
		
		File file = new File(path);
		File file2 = new File(path2);
		
		System.out.println(file.renameTo(file2));
		
	}

	private static void m4() {
		
		//파일명 수정
		String path =  "C:\\class\\code\\java\\file\\score.txt";
		String path2 = "C:\\class\\code\\java\\file\\jumsu.txt";
		
		File file = new File(path);
		File file2 = new File(path2);
		
		System.out.println(file.renameTo(file2));
		
	}

	private static void m3() {
		
		//파일 조작 > 생성, 복사(X), 이동, 파일명 수정, 삭제 등..
		
		//생성
		String path = "C:\\class\\code\\java\\file\\score.txt";
		
		File file = new File(path);
		
		try {
			//기존에 동일파일이 있으면 동작 안함
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		//*** 폴더는 파일이다.
		
		//C:\class\code\java\file
		
		//폴더 경로
		String path = "C:\\class\\code\\java\\file";
		
		//폴더 참조 객체
		File dir = new File(path);
		
		if (dir.exists()) {
			System.out.println(dir.getName()); //file
			System.out.println(dir.isFile()); //false
			System.out.println(dir.isDirectory()); //true
			System.out.println(dir.length()); //무조건 폴더의 크기는 0이다.
			System.out.println(dir.getAbsolutePath());
			System.out.println(dir.lastModified());
			System.out.println(dir.isHidden());
			System.out.println(dir.canRead());
			System.out.println(dir.canWrite());
			System.out.println(dir.getParent());
		}
		
	}

	private static void m1() {
		
		//C:\class\code\java\file\data.txt
		
		//자바 프로그램 > (접근) > 외부 파일
		//1. 외부 파일을 참조하는 객체를 생성 > 중계인(대리인)
		//2. 참조 객체 조작 > 실제 파일에 적용
		
		//파일 경로
		String path = "C:\\class\\code\\java\\file\\data.txt";
		
		//파일 참조 객체 > java.io.File 클래스
		File file = new File(path);
		
		//System.out.println(file.exists());
		
		if (file.exists()) {
			
			//파일 정보
			System.out.println(file.getName()); //data.txt
			System.out.println(file.isFile()); //true
			System.out.println(file.isDirectory()); //false
			System.out.println(file.length()); //16 > 파일 크기(바이트)
			System.out.println(file.getAbsolutePath()); //C:\class\code\java\file\data.txt
			System.out.println(file.lastModified()); //1720505504358
			
			Calendar c1 = Calendar.getInstance();
			c1.setTimeInMillis(file.lastModified()); //tick > Calendar
			System.out.printf("%tF %tT\n", c1, c1); //2024-07-09 15:11:44
			
			System.out.println(file.isHidden()); //false
			System.out.println(file.canRead()); //true
			System.out.println(file.canWrite()); //true > false
			
			System.out.println(file.getParent()); //C:\class\code\java\file
			
		} else {
			System.out.println("파일이 없습니다.");
		}
		
	}

}









