package com.test.toy.board.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.test.toy.board.model.BoardDTO;

public class BoardDAOTest {
	
	private static BoardDAO dao;
	
	@BeforeAll
	static void init() {
		dao = BoardDAO.getInstance();
	}

	@DisplayName("게시판 글을 작성합니다.")
	@Test
	void testAdd() {
//		System.out.println(100);
		
		BoardDTO dto = new BoardDTO();
		
		dto.setId("hong");
		dto.setSubject("게시판입니다.");
		dto.setContent("내용입니다.");
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
	}
	
	@Disabled
	@DisplayName("제목을 빼고 글을 작성합니다.")
	@Test
	void testAdd2() {
		BoardDTO dto = new BoardDTO();
		
		dto.setId("hong");
		dto.setSubject(null);
		dto.setContent("내용입니다.");
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
	}
	
	@Disabled
	@DisplayName("로그인을 안했는데 글을 작성합니다.")
	@Test
	void testAdd3() {
		BoardDTO dto = new BoardDTO();
		
		dto.setId(null);
		dto.setSubject("제목입니다.");
		dto.setContent("내용입니다.");
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
	}
	
	@DisplayName("목록을 가져옵니다.")
	@Test
	void testList() {
//		ArrayList<BoardDTO> list = dao.list();
//		
//		System.out.println(list.get(0));
//		
//		assertEquals(1, list.size());
	}
	
	@DisplayName("날짜를 가공해서목록을 가져옵니다.")
	@Test
	void testList2() {
//		ArrayList<BoardDTO> list = dao.list();
//		
////		System.out.println(list.get(0));
//		
//		assertEquals(7, list.size());
//		
//		System.out.println(list.get(0).getRegtime());
//		System.out.println(list.get(4).getRegtime());
	}
	
	@Disabled
	@DisplayName("글 1개를 상세보기합니다.")
	@Test
	void testGet() {
		
		String seq = "1";
		
		BoardDTO dto = dao.get(seq);
		
		assertNotNull(dto);
		assertEquals("게시판입니다.", dto.getSubject());
		assertEquals("1", dto.getSeq());
	}
	
	@DisplayName("1번 글의 조회수를 증가시킵니다.")
	@Test
	void testUpdateReadcount() {
		String seq = "11";
		
		int count = dao.get(seq).getReadcount();
		
		dao.updateReadcount(seq);
		
		assertEquals(count + 1, dao.get(seq).getReadcount());
	}
	
	@DisplayName("제목/내용을 수정합니다.")
	@Test
	void testEdit() {
		Calendar now = Calendar.getInstance();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject("제목입니다. " + String.format("%tT", now));
		dto.setContent("내용입니다. " + String.format("%tT", now));
		dto.setSeq("1");
		
		int result = dao.edit(dto);
		
		assertEquals(1, result);
	}
	
	@Disabled
	@DisplayName("게시물을 삭제합니다.")
	@Test
	void testDel() {
//		테스트를 할 때는 함수의 순서의 영향을 
		String seq = "1";
		
		int result = dao.del(seq);
		
		assertEquals(1, result);
		assertNull(dao.get(seq));
	}
}
