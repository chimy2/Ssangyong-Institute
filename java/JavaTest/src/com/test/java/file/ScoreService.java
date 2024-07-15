package com.test.java.file;

import java.util.Scanner;

//업무 구현 클래스
public class ScoreService {
//비즈니스 업무(주요 업무)를 할때 주로 ~Service라고 클래스를 만듦
	
	private ScoreView view;
	private ScoreDAO dao;
	private Scanner scan;
	
	public ScoreService() {
		view = new ScoreView();
		dao = new ScoreDAO();
		scan = new Scanner(System.in);
	}

	public void add() {
//		성적 추가
		String name = "";
		int kor = 0;
		int eng = 0;
		int math = 0;
		
//		성적 추가
		view.subTitle("성적추가");
		
		System.out.print("이름: ");
		name = scan.nextLine();
		
		System.out.print("국어: ");
		kor = scan.nextInt();
		
		System.out.print("영어: ");
		eng = scan.nextInt();
		
		System.out.print("수학: ");
		math = scan.nextInt();
		scan.skip("\r\n");
		
//		데이터 집합
//		1. 배열
//		2. 컬렉션 > List vs Map > Map > HashMap<String, Integer>
//		3. 클래스 > 적합
		
//		인자의 개수가 2개 이상이면 직접 전달X > 상자(데이터 집합) 포장 > 상자
//		상자 역할 클래스
//		- ScoreDTO(Data Transfer Object)
//		- ScoreVO(Value Object)
//		- ScoreEntity
		
//		dao.add(name, kor, eng, math);
		ScoreDTO dto = new ScoreDTO();
		
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		
		dao.add(dto);
		
		System.out.println("성적추가 완료");
		
//		잠시 멈춤
		view.pause();
	}

	public void get() {
//		특정 학생의 성적 확인
		view.subTitle("성적확인");
		
		System.out.print("학생명: ");
		String name = scan.nextLine();
		
		ScoreDTO dto = dao.get(name);
		if(dto != null) {
			System.out.printf("이름: %s\n", dto.getName());
			System.out.printf("국어: %d\n", dto.getKor());
			System.out.printf("영어: %d\n", dto.getEng());
			System.out.printf("수학: %d\n", dto.getMath());
		} else {
			System.out.println("학생이 없습니다");
		}
		
		view.pause();
	}

	public void edit() {
//		특정 학생의 성적 수정
		view.subTitle("성적수정");
		
		System.out.print("학생명: ");
		String name = scan.nextLine();
		
		ScoreDTO dto = dao.get(name);
		
		if(dto != null) {
//			System.out.println(dto);
			
			System.out.printf("국어: %d점\n", dto.getKor());
			System.out.print("수정: ");
			int kor = scan.nextInt();
			if(kor != -1) {
				dto.setKor(kor);
			}
			
			System.out.printf("영어: %d점\n", dto.getEng());
			System.out.print("수정: ");
			int eng = scan.nextInt();
			if(eng != -1) {
				dto.setEng(eng);
			}
			
			System.out.printf("수학: %d점\n", dto.getMath());
			System.out.print("수정: ");
			int math = scan.nextInt();
			if(math != -1) {
				dto.setMath(math);
			}

			scan.skip("\r\n");
			
//			이곳 > ScoreDTO
//			System.out.println(dto);
			
			dao.edit(dto);
		} else {
			System.out.println("학생이 없습니다.");
		}

		view.pause();
	}

	public void remove() {
//		특정 학생의 성적 삭제
		view.subTitle("성적삭제");
		
		System.out.print("학생명: ");
		String name = scan.nextLine();
		
		ScoreDTO dto = dao.get(name);
		
		if(dto != null) {
//			성적 삭제
			dao.remove(dto);
		} else {
			System.out.println("학생이 없습니다.");
		}
		
		view.pause();
	}
	
}
