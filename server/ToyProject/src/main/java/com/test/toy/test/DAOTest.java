package com.test.toy.test;

import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

public class DAOTest {
	public static void main(String[] args) {
		/*
		UserDAO dao1 = new UserDAO();
		UserDAO dao2 = new UserDAO();
		
		System.out.println(dao1 == dao2);		// false
		System.out.println(dao1.equals(dao2));	// false
		*/
		
		UserDAO dao3 = UserDAO.getInstance();
		UserDAO dao4 = UserDAO.getInstance();
		
		System.out.println(dao3 == dao4);		// true
		System.out.println(dao3.equals(dao4));	// true
		
		testUnit();
	}
	
	public static void testUnit() {
//		원래 하던 단위테스트 방법
		UserDAO dao = UserDAO.getInstance();
		
		UserDTO dto = new UserDTO();
		
		dto.setId("cow");
		dto.setPw("1111");
		dto.setName("음메소");
		dto.setEmail("cow@email.com");
		dto.setIntro("안녕하세요. 소입니다.");
		
		int result = dao.register(dto);
		System.out.println(result);
		
//		JUnit
//		이클립스에서 기본적으로 깔려 있음
//		Project 우클릭 > Build Path > Configure Build Path
//		기본 소스
//		소스폴더(src/main/java) > 우리가 package 만들던 폴더
		
//		나중에 헷갈리지 말라고 패키지 이름은 똑같이 만듦
		
	}
}
