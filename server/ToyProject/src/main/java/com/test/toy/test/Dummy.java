package com.test.toy.test;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

public class Dummy {
	
	public static void main(String[] args) {
		m1();
	}
	
	private static void m1() {
//		페이징 게시물 작성
		int count = 0;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = new BoardDTO();
		
		String[] users = { "hong", "dog", "cat" }; 
		dto.setContent("내용");
		
		for (int i=0; i<250; i++) {
			
			dto.setId(users[i % 3]);
			dto.setSubject("게시판 페이징 처리.. " + i);
			
			int result = dao.add(dto);
//			System.out.println(result);
			count += result;
		}
		
		System.out.printf("총 %d개 생성 성공", count);
	}
}
