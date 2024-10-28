package com.test.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.dao.BoardDAO;
import com.test.spring.dto.BoardDTO;
import com.test.spring.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBTest {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	@Ignore
	public void testMapper() {
		String name = mapper.getName("dog");
		
		System.out.println(name);
	}
	
//	ERROR: org.springframework.test.context.TestContextManager - Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@58695725] to prepare test instance [com.test.spring.DBTest@24e08d59]
//			org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'com.test.spring.DBTest': Unsatisfied dependency expressed through field 'dao'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.test.spring.dao.BoardDAO' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	@Test
	public void testAdd() {
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject("단위 테스트"); 
		dto.setContent("내용");
		dto.setMemberid("dog");
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
	}
}
