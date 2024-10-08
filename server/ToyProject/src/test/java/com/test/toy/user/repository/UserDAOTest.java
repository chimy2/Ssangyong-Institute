package com.test.toy.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.toy.user.model.UserDTO;

class UserDAOTest {
// 우리가 테스트할 Class 이름에 접미어로 Test를 붙여 생성하는 것이 관례다
	private static UserDAO dao;
	
//	일반 클래스에서는 생성자에서 초기화를 하지만
//	test
	@BeforeAll
//	모든 테스트를 하기 전에 한번 호출
//	@BeforeEach
//	모든 테스트를 할때 마다 한번씩 호출
	static void init() {
		dao = UserDAO.getInstance();
	}
	
//	Test annotation이 붙은 method는 main 메소드 없이도 무조건 실행된다
	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
//	보통 함수명도 접두어나 접미사로 test를 붙여 명명함

	@Disabled
	@Test
	void testRegister() {
//		DAO의 회원 가입 기능
		UserDAO dao = UserDAO.getInstance();
		
		UserDTO dto = new UserDTO();
		
		dto.setId("ccc");
		dto.setPw("1111");
		dto.setEmail("ccc@gmail.com");
		dto.setName("하하하");
		dto.setPic("pic.png");
		dto.setIntro("안녕하세요. 하하하입니다.");
		
		int result = dao.register(dto);
		
//		assertXXX()
//		최종 검증하고 알려주는 메소드
		assertEquals(1, result);
	}
	
	@Disabled
	@Test
	void testLogin() {
		UserDAO dao = UserDAO.getInstance();
		
		String id = "hong";
		String pw = "1111";
		
		UserDTO dto = new UserDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO result = dao.login(dto);
		
		assertNotNull(result);
	}

	@Disabled
	@Test
	void testLogin2() {
		UserDAO dao = UserDAO.getInstance();
		
		String id = "hong";
		String pw = "1112";
		
		UserDTO dto = new UserDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO result = dao.login(dto);
		
		assertNotNull(result);
	}

	@Disabled
	@Test
	void testLogin3() {
		UserDAO dao = UserDAO.getInstance();
		
		String id = "hong";
		String pw = "1111";
		
		UserDTO dto = new UserDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO result = dao.login(dto);
		
		assertEquals("홍길동", result.getName());
	}
	
	@Test
	void testGetUser() { 
		String id = "hong";
		UserDTO dto = dao.getUser(id);
		
		assertNotNull(dto);
		assertEquals("홍길동", dto.getName());
	}
}
